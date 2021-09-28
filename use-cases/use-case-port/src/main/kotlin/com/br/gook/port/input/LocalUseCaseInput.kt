package com.br.gook.port.input

import com.br.gook.data.input.LocalInputPort
import com.br.gook.data.input.UpdateLocalInputPort
import com.br.gook.data.output.LocalOutputPort

interface LocalUseCaseInput {

    fun findLocal(localId: Long): LocalOutputPort

    fun createLocal(localInputPort: LocalInputPort): LocalOutputPort

    fun updateLocal(localId: Long,updateLocalInputPort: UpdateLocalInputPort): LocalOutputPort

    fun deleteLocal(localId: Long)
}