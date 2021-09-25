package com.br.gook.port.input

import com.br.gook.data.AddressPort

interface AddressUseCaseInput {

    fun findAddress(addressId: Int): AddressPort

    fun createAddress(addressPort: AddressPort): AddressPort

    fun updateAddress(addressId: Int,addressPort: AddressPort): AddressPort

    fun deleteAddress(addressId: Int)
}