package com.br.gook.port.input

import com.br.gook.data.input.AddressInputPort
import com.br.gook.data.output.AddressOutputPort

interface AddressUseCaseInput {

    fun findAddress(addressId: Int): AddressOutputPort

    fun createAddress(addressPort: AddressInputPort): AddressOutputPort

    fun updateAddress(addressId: Int,addressPort: AddressInputPort): AddressOutputPort

    fun deleteAddress(addressId: Int)
}