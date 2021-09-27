package com.br.gook.dto.request

import javax.validation.constraints.NotBlank

data class AddressRequest(
    @NotBlank(message = "Name not informed")
    val name: String,

    @NotBlank(message = "Number not informed")
    val number: Int,

    @NotBlank(message = "Description not informed")
    val description: String,

    @NotBlank(message = "CEP not informed")
    val cep: String
)