package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class CancelEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "Description")
    val description: String,

    @Column(name = "CANCEL_REQUESTED_DATE")
    val cancelRequestedDate: LocalDateTime,

    @Column(name = "CANCEL_CONFIRMED_DATE")
    val cancelConfirmedDate: LocalDateTime

)
