package com.br.gook.port.output

import com.br.gook.data.output.SchedulerOutputPort

interface SchedulerRepositoryOutput {

    fun findSchedulerByIdOrThrow(schedulerId: Long): SchedulerOutputPort

    fun saveScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort

    fun deleteScheduler(schedulerId: Long)
}