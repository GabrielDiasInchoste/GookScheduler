package com.br.gook.repositories.interfaces

import com.br.gook.repositories.model.SchedulerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchedulerRepository : JpaRepository<SchedulerEntity, Int> {}