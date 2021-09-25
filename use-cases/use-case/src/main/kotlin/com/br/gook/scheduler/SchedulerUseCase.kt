package com.br.gook.scheduler

import com.br.gook.data.SchedulerPort
import com.br.gook.port.input.SchedulerUseCaseInput
import com.br.gook.port.output.PostgresRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class SchedulerUseCase(
    val postgresRepositoryOutput: PostgresRepositoryOutput
) : SchedulerUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findScheduler(schedulerId: Int): SchedulerPort {

        log.info("SchedulerUseCase.findScheduler - Start - schedulerId : $schedulerId")
        val response = postgresRepositoryOutput.findSchedulerByIdOrThrow(schedulerId)
        log.info("SchedulerUseCase.findScheduler - End - response : $response")

        return response
    }

    override fun createScheduler(schedulerPort: SchedulerPort): SchedulerPort {
        log.info("SchedulerUseCase.createScheduler - Start - schedulerPort : $schedulerPort")
        val response = postgresRepositoryOutput.saveScheduler(schedulerPort)
        log.info("SchedulerUseCase.createScheduler - End - response : $response")
        return response

    }

    override fun updateScheduler(schedulerId: Int, schedulerPort: SchedulerPort): SchedulerPort {
        TODO("Pensar melhor como fazer o update sem precisar de todos os dados mudar apenas os q tao sendo enviados")

//        log.info("SchedulerUseCase.updateScheduler - Start - schedulerId : $schedulerId , updateSchedulerPort : $updateSchedulerPort")
//        val response = postgresRepositoryOutput.updateScheduler(schedulerPort)
//        log.info("SchedulerUseCase.updateScheduler - End - response : $response")
//        return response
    }

    override fun deleteScheduler(schedulerId: Int) {
        log.info("SchedulerUseCase.deleteScheduler - Start - schedulerId : $schedulerId")
        val response = postgresRepositoryOutput.deleteScheduler(schedulerId)
        log.info("SchedulerUseCase.deleteScheduler - End - response : $response")
    }


}