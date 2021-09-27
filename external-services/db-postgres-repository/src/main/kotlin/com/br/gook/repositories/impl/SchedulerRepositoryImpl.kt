package com.br.gook.repositories.impl

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.port.output.SchedulerRepositoryOutput
import com.br.gook.repositories.interfaces.SchedulerRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class SchedulerRepositoryImpl(
    private val schedulerRepository: SchedulerRepository
) : SchedulerRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort {
        schedulerRepository.findById(schedulerPort.id).ifPresent {
            log.error("SchedulerRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
            throw Exception("SchedulerRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
        }
        return schedulerRepository.save(schedulerPort.toEntity()).toPort()
    }

    override fun findSchedulerByIdOrThrow(schedulerId: Int): SchedulerOutputPort {
        return schedulerRepository.findById(schedulerId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("SchedulerRepositoryImpl.findSchedulerByIdOrThrow - Error to find Scheduler - schedulerId: $schedulerId")
    }

    override fun deleteScheduler(schedulerId: Int) {
        val schedulerPort = findSchedulerByIdOrThrow(schedulerId)
        schedulerRepository.delete(schedulerPort.toEntity())
    }
}