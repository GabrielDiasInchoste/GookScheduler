package com.br.gook.mappers

import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort

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