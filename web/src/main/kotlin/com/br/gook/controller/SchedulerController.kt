package com.br.gook.controller

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.SchedulerRequest
import com.br.gook.dto.request.UpdateSchedulerRequest
import com.br.gook.dto.response.SchedulerResponse
import com.br.gook.port.input.SchedulerUseCaseInput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/scheduler/")
class SchedulerController(
    private val schedulerUseCaseInput: SchedulerUseCaseInput
) {

    @GetMapping(value = ["{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getScheduler(
        @PathVariable(value = "schedulerId") schedulerId: Long
    ): ResponseEntity<SchedulerOutputPort> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.findScheduler(schedulerId))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postScheduler(
        @RequestBody @Valid schedulerRequest: SchedulerRequest
    ): ResponseEntity<SchedulerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.createScheduler(schedulerRequest.toPort()).toResponse())
    }

    @PutMapping(value = ["{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putScheduler(
        @PathVariable(value = "schedulerId") schedulerId: Long,
        @RequestBody @Valid updateSchedulerRequest: UpdateSchedulerRequest
    ): ResponseEntity<SchedulerOutputPort> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.updateScheduler(schedulerId, updateSchedulerRequest.toPort()))
    }

    @DeleteMapping(value = ["{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteScheduler(
        @PathVariable(value = "schedulerId") schedulerId: Long
    ): ResponseEntity<Void> {
        schedulerUseCaseInput.deleteScheduler(schedulerId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}