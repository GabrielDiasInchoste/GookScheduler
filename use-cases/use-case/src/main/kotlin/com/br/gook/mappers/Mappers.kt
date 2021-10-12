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
        lasModifiedDate = LocalDateTime.now()
    )
}

fun CourtInputPort.toOutputPort(): CourtOutputPort {
    return CourtOutputPort(
        id = null,
        name = name,
        type = type,
        description = description,
        localId = localId,
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
        localId = localId ?: court.localId,
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
        lasModifiedDate = LocalDateTime.now()
    )
}

fun CancelInputPort.toOutputPort(): CancelOutputPort {
    return CancelOutputPort(
        id = null,
        description = description,
        cancelRequestedDate = LocalDateTime.now(),
        cancelConfirmedDate = null,
        createDate = LocalDateTime.now(),
        lasModifiedDate = LocalDateTime.now()
    )
}

fun UpdateCancelInputPort.toPort(cancel: CancelOutputPort): CancelOutputPort {
    return CancelOutputPort(
        id = null,
        description = description ?: cancel.description,
        cancelRequestedDate = cancelRequestedDate ?: cancel.cancelRequestedDate,
        cancelConfirmedDate = cancelConfirmedDate ?: cancel.cancelConfirmedDate,
        createDate = cancel.createDate,
        lasModifiedDate = LocalDateTime.now()
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
        cancel = scheduler.cancel,
        schedule = scheduleDate ?: scheduler.schedule,
        confirmDate = scheduler.confirmDate,
        createDate = scheduler.createDate,
        lasModifiedDate = LocalDateTime.now()
    )
}
fun ConfirmSchedulerInputPort.toOutputPort(scheduler: SchedulerOutputPort): SchedulerOutputPort {
    return SchedulerOutputPort(
        id = scheduler.id,
        customerId = scheduler.customerId,
        status = SchedulerStatusPort.CONFIRMED,
        court = scheduler.court,
        cancel = scheduler.cancel,
        schedule = scheduler.schedule,
        confirmDate = LocalDateTime.now(),
        createDate = scheduler.createDate,
        lasModifiedDate = LocalDateTime.now()
    )
}