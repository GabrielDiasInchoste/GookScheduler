package com.br.gook.dto.response

data class PageLocalResponse(
    val number: Int,
    val numberOfElements: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Long,
    val first: Boolean,
    val last: Boolean,
    val locals: List<LocalResponse>
)
