package com.br.gook.mappers

import com.br.gook.data.input.AddressInputPort
import com.br.gook.data.input.SchedulerInputPort
import com.br.gook.data.input.UpdateAddressInputPort
import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.data.output.AddressOutputPort
import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.CourtOutputPort
import com.br.gook.data.output.SchedulerOutputPort
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

fun SchedulerInputPort.toOutputPort(courtOutputPort: CourtOutputPort): SchedulerOutputPort {
    return SchedulerOutputPort(
        id = null,
        customerId = customerId,
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