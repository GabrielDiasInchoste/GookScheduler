package com.br.gook.repositories.impl

import com.br.gook.data.output.CancelOutputPort
import com.br.gook.port.output.CancelRepositoryOutput
import com.br.gook.repositories.interfaces.CancelRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class CancelRepositoryImpl(
    private val cancelRepository: CancelRepository
) : CancelRepositoryOutput {
    private val log = Logger.getLogger(javaClass)


    override fun saveCancel(cancelPort: CancelOutputPort): CancelOutputPort {
        cancelRepository.findById(cancelPort.id).ifPresent {
            log.error("CancelRepositoryImpl.saveCancel - Cancel already saved with id - cancelId: ${cancelPort.id}")
            throw Exception("CancelRepositoryImpl.saveCancel - Cancel already saved with id - cancelId: ${cancelPort.id}")
        }
        return cancelRepository.save(cancelPort.toEntity()).toPort()
    }

    override fun findCancelByIdOrThrow(cancelId: Int): CancelOutputPort {
        return cancelRepository.findById(cancelId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("CancelRepositoryImpl.findCancelByIdOrThrow - Error to find Cancel - cancelId: $cancelId")
    }

    override fun deleteCancel(cancelId: Int) {
        val cancelPort = findCancelByIdOrThrow(cancelId)
        cancelRepository.delete(cancelPort.toEntity())
    }
}