package com.br.gook.repositories.impl

import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.port.output.CancelRepositoryOutput
import com.br.gook.repositories.interfaces.CancelRepository
import com.br.gook.repositories.interfaces.SchedulerRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class CancelRepositoryImpl(
    private val cancelRepository: CancelRepository,
    private val schedulerRepository: SchedulerRepository
) : CancelRepositoryOutput {
    private val log = Logger.getLogger(javaClass)


    override fun saveCancel(scheduler: SchedulerOutputPort): SchedulerOutputPort {
        return schedulerRepository.save(scheduler.toEntity()).toPort()
    }

    override fun findCancelByIdOrThrow(cancelId: Long): CancelOutputPort {
        return cancelRepository.findById(cancelId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("CancelRepositoryImpl.findCancelByIdOrThrow - Error to find Cancel - cancelId: $cancelId")
    }

    override fun updateCancel(cancelPort: CancelOutputPort): CancelOutputPort {
        return cancelRepository.save(cancelPort.toEntity()).toPort()
    }
}