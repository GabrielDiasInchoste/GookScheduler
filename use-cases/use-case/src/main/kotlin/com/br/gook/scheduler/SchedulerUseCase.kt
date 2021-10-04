package com.br.gook.scheduler

import com.br.gook.data.input.SchedulerInputPort
import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.SchedulerUseCaseInput
import com.br.gook.port.output.CourtRepositoryOutput
import com.br.gook.port.output.SchedulerRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class SchedulerUseCase(
    val schedulerRepositoryOutput: SchedulerRepositoryOutput,
    val courtRepositoryOutput: CourtRepositoryOutput
) : SchedulerUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findScheduler(schedulerId: Long): SchedulerOutputPort {

        log.info("SchedulerUseCase.findScheduler - Start - schedulerId : $schedulerId")
        val response = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        log.info("SchedulerUseCase.findScheduler - End - response : $response")

        return response
    }

    override fun createScheduler(schedulerInputPort: SchedulerInputPort): SchedulerOutputPort {
        log.info("SchedulerUseCase.createScheduler - Start - schedulerInputPort : $schedulerInputPort")
        val court = courtRepositoryOutput.findCourtByIdOrThrow(schedulerInputPort.courtId)
        val response = schedulerRepositoryOutput.saveScheduler(schedulerInputPort.toOutputPort(court))
        log.info("SchedulerUseCase.createScheduler - End - response : $response")
        return response

    }

    override fun updateScheduler(
        schedulerId: Long,
        updateSchedulerPort: UpdateSchedulerInputPort
    ): SchedulerOutputPort {

        log.info("SchedulerUseCase.updateScheduler - Start - schedulerId : $schedulerId , updateSchedulerPort : $updateSchedulerPort")
        val schedulerPort = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        val response = schedulerRepositoryOutput.saveScheduler(
            updateSchedulerPort.toPort(schedulerPort)
        )
        log.info("SchedulerUseCase.updateScheduler - End - response : $response")
        return response
    }

    override fun deleteScheduler(schedulerId: Long) {
        log.info("SchedulerUseCase.deleteScheduler - Start - schedulerId : $schedulerId")
        val response = schedulerRepositoryOutput.deleteScheduler(schedulerId)
        log.info("SchedulerUseCase.deleteScheduler - End - response : $response")
    }

}