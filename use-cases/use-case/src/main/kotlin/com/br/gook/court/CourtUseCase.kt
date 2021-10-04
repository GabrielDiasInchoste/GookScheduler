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

        log.info("CourtUseCase.findCourt - Start - courtId : $courtId")
        val response = courtRepositoryOutput.findCourtByIdOrThrow(courtId)
        log.info("CourtUseCase.findCourt - End - response : $response")

        return response
    }

    override fun createCourt(courtInputPort: CourtInputPort): CourtOutputPort {
        log.info("CourtUseCase.createCourt - Start - courtInputPort : $courtInputPort")
        val local = localRepositoryOutput.findLocalByIdOrThrow(courtInputPort.localId)
        val response = courtRepositoryOutput.saveCourt(courtInputPort.toOutputPort(local))
        log.info("CourtUseCase.createCourt - End - response : $response")
        return response

    }

    override fun updateCourt(courtId: Long, updateCourtInputPort: UpdateCourtInputPort): CourtOutputPort {

        log.info("CourtUseCase.updateCourt - Start - courtId : $courtId , updateCourtInputPort : $updateCourtInputPort")
        val courtPort = courtRepositoryOutput.findCourtByIdOrThrow(courtId)

        val response = courtRepositoryOutput.saveCourt(
            if (updateCourtInputPort.localId != null && updateCourtInputPort.localId != courtPort.local.id) {
                updateCourtInputPort.toPort(
                    courtPort,
                    localRepositoryOutput.findLocalByIdOrThrow(updateCourtInputPort.localId!!)
                )
            } else {
                updateCourtInputPort.toPort(
                    courtPort,
                    courtPort.local
                )
            }
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