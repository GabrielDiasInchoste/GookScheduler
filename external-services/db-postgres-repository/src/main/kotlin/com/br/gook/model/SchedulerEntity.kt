package com.br.gook.model

import com.br.gook.SchedulerStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_SCHEDULER")
data class SchedulerEntity(

    @Id
    @Column(name = "SCHEDULER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "CUSTOMER_ID")
    val customerId: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    val status: SchedulerStatus,

    @OneToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "COURT_ID")
    val court: CourtEntity,

    @OneToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "CANCEL_ID")
    val cancel: CancelEntity?,

    @Column(name = "SCHEDULE")
    val schedule: LocalDateTime,

    @Column(name = "CONFIRM_DATE")
    val confirmDate: LocalDateTime?,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)