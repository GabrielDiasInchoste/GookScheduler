package com.br.gook.repositories.mapper

import com.br.gook.data.*
import com.br.gook.repositories.model.*

fun AddressPort.toEntity(): AddressEntity {
    return AddressEntity(
        id = id!!,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun AddressEntity.toPort(): AddressPort {
    return AddressPort(
        id = id,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CancelPort.toEntity(): CancelEntity {
    return CancelEntity(
        id = id!!,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CancelEntity.toPort(): CancelPort {
    return CancelPort(
        id = id,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun CourtPort.toEntity(): CourtEntity {
    return CourtEntity(
        id = id!!,
        name = name,
        type = type,
        description = description,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun CourtEntity.toPort(): CourtPort {
    return CourtPort(
        id = id,
        name = name,
        type = type,
        description = description,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalPort.toEntity(): LocalEntity {
    return LocalEntity(
        id = id!!,
        name = name,
        address = address.toEntity(),
        courts = courts.map { it.toEntity() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun LocalEntity.toPort(): LocalPort {
    return LocalPort(
        id = id,
        name = name,
        address = address.toPort(),
        courts = courts.map { it.toPort() },
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerPort.toEntity(): SchedulerEntity {
    return SchedulerEntity(
        id = id!!,
        customerId = customerId,
        court = local!!.courts.first().toEntity(),
        cancel = cancel?.toEntity(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}

fun SchedulerEntity.toPort(): SchedulerPort {
    return SchedulerPort(
        id = id,
        customerId = customerId,
        local = null,
        cancel = cancel?.toPort(),
        schedule = schedule,
        confirmDate = confirmDate,
        createDate = createDate,
        lasModifiedDate = lasModifiedDate
    )
}
