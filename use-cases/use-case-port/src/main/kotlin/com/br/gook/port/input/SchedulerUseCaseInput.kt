package com.br.gook.port.input

import com.br.gook.data.output.SchedulerOutputPort
import com.br.gook.data.input.UpdateSchedulerInputPort

interface SchedulerUseCaseInput {

    fun findScheduler(schedulerId: Int): SchedulerOutputPort

    fun createScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort

    fun updateScheduler(schedulerId: Int,updateSchedulerPort: UpdateSchedulerInputPort): SchedulerOutputPort

    fun deleteScheduler(schedulerId: Int)
}