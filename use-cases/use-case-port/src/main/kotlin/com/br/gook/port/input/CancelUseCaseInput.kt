package com.br.gook.port.input

import com.br.gook.data.input.CancelInputPort
import com.br.gook.data.output.CancelOutputPort
import com.br.gook.data.input.UpdateCancelInputPort
import com.br.gook.data.output.SchedulerOutputPort

interface CancelUseCaseInput {

    fun createCancel(schedulerId: Long, cancelInputPort: CancelInputPort): SchedulerOutputPort

    fun updateCancel(cancelId: Long, updateCancelInputPort: UpdateCancelInputPort): CancelOutputPort
}