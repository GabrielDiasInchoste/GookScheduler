package com.br.gook.controller

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.request.UpdateSchedulerRequest
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
    fun getProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int
    ): ResponseEntity<SchedulerOutputPort>? {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.findScheduler(schedulerId))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postProduct(
        @RequestBody @Valid schedulerRequest: SchedulerOutputPort
    ): ResponseEntity<SchedulerOutputPort>? {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.createScheduler(schedulerRequest))
    }

    @PutMapping(value = ["{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int,
        @RequestBody @Valid updateSchedulerRequest: UpdateSchedulerRequest
    ): ResponseEntity<SchedulerOutputPort>? {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.updateScheduler(schedulerId, updateSchedulerRequest.toPort()))
    }

    @DeleteMapping(value = ["{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int
    ): ResponseEntity<Void> {
        schedulerUseCaseInput.deleteScheduler(schedulerId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}