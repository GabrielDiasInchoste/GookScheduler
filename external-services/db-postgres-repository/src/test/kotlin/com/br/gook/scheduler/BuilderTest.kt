package com.br.gook.scheduler

import com.br.gook.SchedulerStatus
import com.br.gook.data.SchedulerStatusPort
import com.br.gook.data.output.*
import com.br.gook.model.*
import java.time.LocalDateTime

class BuilderTest {
    val addressId: Long = 1
    val courtId: Long = 1
    val localId: Long = 1
    val schedulerId: Long = 1
    val cancelId: Long = 1

    val addressEntity = AddressEntity(
        id = 1,
        name = "Princesa Isabel",
        number = 626,
        description = "Esquina",
        cep = "99050-510",
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11),
    )

    val addressOutputPort = AddressOutputPort(
        id = 1,
        name = "Princesa Isabel",
        number = 626,
        description = "Esquina",
        cep = "99050-510",
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val cancelEntity = CancelEntity(
        id = 1,
        description = "Arrependimento",
        cancelRequestedDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        cancelConfirmedDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val cancelOutputPort = CancelOutputPort(
        id = 1,
        description = "Arrependimento",
        cancelRequestedDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        cancelConfirmedDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val courtEntity = CourtEntity(
        id = 1,
        name = "Arena de futsal",
        type = "futsal",
        description = "Tamano 150m quadrados",
        localId = 1,
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val courtOutputPort = CourtOutputPort(
        id = 1,
        name = "Arena de futsal",
        type = "futsal",
        description = "Tamano 150m quadrados",
        localId = 1,
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val localEntity = LocalEntity(
        id = 1,
        name = "Arena de Esportes",
        address = addressEntity,
        courts = mutableListOf(),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )


    val localOutputPort = LocalOutputPort(
        id = 1,
        name = "Arena de Esportes",
        address = addressOutputPort,
        courts = mutableListOf(),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )

    val schedulerEntity = SchedulerEntity(
        id = 1,
        customerId = "03345585524",
        status = SchedulerStatus.REQUESTED,
        court = courtEntity,
        cancel = cancelEntity,
        schedule = LocalDateTime.of(2021, 10, 14, 15, 11),
        confirmDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )

    val schedulerOutputPort = SchedulerOutputPort(
        id = 1,
        customerId = "03345585524",
        status = SchedulerStatusPort.REQUESTED,
        court = courtOutputPort,
        cancel = cancelOutputPort,
        schedule = LocalDateTime.of(2021, 10, 14, 15, 11),
        confirmDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        createDate = LocalDateTime.of(2021, 10, 14, 15, 11),
        lasModifiedDate = LocalDateTime.of(2021, 10, 14, 15, 11)
    )

}