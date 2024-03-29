package com.br.gook.scheduler

import com.br.gook.data.input.*
import com.br.gook.data.output.PageSchedulerResponseOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.SchedulerUseCaseInput
import com.br.gook.port.output.CourtRepositoryOutput
import com.br.gook.port.output.FirebaseNotificationServiceOutput
import com.br.gook.port.output.SchedulerRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class SchedulerUseCase(
    val schedulerRepositoryOutput: SchedulerRepositoryOutput,
    val courtRepositoryOutput: CourtRepositoryOutput,
    val firebaseNotificationServiceOutput: FirebaseNotificationServiceOutput
) : SchedulerUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findScheduler(schedulerId: Long): SchedulerOutputPort {
        try {
            log.info("SchedulerUseCase.findScheduler - Start - schedulerId : $schedulerId")
            val response = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
            log.info("SchedulerUseCase.findScheduler - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.findScheduler - Error to Find Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun findAllSchedulerWithPaginate(
        pageRequest: PageRequest,
        pageSchedulerInputPort: PageSchedulerInputPort
    ): PageSchedulerResponseOutputPort {
        try {
            log.info("SchedulerUseCase.findAllSchedulerWithPaginate - Start - schedulerId : ")

            val response = schedulerRepositoryOutput.findAllSchedulerWithPaginate(
                pageRequest,
                pageSchedulerInputPort.toOutputPort()
            )
            log.info("SchedulerUseCase.findAllSchedulerWithPaginate - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.findScheduler - Error to Find Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createScheduler(schedulerInputPort: SchedulerInputPort): SchedulerOutputPort {
        try {
            log.info("SchedulerUseCase.createScheduler - Start - schedulerInputPort : $schedulerInputPort")
            val court = courtRepositoryOutput.findCourtByIdOrThrow(schedulerInputPort.courtId)
            val response = schedulerRepositoryOutput.saveScheduler(schedulerInputPort.toOutputPort(court))
            log.info("SchedulerUseCase.createScheduler - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.createScheduler - Error to Create Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun confirmScheduler(confirmSchedulerInputPort: ConfirmSchedulerInputPort): SchedulerOutputPort {
        try {
            log.info("SchedulerUseCase.confirmScheduler - Start - confirmSchedulerInputPort : $confirmSchedulerInputPort")

            val schedulerOutputPort =
                schedulerRepositoryOutput.findSchedulerByIdOrThrow(confirmSchedulerInputPort.schedulerId)
            val response =
                schedulerRepositoryOutput.updateScheduler(confirmSchedulerInputPort.toOutputPort(schedulerOutputPort))
            if (response.tokenSendPush != null) {

                firebaseNotificationServiceOutput.sendPush(
                    NotificationInputPort(
                        response.tokenSendPush!!,
                        "Agendamento Aprovado",
                        "O local aprovou o agendamento solicitado"
                    )
                )
            }

            log.info("SchedulerUseCase.confirmScheduler - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.confirmScheduler - Error to Confirm Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun updateScheduler(
        schedulerId: Long,
        updateSchedulerPort: UpdateSchedulerInputPort
    ): SchedulerOutputPort {
        try {
            log.info("SchedulerUseCase.updateScheduler - Start - schedulerId : $schedulerId , updateSchedulerPort : $updateSchedulerPort")
            val schedulerPort = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
            val response = schedulerRepositoryOutput.updateScheduler(updateSchedulerPort.toPort(schedulerPort))
            log.info("SchedulerUseCase.updateScheduler - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("SchedulerUseCase.updateScheduler - Error to Update Scheduler - Error : ${ex.message}", ex)
            throw ex
        }
    }
}