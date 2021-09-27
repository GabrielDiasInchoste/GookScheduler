package com.br.gook.port.output

import com.br.gook.data.output.AddressOutputPort

interface AddressRepositoryOutput {

    fun saveAddress(addressPort: AddressOutputPort): AddressOutputPort

    fun findAddressByIdOrThrow(addressId: Int): AddressOutputPort

    fun deleteAddress(productId: Int)
}