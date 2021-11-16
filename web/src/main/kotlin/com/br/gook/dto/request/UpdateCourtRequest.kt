package com.br.gook.dto.request

import com.br.gook.data.CourtTypePort

data class UpdateCourtRequest(
    val name: String?,
    val type: CourtTypePort?,
    val description: String?,
    val localId: Long?
)