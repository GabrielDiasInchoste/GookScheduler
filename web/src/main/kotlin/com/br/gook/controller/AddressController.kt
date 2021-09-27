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
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/address/")
class AddressController(
    private val addressUseCaseInput: AddressUseCaseInput
) {

    @GetMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProduct(
        @PathVariable(value = "addressId") addressId: Long
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.findAddress(addressId).toResponse())
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postProduct(
        @RequestBody @Valid addressRequest: AddressRequest
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.createAddress(addressRequest.toPort()).toResponse())
    }

    @PutMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun putProduct(
        @PathVariable(value = "addressId") addressId: Long,
        @RequestBody @Valid updateAddressRequest: UpdateAddressRequest
    ): ResponseEntity<AddressResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(addressUseCaseInput.updateAddress(addressId, updateAddressRequest.toPort()).toResponse())
    }

    @DeleteMapping(value = ["{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteProduct(
        @PathVariable(value = "addressId") addressId: Long
    ): ResponseEntity<Void> {
        addressUseCaseInput.deleteAddress(addressId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}