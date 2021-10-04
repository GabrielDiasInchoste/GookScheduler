package com.br.gook.repository

import com.br.gook.model.CourtEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtRepository : JpaRepository<CourtEntity, Long>