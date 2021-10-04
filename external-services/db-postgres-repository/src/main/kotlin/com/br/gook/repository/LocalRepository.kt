package com.br.gook.repository

import com.br.gook.model.LocalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocalRepository : JpaRepository<LocalEntity, Long>