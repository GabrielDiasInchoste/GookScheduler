package com.br.gook.port.output

import com.br.gook.data.output.PageSchedulerOutputPort
import com.br.gook.data.output.PageSchedulerResponseOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import org.springframework.data.domain.PageRequest

interface SchedulerRepositoryOutput {

    fun findSchedulerByIdOrThrow(schedulerId: Long): SchedulerOutputPort

    fun findAllSchedulerWithPaginate(
        pageRequest: PageRequest,
        pageSchedulerOutputPort: PageSchedulerOutputPort
    ): PageSchedulerResponseOutputPort

    fun saveScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort

    fun updateScheduler(schedulerPort: SchedulerOutputPort): SchedulerOutputPort
}