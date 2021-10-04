package com.br.gook.impl

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.mapper.toEntity
import com.br.gook.mapper.toPort
import com.br.gook.port.output.SchedulerRepositoryOutput
import com.br.gook.repository.SchedulerRepository
import org.jboss.logging.Logger
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class SchedulerRepositoryImpl(
    @Lazy
    private val schedulerRepository: SchedulerRepository
) : SchedulerRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort {
        if (schedulerPort.id != null) {
            schedulerRepository.findById(schedulerPort.id!!).ifPresent {
                log.error("SchedulerRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
                throw Exception("SchedulerRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
            }
        }
        return schedulerRepository.save(schedulerPort.toEntity()).toPort()
    }

    override fun findSchedulerByIdOrThrow(schedulerId: Long): SchedulerOutputPort {
        return schedulerRepository.findById(schedulerId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("SchedulerRepositoryImpl.findSchedulerByIdOrThrow - Error to find Scheduler - schedulerId: $schedulerId")
    }

    override fun deleteScheduler(schedulerId: Long) {
        val schedulerPort = findSchedulerByIdOrThrow(schedulerId)
        schedulerRepository.delete(schedulerPort.toEntity())
    }
}