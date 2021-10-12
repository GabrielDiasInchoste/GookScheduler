package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_CANCEL")
data class CancelEntity(

    @Id
    @Column(name = "CANCEL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CANCEL_REQUESTED_DATE")
    val cancelRequestedDate: LocalDateTime,

    @Column(name = "CANCEL_CONFIRMED_DATE")
    val cancelConfirmedDate: LocalDateTime?,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)
