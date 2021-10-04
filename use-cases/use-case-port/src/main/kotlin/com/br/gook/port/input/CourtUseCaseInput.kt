package com.br.gook.port.input

import com.br.gook.data.input.CourtInputPort
import com.br.gook.data.input.UpdateCourtInputPort
import com.br.gook.data.output.CourtOutputPort

interface CourtUseCaseInput {

    fun findCourt(courtId: Long): CourtOutputPort

    fun createCourt(courtInputPort: CourtInputPort): CourtOutputPort

    fun updateCourt(courtId: Long,updateCourtInputPort: UpdateCourtInputPort): CourtOutputPort

    fun deleteCourt(courtId: Long)
}