package com.br.gook.port.output

import com.br.gook.data.output.LocalOutputPort

interface LocalRepositoryOutput {

    fun saveLocal(localPort: LocalOutputPort): LocalOutputPort

    fun findLocalByIdOrThrow(localId: Long): LocalOutputPort

    fun deleteLocal(localId: Long)
}