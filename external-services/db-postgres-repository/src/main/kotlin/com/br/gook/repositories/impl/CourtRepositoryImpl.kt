package com.br.gook.repositories.impl

import com.br.gook.data.output.CourtOutputPort
import com.br.gook.port.output.CourtRepositoryOutput
import com.br.gook.repositories.interfaces.CourtRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class CourtRepositoryImpl(
    private val courtRepository: CourtRepository
) : CourtRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveCourt(courtPort: CourtOutputPort): CourtOutputPort {
        courtRepository.findById(courtPort.id).ifPresent {
            log.error("CourtRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
            throw Exception("CourtRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
        }
        return courtRepository.save(courtPort.toEntity()).toPort()
    }

    override fun findCourtByIdOrThrow(courtId: Int): CourtOutputPort {
        return courtRepository.findById(courtId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("CourtRepositoryImpl.findCourtByIdOrThrow - Error to find Court - courtId: $courtId")
    }

    override fun deleteCourt(courtId: Int) {
        val courtPort = findCourtByIdOrThrow(courtId)
        courtRepository.delete(courtPort.toEntity())
    }
}