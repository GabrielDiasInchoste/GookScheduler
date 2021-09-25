package com.br.gook.repositories

import com.br.gook.data.*
import com.br.gook.port.output.PostgresRepositoryOutput
import com.br.gook.repositories.interfaces.*
import com.br.gook.repositories.mapper.toEntity
import com.br.gook.repositories.mapper.toPort
import org.jboss.logging.Logger
import org.springframework.stereotype.Service

@Service
class PostgresRepositoryImpl(
    private val addressRepository: AddressRepository,
    private val cancelRepository: CancelRepository,
    private val courtRepository: CourtRepository,
    private val localRepository: LocalRepository,
    private val schedulerRepository: SchedulerRepository,
) : PostgresRepositoryOutput {
    //TODO Criar repositorios separados
    private val log = Logger.getLogger(javaClass)

    override fun saveAddress(addressPort: AddressPort): AddressPort {
        addressRepository.findById(addressPort.id).ifPresent {
            log.error("PostgresRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
            throw Exception("PostgresRepositoryImpl.saveAddress - Address already saved with id - addressId: ${addressPort.id}")
        }
        return addressRepository.save(addressPort.toEntity()).toPort()
    }

    override fun findAddressByIdOrThrow(addressId: Int): AddressPort {
        return addressRepository.findById(addressId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findAddressByIdOrThrow - Error to find Address - addressId: $addressId")
    }

    override fun deleteAddress(productId: Int) {
        val productPort = findAddressByIdOrThrow(productId)
        addressRepository.delete(productPort.toEntity())
    }

    override fun saveCancel(cancelPort: CancelPort): CancelPort {
        cancelRepository.findById(cancelPort.id).ifPresent {
            log.error("PostgresRepositoryImpl.saveCancel - Cancel already saved with id - cancelId: ${cancelPort.id}")
            throw Exception("PostgresRepositoryImpl.saveCancel - Cancel already saved with id - cancelId: ${cancelPort.id}")
        }
        return cancelRepository.save(cancelPort.toEntity()).toPort()
    }

    override fun findCancelByIdOrThrow(cancelId: Int): CancelPort {
        return cancelRepository.findById(cancelId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findCancelByIdOrThrow - Error to find Cancel - cancelId: $cancelId")
    }

    override fun deleteCancel(cancelId: Int) {
        val cancelPort = findCancelByIdOrThrow(cancelId)
        cancelRepository.delete(cancelPort.toEntity())
    }

    override fun saveCourt(courtPort: CourtPort): CourtPort {
        courtRepository.findById(courtPort.id).ifPresent {
            log.error("PostgresRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
            throw Exception("PostgresRepositoryImpl.saveCourt - Court already saved with id - courtId: ${courtPort.id}")
        }
        return courtRepository.save(courtPort.toEntity()).toPort()
    }

    override fun findCourtByIdOrThrow(courtId: Int): CourtPort {
        return courtRepository.findById(courtId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findCourtByIdOrThrow - Error to find Court - courtId: $courtId")
    }

    override fun deleteCourt(courtId: Int) {
        val courtPort = findCourtByIdOrThrow(courtId)
        courtRepository.delete(courtPort.toEntity())
    }

    override fun saveLocal(localPort: LocalPort): LocalPort {
        localRepository.findById(localPort.id).ifPresent {
            log.error("PostgresRepositoryImpl.saveCourt - Local already saved with id - localId: ${localPort.id}")
            throw Exception("PostgresRepositoryImpl.saveCourt - Local already saved with id - localId: ${localPort.id}")
        }
        return localRepository.save(localPort.toEntity()).toPort()
    }

    override fun findLocalByIdOrThrow(localId: Int): LocalPort {
        return localRepository.findById(localId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findLocalByIdOrThrow - Error to find Local - localId: $localId")
    }

    override fun deleteLocal(localId: Int) {
        val localPort = findLocalByIdOrThrow(localId)
        localRepository.delete(localPort.toEntity())
    }

    override fun saveScheduler(schedulerPort: SchedulerPort): SchedulerPort {
        schedulerRepository.findById(schedulerPort.id).ifPresent {
            log.error("PostgresRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
            throw Exception("PostgresRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: ${schedulerPort.id}")
        }
        return schedulerRepository.save(schedulerPort.toEntity()).toPort()
    }

    override fun findSchedulerByIdOrThrow(schedulerId: Int): SchedulerPort {
        return schedulerRepository.findById(schedulerId).takeIf { it.isPresent }?.get()?.toPort()
            ?: throw Exception("PostgresRepositoryImpl.findSchedulerByIdOrThrow - Error to find Scheduler - schedulerId: $schedulerId")
    }

    override fun deleteScheduler(productId: Int) {
        val schedulerPort = findSchedulerByIdOrThrow(productId)
        schedulerRepository.delete(schedulerPort.toEntity())
    }
}