package com.br.gook.impl

import com.br.gook.data.output.CourtOutputPort
import com.br.gook.data.output.PageCourtOutputPort
import com.br.gook.data.output.PageCourtResponseOutputPort
import com.br.gook.mapper.toEntity
import com.br.gook.mapper.toPort
import com.br.gook.port.output.CourtRepositoryOutput
import com.br.gook.repository.CourtRepository
import com.br.gook.specification.SpecificationCourtByFilter
import org.jboss.logging.Logger
import org.springframework.context.annotation.Lazy
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class CourtRepositoryImpl(
    @Lazy
    private val courtRepository: CourtRepository
) : CourtRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveCourt(courtPort: CourtOutputPort): CourtOutputPort {
        if (courtPort.id != null) {
            courtRepository.findById(courtPort.id!!).ifPresent {
                log.error("CourtRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
                throw Exception("CourtRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
            }
        }
        return courtRepository.save(courtPort.toEntity()).toPort()
    }

    override fun updateCourt(courtPort: CourtOutputPort): CourtOutputPort {
        return courtRepository.save(courtPort.toEntity()).toPort()
    }

    override fun findCourtByIdOrThrow(courtId: Long): CourtOutputPort {
        return courtRepository.findById(courtId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("CourtRepositoryImpl.findCourtByIdOrThrow - Error to find Court - courtId: $courtId")
    }

    override fun deleteCourt(courtId: Long) {
        val courtPort = findCourtByIdOrThrow(courtId)
        courtRepository.delete(courtPort.toEntity())
    }

    override fun findAllCourtWithPaginate(
        pageRequest: PageRequest,
        pageCourtOutputPort: PageCourtOutputPort
    ): PageCourtResponseOutputPort {
        return courtRepository.findAll(
            SpecificationCourtByFilter().findOrderByCriteria(pageCourtOutputPort),
            pageRequest
        ).toPort()
    }
}