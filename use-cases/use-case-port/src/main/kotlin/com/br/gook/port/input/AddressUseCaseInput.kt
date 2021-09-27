package com.br.gook.port.input

import com.br.gook.data.input.AddressInputPort
import com.br.gook.data.input.UpdateAddressInputPort
import com.br.gook.data.output.AddressOutputPort

interface AddressUseCaseInput {

    fun findAddress(addressId: Long): AddressOutputPort

    fun createAddress(addressInputPort: AddressInputPort): AddressOutputPort

    fun updateAddress(addressId: Long,updateAddressInputPort: UpdateAddressInputPort): AddressOutputPort

    fun deleteAddress(addressId: Long)
}