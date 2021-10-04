package com.br.gook.repository

import com.br.gook.model.CancelEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CancelRepository : JpaRepository<CancelEntity, Long>