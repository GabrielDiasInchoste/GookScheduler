package com.br.gook.port.output

import com.br.gook.data.output.CancelOutputPort

interface CancelRepositoryOutput {

    fun saveCancel(cancelPort: CancelOutputPort): CancelOutputPort

    fun findCancelByIdOrThrow(cancelId: Int): CancelOutputPort

    fun deleteCancel(cancelId: Int)
}