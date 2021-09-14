package com.br.gook.repositories

import com.br.gook.data.AddressPort
import com.br.gook.port.output.PostgresRepositoryOutput
import com.br.gook.repositories.interfaces.*
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.springframework.stereotype.Service

@Service
class PostgresRepositoryImpl(
    private val addressRepository: AddressRepository,
    private val cancelRepository: CancelRepository,
    private val courtRepository: CourtRepository,
    private val localRepository: LocalRepository,
    private val schedulerRepository: SchedulerRepository,
) : PostgresRepositoryOutput {

    override fun saveAddress(addressPort: AddressPort): AddressPort {
        return addressRepository.save(addressPort.toEntity()).toPort()
    }

    override fun findAddressByIdOrThrow(productId: Int): AddressPort {
        return addressRepository.findById(productId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findAddressByIdOrThrow - Error to find Address - productId: $productId")
    }

    override fun deleteAddress(productId: Int) {
        val productDTO = findAddressByIdOrThrow(productId)
        addressRepository.delete(productDTO.toEntity())
    }
}