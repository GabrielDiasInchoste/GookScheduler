package com.br.gook.repository

import com.br.gook.data.SchedulerStatusPort
import com.br.gook.model.SchedulerEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchedulerRepository : JpaRepository<SchedulerEntity, Long> {
    fun findByCourtIdAndCustomerEmailAndStatus(
        courtId: Long?,
        customerEmail: String?,
        status: SchedulerStatusPort?,
        pageable: Pageable
    ): Page<SchedulerEntity>
}