package com.br.gook.repository

import com.br.gook.model.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface AddressRepository : JpaRepository<AddressEntity, Long>