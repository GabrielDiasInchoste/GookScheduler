package com.br.gook.port.input

import com.br.gook.data.input.SchedulerInputPort
import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.data.input.UpdateSchedulerInputPort

interface SchedulerUseCaseInput {

    fun findScheduler(schedulerId: Long): SchedulerOutputPort

    fun createScheduler(schedulerInputPort: SchedulerInputPort): SchedulerOutputPort

    fun updateScheduler(schedulerId: Long, updateSchedulerPort: UpdateSchedulerInputPort): SchedulerOutputPort

    fun deleteScheduler(schedulerId: Long)
}