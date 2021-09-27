package com.br.gook.repositories.interfaces

import com.br.gook.repositories.model.CourtEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtRepository : JpaRepository<CourtEntity, Long> {}