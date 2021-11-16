package com.br.gook.data.output

data class PageLocalResponseOutputPort(
    val number: Int,
    val numberOfElements: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Long,
    val first: Boolean,
    val last: Boolean,
    val locals: List<LocalOutputPort>
)
