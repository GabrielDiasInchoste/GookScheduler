package com.br.gook.controller

import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.LocalRequest
import com.br.gook.dto.request.UpdateLocalRequest
import com.br.gook.dto.response.LocalResponse
import com.br.gook.port.input.LocalUseCaseInput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/local/")
class LocalController(
    private val localUseCaseInput: LocalUseCaseInput
) {

    @GetMapping(value = ["{localId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLocal(
        @PathVariable(value = "localId") localId: Long
    ): ResponseEntity<LocalResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(localUseCaseInput.findLocal(localId).toResponse())
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postLocal(
        @RequestBody @Valid localRequest: LocalRequest
    ): ResponseEntity<LocalResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(localUseCaseInput.createLocal(localRequest.toPort()).toResponse())
    }

    @PutMapping(value = ["{localId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putLocal(
        @PathVariable(value = "localId") localId: Long,
        @RequestBody @Valid updateLocalRequest: UpdateLocalRequest
    ): ResponseEntity<LocalResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(localUseCaseInput.updateLocal(localId, updateLocalRequest.toPort()).toResponse())
    }

    @DeleteMapping(value = ["{localId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteLocal(
        @PathVariable(value = "localId") localId: Long
    ): ResponseEntity<Void> {
        localUseCaseInput.deleteLocal(localId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}