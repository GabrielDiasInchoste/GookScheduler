package com.br.gook.port.input

import com.br.gook.data.input.CourtInputPort
import com.br.gook.data.input.PageCourtInputPort
import com.br.gook.data.input.UpdateCourtInputPort
import com.br.gook.data.output.CourtOutputPort
import com.br.gook.data.output.PageCourtResponseOutputPort
import org.springframework.data.domain.PageRequest

interface CourtUseCaseInput {

    fun findCourt(courtId: Long): CourtOutputPort

    fun createCourt(courtInputPort: CourtInputPort): CourtOutputPort

    fun updateCourt(courtId: Long, updateCourtInputPort: UpdateCourtInputPort): CourtOutputPort

    fun deleteCourt(courtId: Long)

    fun findAllCourtWithPaginate(pageRequest: PageRequest, pageCourtInputPort: PageCourtInputPort): PageCourtResponseOutputPort
}