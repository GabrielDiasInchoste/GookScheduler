package com.br.gook.repository

import com.br.gook.model.SchedulerEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchedulerRepository : JpaRepository<SchedulerEntity, Long> {
    fun findAll(
        criteria: Specification<SchedulerEntity?>,
        pageable: Pageable
    ): Page<SchedulerEntity>
}