package com.br.gook.court

import com.br.gook.data.input.CourtInputPort
import com.br.gook.data.input.UpdateCourtInputPort
import com.br.gook.data.output.CourtOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.CourtUseCaseInput
import com.br.gook.port.output.CourtRepositoryOutput
import com.br.gook.port.output.LocalRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Component

@Component
class CourtUseCase(
    val courtRepositoryOutput: CourtRepositoryOutput,
    val localRepositoryOutput: LocalRepositoryOutput
) : CourtUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findCourt(courtId: Long): CourtOutputPort {
        try {
            log.info("CourtUseCase.findCourt - Start - courtId : $courtId")
            val response = courtRepositoryOutput.findCourtByIdOrThrow(courtId)
            log.info("CourtUseCase.findCourt - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CourtUseCase.findCourt - Error to Create Court - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun createCourt(courtInputPort: CourtInputPort): CourtOutputPort {
        try {
            log.info("CourtUseCase.createCourt - Start - courtInputPort : $courtInputPort")
            localRepositoryOutput.findLocalByIdOrThrow(courtInputPort.localId)
            val response = courtRepositoryOutput.saveCourt(courtInputPort.toOutputPort())
            log.info("CourtUseCase.createCourt - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CourtUseCase.createCourt - Error to Create Court - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun updateCourt(courtId: Long, updateCourtInputPort: UpdateCourtInputPort): CourtOutputPort {
        try {
            log.info("CourtUseCase.updateCourt - Start - courtId : $courtId , updateCourtInputPort : $updateCourtInputPort")
            val courtPort = courtRepositoryOutput.findCourtByIdOrThrow(courtId)
            if (updateCourtInputPort.localId != null) {
                localRepositoryOutput.findLocalByIdOrThrow(updateCourtInputPort.localId!!)
            }
            val response = courtRepositoryOutput.updateCourt(updateCourtInputPort.toPort(courtPort))

            log.info("CourtUseCase.updateCourt - End - response : $response")
            return response
        } catch (ex: Exception) {
            log.error("CourtUseCase.updateCourt - Error to Create Court - Error : ${ex.message}", ex)
            throw ex
        }
    }

    override fun deleteCourt(courtId: Long) {
        try {
            log.info("CourtUseCase.deleteCourt - Start - courtId : $courtId")
            val response = courtRepositoryOutput.deleteCourt(courtId)
            log.info("CourtUseCase.deleteCourt - End - response : $response")
        } catch (ex: Exception) {
            log.error("CourtUseCase.deleteCourt - Error to Create Court - Error : ${ex.message}", ex)
            throw ex
        }
    }
}