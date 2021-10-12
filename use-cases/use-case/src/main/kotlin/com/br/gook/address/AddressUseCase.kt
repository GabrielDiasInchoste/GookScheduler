package com.br.gook.address

import com.br.gook.data.input.AddressInputPort
import com.br.gook.data.input.UpdateAddressInputPort
import com.br.gook.data.output.AddressOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.AddressUseCaseInput
import com.br.gook.port.output.AddressRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Component

@Component
class AddressUseCase(
    val addressRepositoryOutput: AddressRepositoryOutput
) : AddressUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findAddress(addressId: Long): AddressOutputPort {
        try {
            log.info("AddressUseCase.findAddress - Start - addressId : $addressId")
            val response = addressRepositoryOutput.findAddressByIdOrThrow(addressId)
            log.info("AddressUseCase.findAddress - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("AddressUseCase.findAddress - Error to Find Address - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createAddress(addressInputPort: AddressInputPort): AddressOutputPort {
        try {
            log.info("AddressUseCase.createAddress - Start - addressInputPort : $addressInputPort")
            val response = addressRepositoryOutput.saveAddress(addressInputPort.toOutputPort())
            log.info("AddressUseCase.createAddress - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("AddressUseCase.createAddress - Error to Create Address - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun updateAddress(addressId: Long, updateAddressInputPort: UpdateAddressInputPort): AddressOutputPort {
        try {
            log.info("AddressUseCase.updateAddress - Start - addressId : $addressId , updateAddressInputPort : $updateAddressInputPort")
            val addressPort = addressRepositoryOutput.findAddressByIdOrThrow(addressId)
            val response = addressRepositoryOutput.updateAddress(
                updateAddressInputPort.toPort(addressPort)
            )
            log.info("AddressUseCase.updateAddress - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("AddressUseCase.updateAddress - Error to Update Address - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun deleteAddress(addressId: Long) {
        try {
            log.info("AddressUseCase.deleteAddress - Start - addressId : $addressId")
            val response = addressRepositoryOutput.deleteAddress(addressId)
            log.info("AddressUseCase.deleteAddress - End - response : $response")
        } catch (ex: Exception) {
            log.error("AddressUseCase.deleteAddress - Error to Delete Address - Error : ${ex.message}", ex)
            throw ex
        }
    }

}