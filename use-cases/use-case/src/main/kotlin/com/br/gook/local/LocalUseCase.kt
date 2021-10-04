package com.br.gook.local

import com.br.gook.data.input.LocalInputPort
import com.br.gook.data.input.UpdateLocalInputPort
import com.br.gook.data.output.LocalOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.LocalUseCaseInput
import com.br.gook.port.output.AddressRepositoryOutput
import com.br.gook.port.output.LocalRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Component

@Component
class LocalUseCase(
    val localRepositoryOutput: LocalRepositoryOutput,
    val addressRepositoryOutput: AddressRepositoryOutput
) : LocalUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findLocal(localId: Long): LocalOutputPort {

        log.info("LocalUseCase.findLocal - Start - localId : $localId")
        val response = localRepositoryOutput.findLocalByIdOrThrow(localId)
        log.info("LocalUseCase.findLocal - End - response : $response")

        return response
    }

    override fun createLocal(localInputPort: LocalInputPort): LocalOutputPort {
        log.info("LocalUseCase.createLocal - Start - localInputPort : $localInputPort")
        val address = addressRepositoryOutput.findAddressByIdOrThrow(localInputPort.addressId)
        val response = localRepositoryOutput.saveLocal(localInputPort.toOutputPort(address))
        log.info("LocalUseCase.createLocal - End - response : $response")
        return response

    }

    override fun updateLocal(localId: Long, updateLocalInputPort: UpdateLocalInputPort): LocalOutputPort {

        log.info("LocalUseCase.updateLocal - Start - localId : $localId , updateLocalInputPort : $updateLocalInputPort")
        val localPort = localRepositoryOutput.findLocalByIdOrThrow(localId)
        val response = localRepositoryOutput.saveLocal(
            updateLocalInputPort.toPort(localPort)
        )
        log.info("LocalUseCase.updateLocal - End - response : $response")
        return response
    }

    override fun deleteLocal(localId: Long) {
        log.info("LocalUseCase.deleteLocal - Start - localId : $localId")
        val response = localRepositoryOutput.deleteLocal(localId)
        log.info("LocalUseCase.deleteLocal - End - response : $response")
    }

}