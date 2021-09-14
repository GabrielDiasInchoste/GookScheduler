package com.br.gook.port.output

import com.br.gook.data.AddressPort

interface PostgresRepositoryOutput {
    fun saveAddress(addressPort: AddressPort): AddressPort

    fun findAddressByIdOrThrow(productId: Int): AddressPort

    fun deleteAddress(productId: Int)

}