package com.br.gook.impl

import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.port.output.CancelRepositoryOutput
import com.br.gook.repository.CancelRepository
import com.br.gook.repository.SchedulerRepository
import com.br.gook.mapper.toEntity
import com.br.gook.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class CancelRepositoryImpl(
    @Lazy
    private val cancelRepository: CancelRepository,
    @Lazy
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