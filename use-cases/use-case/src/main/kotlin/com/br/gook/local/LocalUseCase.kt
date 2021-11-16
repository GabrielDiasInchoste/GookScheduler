package com.br.gook.local

import com.br.gook.data.input.LocalInputPort
import com.br.gook.data.input.PageLocalInputPort
import com.br.gook.data.input.PageSchedulerInputPort
import com.br.gook.data.input.UpdateLocalInputPort
import com.br.gook.data.output.LocalOutputPort
import com.br.gook.data.output.PageLocalResponseOutputPort
import com.br.gook.data.output.PageSchedulerResponseOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.LocalUseCaseInput
import com.br.gook.port.output.AddressRepositoryOutput
import com.br.gook.port.output.LocalRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class LocalUseCase(
    val localRepositoryOutput: LocalRepositoryOutput,
    val addressRepositoryOutput: AddressRepositoryOutput
) : LocalUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findLocal(localId: Long): LocalOutputPort {
        try {

            log.info("LocalUseCase.findLocal - Start - localId : $localId")
            val response = localRepositoryOutput.findLocalByIdOrThrow(localId)
            log.info("LocalUseCase.findLocal - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("LocalUseCase.findLocal - Error to Create Local - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createLocal(localInputPort: LocalInputPort): LocalOutputPort {
        try {
            log.info("LocalUseCase.createLocal - Start - localInputPort : $localInputPort")
            val address = addressRepositoryOutput.findAddressByIdOrThrow(localInputPort.addressId)
            val response = localRepositoryOutput.saveLocal(localInputPort.toOutputPort(address))

            log.info("LocalUseCase.createLocal - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("LocalUseCase.createLocal - Error to Create Local - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun updateLocal(localId: Long, updateLocalInputPort: UpdateLocalInputPort): LocalOutputPort {
        try {

            log.info("LocalUseCase.updateLocal - Start - localId : $localId , updateLocalInputPort : $updateLocalInputPort")
            val localPort = localRepositoryOutput.findLocalByIdOrThrow(localId)
            val response = localRepositoryOutput.updateLocal(
                updateLocalInputPort.toPort(localPort)
            )
            log.info("LocalUseCase.updateLocal - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("LocalUseCase.updateLocal - Error to Update Local - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun deleteLocal(localId: Long) {
        try {
            log.info("LocalUseCase.deleteLocal - Start - localId : $localId")
            val response = localRepositoryOutput.deleteLocal(localId)
            log.info("LocalUseCase.deleteLocal - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("LocalUseCase.deleteLocal - Error to Delete Local - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun findAllLocalWithPaginate(
        pageRequest: PageRequest,
        pageLocalInputPort: PageLocalInputPort
    ): PageLocalResponseOutputPort {
        try {
            log.info("LocalUseCase.findAllLocalWithPaginate - Start - pageRequest :$pageRequest ,pageLocalInputPort: $pageLocalInputPort")

            val response = localRepositoryOutput.findAllLocalWithPaginate(
                pageRequest,
                pageLocalInputPort.toOutputPort()
            )
            log.info("LocalUseCase.findAllLocalWithPaginate - End - response : $response")

            return response
        } catch (ex: Exception) {
            log.error("LocalUseCase.findAllLocalWithPaginate - Error to Find Local - Error : ${ex.message}", ex)
            throw ex
        }
    }
}