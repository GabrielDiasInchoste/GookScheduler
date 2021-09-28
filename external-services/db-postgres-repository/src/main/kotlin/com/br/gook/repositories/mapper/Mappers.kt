package com.br.gook.repositories.mapper

import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.output.*
import com.br.gook.repositories.SchedulerStatus
import com.br.gook.repositories.model.*

fun AddressOutputPort.toEntity(): AddressEntity {
    return AddressEntity(
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
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CancelEntity.toPort(): CancelOutputPort {
    return CancelOutputPort(
        id = id,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CourtOutputPort.toEntity(): CourtEntity {
    return CourtEntity(
        name = name,
        type = type,
        description = description,
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
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalOutputPort.toEntity(): LocalEntity {
    return LocalEntity(
        name = name,
        address = address.toEntity(),
        courts = courts.map { it.toEntity() },
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
        customerId = customerId,
        status = SchedulerStatus.REQUESTED,
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
        SchedulerStatus.REQUESTED -> SchedulerStatusPort.REQUESTED
        SchedulerStatus.CONFIRMED -> SchedulerStatusPort.CONFIRMED
        else -> SchedulerStatusPort.CANCELED
    }
}