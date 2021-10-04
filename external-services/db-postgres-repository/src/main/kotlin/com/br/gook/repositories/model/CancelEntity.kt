package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_CANCEL")
data class CancelEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CANCEL_REQUESTED_DATE")
    val cancelRequestedDate: LocalDateTime,

    @Column(name = "CANCEL_CONFIRMED_DATE")
    val cancelConfirmedDate: LocalDateTime?

)
