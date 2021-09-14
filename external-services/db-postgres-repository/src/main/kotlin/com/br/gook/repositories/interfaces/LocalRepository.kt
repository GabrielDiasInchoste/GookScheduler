package com.br.gook.repositories.interfaces

import com.br.gook.repositories.model.LocalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocalRepository : JpaRepository<LocalEntity, Int> {}