package com.br.gook.repository

import com.br.gook.model.SchedulerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchedulerRepository : JpaRepository<SchedulerEntity, Long>