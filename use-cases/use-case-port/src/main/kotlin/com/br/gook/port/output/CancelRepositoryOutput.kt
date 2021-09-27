package com.br.gook.port.output

import com.br.gook.data.output.CancelOutputPort

interface CancelRepositoryOutput {

    fun saveCancel(cancelPort: CancelOutputPort): CancelOutputPort

    fun findCancelByIdOrThrow(cancelId: Long): CancelOutputPort

    fun deleteCancel(cancelId: Long)
}