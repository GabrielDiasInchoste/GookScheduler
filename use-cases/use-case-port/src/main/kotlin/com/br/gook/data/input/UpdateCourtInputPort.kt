package com.br.gook.data.input

import com.br.gook.data.CourtTypePort

data class UpdateCourtInputPort(
    val name: String?,
    val type: CourtTypePort?,
    val description: String?,
    val localId: Long?
)