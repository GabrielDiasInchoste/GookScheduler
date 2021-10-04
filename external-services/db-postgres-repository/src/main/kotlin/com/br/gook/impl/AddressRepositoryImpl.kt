package com.br.gook.impl

import com.br.gook.data.output.AddressOutputPort
import com.br.gook.repository.AddressRepository
import com.br.gook.mapper.toEntity
import com.br.gook.mapper.toPort
import com.br.gook.port.output.AddressRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class AddressRepositoryImpl(
    @Lazy
    private val addressRepository: AddressRepository
) : AddressRepositoryOutput {

    private val log = Logger.getLogger(javaClass)

    override fun saveAddress(addressPort: AddressOutputPort): AddressOutputPort {
        if (addressPort.id != null) {
            addressRepository.findById(addressPort.id!!).ifPresent {
                log.error("AddressRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
                throw Exception("AddressRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
            }
        }
        return addressRepository.save(addressPort.toEntity()).toPort()
    }

    override fun findAddressByIdOrThrow(addressId: Long): AddressOutputPort {
        return addressRepository.findById(addressId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("AddressRepositoryImpl.findAddressByIdOrThrow - Error to find Address - addressId: $addressId")
    }

    override fun deleteAddress(productId: Long) {
        val productPort = findAddressByIdOrThrow(productId)
        addressRepository.delete(productPort.toEntity())
    }
}