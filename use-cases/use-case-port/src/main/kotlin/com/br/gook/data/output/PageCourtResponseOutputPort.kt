package com.br.gook.data.output

data class PageCourtResponseOutputPort(
    val number: Int,
    val numberOfElements: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Long,
    val first: Boolean,
    val last: Boolean,
    val courts: List<CourtOutputPort>
)
