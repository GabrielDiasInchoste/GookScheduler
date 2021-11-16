package com.br.gook.port.output

import com.br.gook.data.output.LocalOutputPort
import com.br.gook.data.output.PageLocalOutputPort
import com.br.gook.data.output.PageLocalResponseOutputPort
import org.springframework.data.domain.PageRequest

interface LocalRepositoryOutput {

    fun saveLocal(localPort: LocalOutputPort): LocalOutputPort

    fun updateLocal(localPort: LocalOutputPort): LocalOutputPort

    fun findLocalByIdOrThrow(localId: Long): LocalOutputPort

    fun deleteLocal(localId: Long)

    fun findAllLocalWithPaginate(
        pageRequest: PageRequest,
        pageLocalOutputPort: PageLocalOutputPort
    ): PageLocalResponseOutputPort

}