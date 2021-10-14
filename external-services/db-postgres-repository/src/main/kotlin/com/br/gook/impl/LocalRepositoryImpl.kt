package com.br.gook.impl

import com.br.gook.data.output.LocalOutputPort
import com.br.gook.port.output.LocalRepositoryOutput
import com.br.gook.repository.LocalRepository
import com.br.gook.mapper.toEntity
import com.br.gook.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class LocalRepositoryImpl(
    @Lazy
    private val localRepository: LocalRepository
) : LocalRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveLocal(localPort: LocalOutputPort): LocalOutputPort {
        if (localPort.id != null) {
            localRepository.findById(localPort.id!!).ifPresent {
                log.error("LocalRepositoryImpl.saveLocal - Local already saved with id - localId: ${localPort.id}")
                throw Exception("LocalRepositoryImpl.saveLocal - Local already saved with id - localId: ${localPort.id}")
            }
        }
        return localRepository.save(localPort.toEntity()).toPort()
    }

    override fun updateLocal(localPort: LocalOutputPort): LocalOutputPort {
        return localRepository.save(localPort.toEntity()).toPort()
    }

    override fun findLocalByIdOrThrow(localId: Long): LocalOutputPort {
        return localRepository.findById(localId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("LocalRepositoryImpl.findLocalByIdOrThrow - Error to find Local - localId: $localId")
    }

    override fun deleteLocal(localId: Long) {
        val localPort = findLocalByIdOrThrow(localId)
        localRepository.delete(localPort.toEntity())
    }
}