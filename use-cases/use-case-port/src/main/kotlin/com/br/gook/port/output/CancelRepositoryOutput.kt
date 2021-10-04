package com.br.gook.port.output

import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.output.SchedulerOutputPort

interface CancelRepositoryOutput {

    fun saveCancel(scheduler: SchedulerOutputPort): SchedulerOutputPort

    fun findCancelByIdOrThrow(cancelId: Long): CancelOutputPort

    fun updateCancel(cancelPort: CancelOutputPort) : CancelOutputPort
}