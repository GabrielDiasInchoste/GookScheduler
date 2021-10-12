package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_COURT")
data class CourtEntity(

    @Id
    @Column(name = "COURT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "LOCAL_ID")
    val localId: Long,

    @Column(name = "TYPE")
    val type: String,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)