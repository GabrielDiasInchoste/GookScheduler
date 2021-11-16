package com.br.gook.port.output

import com.br.gook.data.output.CourtOutputPort
import com.br.gook.data.output.PageCourtOutputPort
import com.br.gook.data.output.PageCourtResponseOutputPort
import org.springframework.data.domain.PageRequest

interface CourtRepositoryOutput {

    fun saveCourt(courtPort: CourtOutputPort): CourtOutputPort

    fun updateCourt(courtPort: CourtOutputPort): CourtOutputPort

    fun findCourtByIdOrThrow(courtId: Long): CourtOutputPort

    fun deleteCourt(courtId: Long)

    fun findAllCourtWithPaginate(
        pageRequest: PageRequest,
        pageCourtOutputPort: PageCourtOutputPort
    ): PageCourtResponseOutputPort
}