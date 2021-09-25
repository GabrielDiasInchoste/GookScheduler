package com.br.gook.controller

import com.br.gook.data.SchedulerPort
import com.br.gook.port.input.SchedulerUseCaseInput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/")
class SchedulerController(
    private val schedulerUseCaseInput: SchedulerUseCaseInput
) {
    //TODO REFACTOR

    @GetMapping(value = ["scheduler/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int
    ): ResponseEntity<SchedulerPort>? {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.findScheduler(schedulerId))
    }

    @PostMapping(value = ["scheduler"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postProduct(
        @RequestBody @Valid schedulerRequest: SchedulerPort
    ): ResponseEntity<SchedulerPort>? {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.createScheduler(schedulerRequest))
    }

    @PutMapping(value = ["scheduler/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int,
        @RequestBody @Valid schedulerEntity: SchedulerPort
    ): ResponseEntity<SchedulerPort>? {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.updateScheduler(schedulerId, schedulerEntity))
    }

    @DeleteMapping(value = ["scheduler/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteProduct(
        @PathVariable(value = "schedulerId") schedulerId: Int
    ): ResponseEntity<Void> {
        schedulerUseCaseInput.deleteScheduler(schedulerId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }


}