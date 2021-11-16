package com.br.gook.repository

import com.br.gook.model.LocalEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocalRepository : JpaRepository<LocalEntity, Long> {
    fun findAll(
        criteria: Specification<LocalEntity?>,
        pageable: Pageable
    ): Page<LocalEntity>
}