package com.br.gook.scheduler

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.SchedulerUseCaseInput
import com.br.gook.port.output.SchedulerRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class SchedulerUseCase(
    val schedulerRepositoryOutput: SchedulerRepositoryOutput
) : SchedulerUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findScheduler(schedulerId: Int): SchedulerOutputPort {

        log.info("SchedulerUseCase.findScheduler - Start - schedulerId : $schedulerId")
        val response = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        log.info("SchedulerUseCase.findScheduler - End - response : $response")

        return response
    }

    override fun createScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort {
        log.info("SchedulerUseCase.createScheduler - Start - schedulerPort : $schedulerPort")
        val response = schedulerRepositoryOutput.saveScheduler(schedulerPort)
        log.info("SchedulerUseCase.createScheduler - End - response : $response")
        return response

    }

    override fun updateScheduler(schedulerId: Int, updateSchedulerPort: UpdateSchedulerInputPort): SchedulerOutputPort {

        log.info("SchedulerUseCase.updateScheduler - Start - schedulerId : $schedulerId , updateSchedulerPort : $updateSchedulerPort")
        val schedulerPort = schedulerRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        val response = schedulerRepositoryOutput.saveScheduler(
            updateSchedulerPort.toPort(schedulerPort)
        )
        log.info("SchedulerUseCase.updateScheduler - End - response : $response")
        return response
    }

    override fun deleteScheduler(schedulerId: Int) {
        log.info("SchedulerUseCase.deleteScheduler - Start - schedulerId : $schedulerId")
        val response = schedulerRepositoryOutput.deleteScheduler(schedulerId)
        log.info("SchedulerUseCase.deleteScheduler - End - response : $response")
    }

}