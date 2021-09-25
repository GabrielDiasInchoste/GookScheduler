package com.br.gook.port.input

import com.br.gook.data.SchedulerPort

interface SchedulerUseCaseInput {

    fun findScheduler(schedulerId: Int): SchedulerPort

    fun createScheduler(schedulerPort: SchedulerPort): SchedulerPort

    fun updateScheduler(schedulerId: Int,schedulerPort: SchedulerPort): SchedulerPort

    fun deleteScheduler(schedulerId: Int)
}