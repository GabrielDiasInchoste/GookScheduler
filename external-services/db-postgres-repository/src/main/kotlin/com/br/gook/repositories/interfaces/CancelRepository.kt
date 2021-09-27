package com.br.gook.repositories.interfaces

import com.br.gook.repositories.model.CancelEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CancelRepository : JpaRepository<CancelEntity, Long> {}