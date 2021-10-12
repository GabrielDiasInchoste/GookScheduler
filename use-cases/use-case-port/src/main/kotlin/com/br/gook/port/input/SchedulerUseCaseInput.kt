package com.br.gook.port.input

import com.br.gook.data.input.ConfirmSchedulerInputPort
import com.br.gook.data.input.SchedulerInputPort
import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.data.output.SchedulerOutputPort

interface SchedulerUseCaseInput {

    fun findScheduler(schedulerId: Long): SchedulerOutputPort

    fun createScheduler(schedulerInputPort: SchedulerInputPort): SchedulerOutputPort

    fun confirmScheduler(confirmSchedulerInputPort: ConfirmSchedulerInputPort): SchedulerOutputPort

    fun updateScheduler(schedulerId: Long, updateSchedulerPort: UpdateSchedulerInputPort): SchedulerOutputPort
}