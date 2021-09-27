package com.br.gook.repositories.impl

import com.br.gook.data.output.AddressOutputPort
import com.br.gook.port.output.AddressRepositoryOutput
import com.br.gook.repositories.interfaces.AddressRepository
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class AddressRepositoryImpl(
    private val addressRepository: AddressRepository
) : AddressRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveAddress(addressPort: AddressOutputPort): AddressOutputPort {
        addressRepository.findById(addressPort.id).ifPresent {
            log.error("AddressRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
            throw Exception("AddressRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
        }
        return addressRepository.save(addressPort.toEntity()).toPort()
    }

    override fun findAddressByIdOrThrow(addressId: Int): AddressOutputPort {
        return addressRepository.findById(addressId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("AddressRepositoryImpl.findAddressByIdOrThrow - Error to find Address - addressId: $addressId")
    }

    override fun deleteAddress(productId: Int) {
        val productPort = findAddressByIdOrThrow(productId)
        addressRepository.delete(productPort.toEntity())
    }
}