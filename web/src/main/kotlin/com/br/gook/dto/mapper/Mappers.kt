package com.br.gook.dto.mapper

import com.br.gook.data.input.*
import com.br.gook.data.output.*
import com.br.gook.dto.request.*
import com.br.gook.dto.response.*
import org.springframework.data.jpa.domain.AbstractPersistable_.id

fun AddressOutputPort.toResponse(): AddressResponse {
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

fun AddressRequest.toPort(): AddressInputPort {
    return AddressInputPort(
        name = name,
        number = number,
        description = description,
        cep = cep,
    )
}

fun UpdateAddressRequest.toPort(): UpdateAddressInputPort {
    return UpdateAddressInputPort(
        name = name,
        number = number,
        description = description,
        cep = cep,
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
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CourtOutputPort.toResponse(): CourtResponse {
    return CourtResponse(
        id = id!!,
        name = name,
        type = type,
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

fun SchedulerRequest.toPort(): SchedulerInputPort {
    return SchedulerInputPort(
        customerId = customerId,
        courtId = courtId,
        schedule = schedule
    )
}

fun SchedulerOutputPort.toResponse(): SchedulerResponse {
    return SchedulerResponse(
        id = id!!,
        customerId = customerId,
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
        scheduleDate = scheduleDate,
    )
}
