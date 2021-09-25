package com.br.gook.port.output

import com.br.gook.data.*


interface PostgresRepositoryOutput {

    fun saveAddress(addressPort: AddressPort): AddressPort

    fun findAddressByIdOrThrow(addressId: Int): AddressPort

    fun deleteAddress(productId: Int)

    fun saveCancel(cancelPort: CancelPort): CancelPort

    fun findCancelByIdOrThrow(cancelId: Int): CancelPort

    fun deleteCancel(cancelId: Int)

    fun saveCourt(courtPort: CourtPort): CourtPort

    fun findCourtByIdOrThrow(courtId: Int): CourtPort

    fun deleteCourt(courtId: Int)

    fun saveLocal(localPort: LocalPort): LocalPort

    fun findLocalByIdOrThrow(localId: Int): LocalPort

    fun deleteLocal(localId: Int)

    fun findSchedulerByIdOrThrow(schedulerId: Int): SchedulerPort

    fun saveScheduler(schedulerPort: SchedulerPort): SchedulerPort

    fun deleteScheduler(schedulerId: Int)
}