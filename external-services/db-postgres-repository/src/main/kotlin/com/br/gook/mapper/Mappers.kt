package com.br.gook.mapper

import com.br.gook.SchedulerStatus
import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.output.*
import com.br.gook.model.*

fun AddressOutputPort.toEntity(): AddressEntity {
    return AddressEntity(
        id = id ?: 0,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun AddressEntity.toPort(): AddressOutputPort {
    return AddressOutputPort(
        id = id,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CancelOutputPort.toEntity(): CancelEntity {
    return CancelEntity(
        id = id ?: 0,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CancelEntity.toPort(): CancelOutputPort {
    return CancelOutputPort(
        id = id,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CourtOutputPort.toEntity(): CourtEntity {
    return CourtEntity(
        id = id ?: 0,
        name = name,
        type = type,
        description = description,
        localId = localId,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CourtEntity.toPort(): CourtOutputPort {
    return CourtOutputPort(
        id = id,
        name = name,
        type = type,
        description = description,
        localId = localId,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalOutputPort.toEntity(): LocalEntity {
    return LocalEntity(
        id = id ?: 0,
        name = name,
        address = address.toEntity(),
        courts = mutableListOf(),
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalEntity.toPort(): LocalOutputPort {
    return LocalOutputPort(
        id = id,
        name = name,
        address = address.toPort(),
        courts = courts.map { it.toPort() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerOutputPort.toEntity(): SchedulerEntity {
    return SchedulerEntity(
        id = id ?: 0,
        customerId = customerId,
        status = status.toEntity(),
        court = court.toEntity(),
        cancel = cancel?.toEntity(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerEntity.toPort(): SchedulerOutputPort {
    return SchedulerOutputPort(
        id = id,
        customerId = customerId,
        status = status.toPort(),
        court = court.toPort(),
        cancel = cancel?.toPort(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerStatus.toPort(): SchedulerStatusPort {
    return when (this) {
        SchedulerStatus.CANCELED -> SchedulerStatusPort.CANCELED
        SchedulerStatus.CONFIRMED -> SchedulerStatusPort.CONFIRMED
        SchedulerStatus.CANCEL_REQUESTED -> SchedulerStatusPort.CANCEL_REQUESTED
        else -> SchedulerStatusPort.REQUESTED
    }
}

fun SchedulerStatusPort.toEntity(): SchedulerStatus {
    return when (this) {
        SchedulerStatusPort.CANCELED -> SchedulerStatus.CANCELED
        SchedulerStatusPort.CONFIRMED -> SchedulerStatus.CONFIRMED
        SchedulerStatusPort.CANCEL_REQUESTED -> SchedulerStatus.CANCEL_REQUESTED
        else -> SchedulerStatus.REQUESTED
    }
}