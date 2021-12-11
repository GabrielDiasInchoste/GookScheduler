package com.br.gook.dto.mapper

import com.br.gook.data.input.*
import com.br.gook.data.output.*
import com.br.gook.dto.request.*
import com.br.gook.dto.response.*

fun AddressOutputPort.toResponse(): AddressResponse {
    return AddressResponse(
        id = id!!,
        name = name,
        number = number,
        description = description,
        cep = cep,
        latitude = latitude,
        longitude = longitude,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun AddressRequest.toPort(): AddressInputPort {
    return AddressInputPort(
        name = name,
        number = number,
        description = description,
        cep = cep,
        latitude = latitude,
        longitude = longitude
    )
}

fun UpdateAddressRequest.toPort(): UpdateAddressInputPort {
    return UpdateAddressInputPort(
        name = name,
        number = number,
        description = description,
        cep = cep,
        latitude = latitude,
        longitude = longitude
    )
}

fun CourtOutputPort.toResponse(): CourtResponse {
    return CourtResponse(
        id = id!!,
        name = name,
        type = type,
        localId = localId,
        description = description,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CourtRequest.toPort(): CourtInputPort {
    return CourtInputPort(
        name = name,
        type = type,
        description = description,
        localId = localId
    )
}

fun UpdateCourtRequest.toPort(): UpdateCourtInputPort {
    return UpdateCourtInputPort(
        name = name,
        type = type,
        description = description,
        localId = localId
    )
}

fun LocalOutputPort.toResponse(): LocalResponse {
    return LocalResponse(
        id = id!!,
        name = name,
        address = address.toResponse(),
        courts = courts.map { it.toResponse() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalRequest.toPort(): LocalInputPort {
    return LocalInputPort(
        name = name,
        addressId = addressId
    )
}

fun UpdateLocalRequest.toPort(): UpdateLocalInputPort {
    return UpdateLocalInputPort(
        name = name
    )
}

fun SchedulerRequest.toPort(): SchedulerInputPort {
    return SchedulerInputPort(
        tokenSendPush = tokenSendPush,
        customerEmail = customerEmail,
        courtId = courtId,
        schedule = schedule
    )
}

fun CancelOutputPort.toResponse(): CancelResponse {
    return CancelResponse(
        id = id!!,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CancelRequest.toPort(): CancelInputPort {
    return CancelInputPort(
        description = description
    )
}

fun UpdateCancelRequest.toPort(): UpdateCancelInputPort {
    return UpdateCancelInputPort(
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun SchedulerOutputPort.toResponse(): SchedulerResponse {
    return SchedulerResponse(
        id = id!!,
        customerEmail = customerEmail,
        status = status,
        tokenSendPush = tokenSendPush,
        court = court.toResponse(),
        cancel = cancel?.toResponse(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun UpdateSchedulerRequest.toPort(): UpdateSchedulerInputPort {
    return UpdateSchedulerInputPort(
        cancel = cancel?.toPort(),
        tokenSendPush=tokenSendPush,
        status = status,
        scheduleDate = scheduleDate
    )
}

fun PageSchedulerRequest.toPort(): PageSchedulerInputPort {
    return PageSchedulerInputPort(
        customerEmail = customerEmail,
        courtId = courtId,
        status = status
    )
}

fun PageLocalRequest.toPort(): PageLocalInputPort {
    return PageLocalInputPort(
        addressId = addressId,
        courtId = courtId
    )
}

fun PageCourtRequest.toPort(): PageCourtInputPort {
    return PageCourtInputPort(
        localId = localId,
        type = type
    )
}

fun PageSchedulerResponseOutputPort.toResponse(): PageSchedulerResponse {
    return PageSchedulerResponse(
        number = number,
        numberOfElements = numberOfElements,
        size = size,
        totalPages = totalPages,
        totalElements = totalElements,
        first = first,
        last = last,
        schedulers = schedulers.map { it.toResponse() }
    )
}

fun PageLocalResponseOutputPort.toResponse(): PageLocalResponse {
    return PageLocalResponse(
        number = number,
        numberOfElements = numberOfElements,
        size = size,
        totalPages = totalPages,
        totalElements = totalElements,
        first = first,
        last = last,
        locals = locals.map { it.toResponse() }
    )
}

fun PageCourtResponseOutputPort.toResponse(): PageCourtResponse {
    return PageCourtResponse(
        number = number,
        numberOfElements = numberOfElements,
        size = size,
        totalPages = totalPages,
        totalElements = totalElements,
        first = first,
        last = last,
        courts = courts.map { it.toResponse() }
    )
}