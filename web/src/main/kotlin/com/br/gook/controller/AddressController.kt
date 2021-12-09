package com.br.gook.controller

import com.br.gook.dto.mapper.toPort
import com.br.gook.dto.mapper.toResponse
import com.br.gook.dto.request.AddressRequest
import com.br.gook.dto.request.UpdateAddressRequest
import com.br.gook.dto.response.AddressResponse
import com.br.gook.port.input.AddressUseCaseInput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/address/")
class AddressController(
    private val addressUseCaseInput: AddressUseCaseInput
) {

    @GetMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAddress(
        @PathVariable(value = "addressId") addressId: Long
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.findAddress(addressId).toResponse())
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postAddress(
        @RequestBody @Valid addressRequest: AddressRequest
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.createAddress(addressRequest.toPort()).toResponse())
}

    @Secured("ROLE_ADMIN")
    @PutMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putAddress(
        @PathVariable(value = "addressId") addressId: Long,
        @RequestBody @Valid updateAddressRequest: UpdateAddressRequest
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.updateAddress(addressId, updateAddressRequest.toPort()).toResponse())
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteAddress(
        @PathVariable(value = "addressId") addressId: Long
    ): ResponseEntity<Void> {
        addressUseCaseInput.deleteAddress(addressId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}