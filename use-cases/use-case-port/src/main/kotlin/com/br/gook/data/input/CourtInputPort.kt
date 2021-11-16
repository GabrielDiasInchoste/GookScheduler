package com.br.gook.data.input

import com.br.gook.data.CourtTypePort

data class CourtInputPort(
    val name: String,
    val type: CourtTypePort,
    val description: String,
    val localId: Long
)