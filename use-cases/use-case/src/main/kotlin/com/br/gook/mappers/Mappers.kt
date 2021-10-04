package com.br.gook.mappers

import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.input.*
import com.br.gook.data.output.*
import java.time.LocalDateTime

fun AddressInputPort.toOutputPort(): AddressOutputPort {
    return AddressOutputPort(
        id = null,
        name = name,
        number = number,
        description = description,
        cep = cep,
        createDate = LocalDateTime.now(),
        lasModifiedDate = LocalDateTime.now()
    )
}

fun UpdateAddressInputPort.toPort(address: AddressOutputPort): AddressOutputPort {
    return AddressOutputPort(
        id = address.id,
        name = name ?: address.name,
        number = number ?: address.number,
        description = description ?: address.description,
        cep = cep ?: address.cep,
        createDate = address.createDate,
        lasModifiedDate = address.lasModifiedDate
    )
}

fun CourtInputPort.toOutputPort(): CourtOutputPort {
    return CourtOutputPort(
        id = null,
        name = name,
        type = type,
        description = description,
        createDate = LocalDateTime.now(),
        lasModifiedDate = LocalDateTime.now()
    )
}

fun UpdateCourtInputPort.toPort(court: CourtOutputPort): CourtOutputPort {
    return CourtOutputPort(
        id = court.id,
        name = name ?: court.name,
        type = type ?: court.type,
        description = description ?: court.description,
        createDate = court.createDate,
        lasModifiedDate = court.lasModifiedDate
    )
}

fun LocalInputPort.toOutputPort(address: AddressOutputPort): LocalOutputPort {
    return LocalOutputPort(
        id = null,
        name = name,
        address = address,
        courts = arrayListOf(),
        createDate = LocalDateTime.now(),
        lasModifiedDate = LocalDateTime.now()
    )
}

fun UpdateLocalInputPort.toPort(local: LocalOutputPort): LocalOutputPort {
    return LocalOutputPort(
        id = local.id,
        name = name ?: local.name,
        address = local.address,
        courts = local.courts,
        createDate = local.createDate,
        lasModifiedDate = local.lasModifiedDate
    )
}

fun CancelInputPort.toOutputPort(): CancelOutputPort {
    return CancelOutputPort(
        id = null,
        description = description,
        cancelRequestedDate = cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate
    )
}

fun UpdateCancelInputPort.toPort(cancel: CancelOutputPort): CancelOutputPort {
    return CancelOutputPort(
        id = null,
        description = description ?: cancel.description,
        cancelRequestedDate = cancelRequestedDate ?: cancel.cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate ?: cancel.cancelConfirmedDate
    )
}

fun SchedulerInputPort.toOutputPort(courtOutputPort: CourtOutputPort): SchedulerOutputPort {
    return SchedulerOutputPort(
        id = null,
        customerId = customerId,
        status = SchedulerStatusPort.REQUESTED,
        court = courtOutputPort,
        cancel = null,
        schedule = schedule,
        confirmDate = null,
        createDate = LocalDateTime.now(),
        lasModifiedDate = LocalDateTime.now()
    )
}

fun UpdateSchedulerInputPort.toPort(scheduler: SchedulerOutputPort): SchedulerOutputPort {
    return SchedulerOutputPort(
        id = scheduler.id,
        customerId = scheduler.customerId,
        status = status ?: scheduler.status,
        court = scheduler.court,
        cancel = CancelOutputPort(
            id = scheduler.cancel!!.id,
            description = cancel?.description ?: scheduler.cancel!!.description,
            cancelRequestedDate = cancel?.cancelRequestedDate ?: scheduler.cancel!!.cancelRequestedDate,
            cancelConfirmedDate = cancel?.cancelConfirmedDate ?: scheduler.cancel!!.cancelConfirmedDate
        ),
        schedule = scheduleDate ?: scheduler.schedule,
        confirmDate = scheduler.confirmDate,
        createDate = scheduler.createDate,
        lasModifiedDate = scheduler.lasModifiedDate
    )
}