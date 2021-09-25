package com.br.gook.dto.mapper

import com.br.gook.data.*
import com.br.gook.dto.request.AddressRequest
import com.br.gook.dto.request.CancelRequest
import com.br.gook.dto.request.CourtRequest
import com.br.gook.dto.request.LocalRequest
import com.br.gook.dto.response.*

fun AddressPort.toResponse(): AddressResponse {
    return AddressResponse(
        id = id!!,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun AddressRequest.toPort(): AddressPort {
    return AddressPort(
        id = null,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CancelPort.toResponse(): CancelResponse {
    return CancelResponse(
        id = id!!,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CancelRequest.toPort(): CancelPort {
    return CancelPort(
        id = null,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CourtPort.toResponse(): CourtResponse {
    return CourtResponse(
        id = id!!,
        name = name,
        type = type,
        description = description,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CourtRequest.toPort(): CourtPort {
    return CourtPort(
        id = null,
        name = name,
        type = type,
        description = description,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalPort.toResponse(): LocalResponse {
    return LocalResponse(
        id = id!!,
        name = name,
        address = address.toResponse(),
        courts = courts.map { it.toResponse() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalRequest.toPort(): LocalPort {
    return LocalPort(
        id = null,
        name = name,
        address = address.toPort(),
        courts = courts.map { it.toPort() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerPort.toResponse(): SchedulerResponse {
    return SchedulerResponse(
        id = id!!,
        customerId = customerId,
        local = local!!.toResponse(),
        cancel = cancel?.toResponse(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

//fun SchedulerRequest.toPort(): SchedulerPort {
//    return SchedulerPort(
//        id = null,
//        customerId = customerId,
//        local = local.toPort(),
//        cancel = cancel?.toPort(),
//        schedule = schedule,
//        confirmDate = confirmDate,
//        createDate = createDate,
//        lasModifiedDate = lasModifiedDate
//    )

