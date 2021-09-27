package com.br.gook.repositories.impl

import com.br.gook.data.output.LocalOutputPort
import com.br.gook.port.output.LocalRepositoryOutput
import com.br.gook.repositories.interfaces.LocalRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class LocalRepositoryImpl(
    private val localRepository: LocalRepository
) : LocalRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveLocal(localPort: LocalOutputPort): LocalOutputPort {
        localRepository.findById(localPort.id).ifPresent {
            log.error("LocalRepositoryImpl.saveCourt - Local already saved with id - localId: ${localPort.id}")
            throw Exception("LocalRepositoryImpl.saveCourt - Local already saved with id - localId: ${localPort.id}")
        }
        return localRepository.save(localPort.toEntity()).toPort()
    }

    override fun findLocalByIdOrThrow(localId: Int): LocalOutputPort {
        return localRepository.findById(localId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("LocalRepositoryImpl.findLocalByIdOrThrow - Error to find Local - localId: $localId")
    }

    override fun deleteLocal(localId: Int) {
        val localPort = findLocalByIdOrThrow(localId)
        localRepository.delete(localPort.toEntity())
    }
}