package com.br.gook.controller

import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.input.ConfirmSchedulerInputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.PageSchedulerRequest
import com.br.gook.dto.request.SchedulerRequest
import com.br.gook.dto.request.UpdateSchedulerRequest
import com.br.gook.dto.response.PageSchedulerResponse
import com.br.gook.dto.response.SchedulerResponse
import com.br.gook.port.input.SchedulerUseCaseInput
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import javax.swing.text.SimpleAttributeSet.EMPTY
import javax.validation.Valid
import kotlin.ranges.CharRange.Companion.EMPTY

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

    @GetMapping(value = ["all/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllScheduler(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "10") linesPage: Int,
        @RequestParam(value = "sort", defaultValue = "DESC") sort: String?,
        @RequestParam(value = "customerEmail", defaultValue = "") customerEmail: String?,
        @RequestParam(value = "courtId", defaultValue = "") courtId: Long?,
        @RequestParam(value = "status", defaultValue = "") status: SchedulerStatusPort?,

        ): ResponseEntity<PageSchedulerResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                schedulerUseCaseInput.findAllSchedulerWithPaginate(
                    PageRequest.of(page, linesPage, if (sort == "ASC") Sort.Direction.ASC else Sort.Direction.DESC),
                    PageSchedulerRequest(
                        customerEmail = customerEmail,
                        courtId = courtId,
                        status = status
                    ).toPort()
                ).toResponse()
            )
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postScheduler(
        @RequestBody @Valid schedulerRequest: SchedulerRequest
    ): ResponseEntity<SchedulerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.createScheduler(schedulerRequest.toPort()).toResponse())
    }

    @PostMapping(value = ["confirm/{schedulerId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun confirmScheduler(
        @PathVariable(value = "schedulerId") schedulerId: Long
    ): ResponseEntity<SchedulerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(schedulerUseCaseInput.confirmScheduler(ConfirmSchedulerInputPort(schedulerId)).toResponse())
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
}