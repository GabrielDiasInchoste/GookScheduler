package com.br.gook.repository

import com.br.gook.model.CourtEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtRepository : JpaRepository<CourtEntity, Long>{
    fun findAll(
        criteria: Specification<CourtEntity?>,
        pageable: Pageable
    ): Page<CourtEntity>
}