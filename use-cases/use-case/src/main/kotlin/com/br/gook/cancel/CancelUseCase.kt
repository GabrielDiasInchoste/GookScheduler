package com.br.gook.cancel

import com.br.gook.data.input.CancelInputPort
import com.br.gook.data.input.UpdateCancelInputPort
import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.CancelUseCaseInput
import com.br.gook.port.output.SchedulerRepositoryOutput
import com.br.gook.port.output.CancelRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class CancelUseCase(
    val cancelRepositoryOutput: CancelRepositoryOutput,
    val schedulerRepositoryOutput: SchedulerRepositoryOutput
) : CancelUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun createCancel(schedulerId: Long, cancelInputPort: CancelInputPort): SchedulerOutputPort {
        log.info("CancelUseCase.createCancel - Start - schedulerId : $schedulerId ,cancelInputPort : $cancelInputPort")
        val scheduler = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        val response = cancelRepositoryOutput.saveCancel(scheduler.copy(cancel = cancelInputPort.toOutputPort()))
        log.info("CancelUseCase.createCancel - End - response : $response")
        return response

    }

    override fun updateCancel(cancelId: Long, updateCancelInputPort: UpdateCancelInputPort): CancelOutputPort {

        log.info("CancelUseCase.updateCancel - Start - cancelId : $cancelId , updateCancelInputPort : $updateCancelInputPort")
        val cancelPort = cancelRepositoryOutput.findCancelByIdOrThrow(cancelId)
        val response = cancelRepositoryOutput.updateCancel(
            updateCancelInputPort.toPort(cancelPort)
        )
        log.info("CancelUseCase.updateCancel - End - response : $response")
        return response
    }

}