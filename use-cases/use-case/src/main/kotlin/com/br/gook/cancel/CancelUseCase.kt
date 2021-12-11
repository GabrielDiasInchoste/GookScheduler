package com.br.gook.cancel

import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.input.CancelConfirmInputPort
import com.br.gook.data.input.CancelInputPort
import com.br.gook.data.input.UpdateCancelInputPort
import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.CancelUseCaseInput
import com.br.gook.port.output.CancelRepositoryOutput
import com.br.gook.port.output.FirebaseNotificationServiceOutput
import com.br.gook.port.output.SchedulerRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CancelUseCase(
    val cancelRepositoryOutput: CancelRepositoryOutput,
    val schedulerRepositoryOutput: SchedulerRepositoryOutput,
    val firebaseNotificationServiceOutput: FirebaseNotificationServiceOutput
) : CancelUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun requestCancel(schedulerId: Long, cancelInputPort: CancelInputPort): SchedulerOutputPort {
        try {
            log.info("CancelUseCase.createCancel - Start - schedulerId : $schedulerId ,cancelInputPort : $cancelInputPort")
            val scheduler = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
            val response = cancelRepositoryOutput.saveCancel(
                scheduler.copy(
                    status = SchedulerStatusPort.CANCEL_REQUESTED,
                    cancel = cancelInputPort.toOutputPort()
                )
            )
            log.info("CancelUseCase.createCancel - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CancelUseCase.createCancel - Error to Create Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun updateCancel(cancelId: Long, updateCancelInputPort: UpdateCancelInputPort): CancelOutputPort {
        try {
            log.info("CancelUseCase.updateCancel - Start - cancelId : $cancelId , updateCancelInputPort : $updateCancelInputPort")
            val cancelPort = cancelRepositoryOutput.findCancelByIdOrThrow(cancelId)
            val response = cancelRepositoryOutput.updateCancel(
                updateCancelInputPort.toPort(cancelPort)
            )
            log.info("CancelUseCase.updateCancel - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CancelUseCase.updateCancel - Error to Update Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun confirmCancel(cancelConfirmInputPort: CancelConfirmInputPort): SchedulerOutputPort {
        try {
            log.info("CancelUseCase.confirmCancel - Start - cancelConfirmInputPort : $cancelConfirmInputPort")
            val scheduler = schedulerRepositoryOutput.findSchedulerByIdOrThrow(cancelConfirmInputPort.schedulerId)
            if (scheduler.cancel != null) {
                val response = cancelRepositoryOutput.saveCancel(
                    scheduler.copy(
                        status = SchedulerStatusPort.CANCELED,
                        cancel = scheduler.cancel!!.copy(
                            cancelConfirmedDate = LocalDateTime.now()
                        )
                    )
                )
                firebaseNotificationServiceOutput.sendPush(response.tokenSendPush!!)
                log.info("CancelUseCase.confirmCancel - End - response : $response")
                return response
            } else {
                log.error("CancelUseCase.confirmCancel - Cancel not Requested - cancelConfirmInputPort : $cancelConfirmInputPort")
                throw Exception("CancelUseCase.confirmCancel - Cancel not Requested - cancelConfirmInputPort : $cancelConfirmInputPort")
            }

        } catch (ex: Exception) {
            log.error("CancelUseCase.confirmCancel - Error to Confirm Cancel - Error : ${ex.message}", ex)
            throw ex
        }
    }
}