package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "SCHEDULER")
data class SchedulerEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "CUSTOMER_ID")
    val customerId: String,

    @OneToOne
    @Column(name = "COURT")
    val court: CourtEntity,

    @OneToOne
    @Column(name = "CANCEL")
    val cancel: CancelEntity?,

    @Column(name = "SCHEDULE")
    val schedule: LocalDateTime,

    @Column(name = "CONFIRM_DATE")
    val confirmDate: LocalDateTime,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime,

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)