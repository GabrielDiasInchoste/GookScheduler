package com.br.gook.dto.request

data class UpdateAddressRequest(
    val name: String?,
    val number: Int?,
    val description: String?,
    val cep: String?
)