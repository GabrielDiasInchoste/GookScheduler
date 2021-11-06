package com.br.gook.port.input

import com.br.gook.data.input.ConfirmSchedulerInputPort
import com.br.gook.data.input.PageSchedulerInputPort
import com.br.gook.data.input.SchedulerInputPort
import com.br.gook.data.input.UpdateSchedulerInputPort
import com.br.gook.data.output.PageSchedulerOutputPort
import com.br.gook.data.output.PageSchedulerResponseOutputPort
import com.br.gook.data.output.SchedulerOutputPort
import org.springframework.data.domain.PageRequest

interface SchedulerUseCaseInput {

    fun findScheduler(schedulerId: Long): SchedulerOutputPort

    fun findAllSchedulerWithPaginate(
        pageRequest: PageRequest,
        pageSchedulerInputPort: PageSchedulerInputPort
    ): PageSchedulerResponseOutputPort

    fun createScheduler(schedulerInputPort: SchedulerInputPort): SchedulerOutputPort

    fun confirmScheduler(confirmSchedulerInputPort: ConfirmSchedulerInputPort): SchedulerOutputPort

    fun updateScheduler(schedulerId: Long, updateSchedulerPort: UpdateSchedulerInputPort): SchedulerOutputPort
}