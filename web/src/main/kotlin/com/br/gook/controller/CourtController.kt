package com.br.gook.controller

import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.CourtRequest
import com.br.gook.dto.request.PageCourtRequest
import com.br.gook.dto.request.PageLocalRequest
import com.br.gook.dto.request.UpdateCourtRequest
import com.br.gook.dto.response.CourtResponse
import com.br.gook.dto.response.PageCourtResponse
import com.br.gook.dto.response.PageLocalResponse
import com.br.gook.port.input.CourtUseCaseInput
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/court/")
class CourtController(
    private val courtUseCaseInput: CourtUseCaseInput
) {

    @GetMapping(value = ["{courtId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCourt(
        @PathVariable(value = "courtId") courtId: Long
    ): ResponseEntity<CourtResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(courtUseCaseInput.findCourt(courtId).toResponse())
    }

    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllCourt(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "10") linesPage: Int,
        @RequestParam(value = "sort", defaultValue = "DESC") sort: String?,
        @RequestParam(value = "localId") localId: Long?,
        @RequestParam(value = "type") type: String?
    ): ResponseEntity<PageCourtResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                courtUseCaseInput.findAllCourtWithPaginate(
                    PageRequest.of(
                        page,
                        linesPage,
                        if (sort == "ASC") Sort.by("id").ascending() else Sort.by("id").descending()
                    ),
                    PageCourtRequest(
                        localId = localId,
                        type = type
                    ).toPort()
                ).toResponse()
            )
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postCourt(
        @RequestBody @Valid courtRequest: CourtRequest
    ): ResponseEntity<CourtResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(courtUseCaseInput.createCourt(courtRequest.toPort()).toResponse())
    }

    @PutMapping(value = ["{courtId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putCourt(
        @PathVariable(value = "courtId") courtId: Long,
        @RequestBody @Valid updateCourtRequest: UpdateCourtRequest
    ): ResponseEntity<CourtResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(courtUseCaseInput.updateCourt(courtId, updateCourtRequest.toPort()).toResponse())
    }

    @DeleteMapping(value = ["{courtId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteCourt(
        @PathVariable(value = "courtId") courtId: Long
    ): ResponseEntity<Void> {
        courtUseCaseInput.deleteCourt(courtId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}