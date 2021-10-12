package com.br.gook.port.output

import com.br.gook.data.output.CourtOutputPort

interface CourtRepositoryOutput {

    fun saveCourt(courtPort: CourtOutputPort): CourtOutputPort

    fun updateCourt(courtPort: CourtOutputPort): CourtOutputPort

    fun findCourtByIdOrThrow(courtId: Long): CourtOutputPort

    fun deleteCourt(courtId: Long)
}