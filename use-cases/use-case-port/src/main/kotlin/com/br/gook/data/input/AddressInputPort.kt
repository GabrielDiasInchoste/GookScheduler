package com.br.gook.data.input

data class AddressInputPort(
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val latitude: String,
    val longitude: String
)