package com.br.gook.court

import com.br.gook.data.input.CourtInputPort
import com.br.gook.data.input.UpdateCourtInputPort
import com.br.gook.data.output.CourtOutputPort
import com.br.gook.mappers.toOutputPort
import com.br.gook.mappers.toPort
import com.br.gook.port.input.CourtUseCaseInput
import com.br.gook.port.output.CourtRepositoryOutput
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class CourtUseCase(
    val courtRepositoryOutput: CourtRepositoryOutput
) : CourtUseCaseInput {

    private val log = Logger.getLogger(javaClass)

    override fun findCourt(courtId: Long): CourtOutputPort {

        log.info("CourtUseCase.findCourt - Start - courtId : $courtId")
        val response = courtRepositoryOutput.findCourtByIdOrThrow(courtId)
        log.info("CourtUseCase.findCourt - End - response : $response")

        return response
    }

    override fun createCourt(courtInputPort: CourtInputPort): CourtOutputPort {
        log.info("CourtUseCase.createCourt - Start - courtInputPort : $courtInputPort")
        val response = courtRepositoryOutput.saveCourt(courtInputPort.toOutputPort())
        log.info("CourtUseCase.createCourt - End - response : $response")
        return response

    }

    override fun updateCourt(courtId: Long, updateCourtInputPort: UpdateCourtInputPort): CourtOutputPort {

        log.info("CourtUseCase.updateCourt - Start - courtId : $courtId , updateCourtInputPort : $updateCourtInputPort")
        val courtPort = courtRepositoryOutput.findCourtByIdOrThrow(courtId)
        val response = courtRepositoryOutput.saveCourt(
            updateCourtInputPort.toPort(courtPort)
        )
        log.info("CourtUseCase.updateCourt - End - response : $response")
        return response
    }

    override fun deleteCourt(courtId: Long) {
        log.info("CourtUseCase.deleteCourt - Start - courtId : $courtId")
        val response = courtRepositoryOutput.deleteCourt(courtId)
        log.info("CourtUseCase.deleteCourt - End - response : $response")
    }

}