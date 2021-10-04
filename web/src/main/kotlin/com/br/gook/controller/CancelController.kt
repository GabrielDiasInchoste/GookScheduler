package com.br.gook.controller

import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.CancelRequest
import com.br.gook.dto.request.UpdateCancelRequest
import com.br.gook.dto.response.CancelResponse
import com.br.gook.dto.response.SchedulerResponse
import com.br.gook.port.input.CancelUseCaseInput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/cancel/")
class CancelController(
    private val cancelUseCaseInput: CancelUseCaseInput
) {

    @PostMapping(value = ["schedulerId"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postCancel(
        @PathVariable(value = "schedulerId") schedulerId: Long,
        @RequestBody @Valid cancelRequest: CancelRequest
    ): ResponseEntity<SchedulerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(cancelUseCaseInput.createCancel(schedulerId, cancelRequest.toPort()).toResponse())
    }

    @PutMapping(value = ["{cancelId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putCancel(
        @PathVariable(value = "cancelId") cancelId: Long,
        @RequestBody updateCancelRequest: UpdateCancelRequest
    ): ResponseEntity<CancelResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(cancelUseCaseInput.updateCancel(cancelId, updateCancelRequest.toPort()).toResponse())
    }

}