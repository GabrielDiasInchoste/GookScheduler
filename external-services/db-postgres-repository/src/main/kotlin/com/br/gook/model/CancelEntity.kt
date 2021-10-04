package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_CANCEL")
data class CancelEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCEL_ID_SEQ")
    @SequenceGenerator(name = "CANCEL_ID_SEQ", sequenceName = "CANCEL_ID_SEQ", allocationSize = 1)
    val id: Long = 0,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CANCEL_REQUESTED_DATE")
    val cancelRequestedDate: LocalDateTime,

    @Column(name = "CANCEL_CONFIRMED_DATE")
    val cancelConfirmedDate: LocalDateTime?

)
