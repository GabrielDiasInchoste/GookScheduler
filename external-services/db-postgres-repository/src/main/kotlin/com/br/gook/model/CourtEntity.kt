package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_COURT")
data class CourtEntity(

    @Id
    @Column(name = "COURT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURT_ID_SEQ")
    @SequenceGenerator(name = "COURT_ID_SEQ", sequenceName = "COURT_ID_SEQ", allocationSize = 1)
    val id: Long = 0,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "TYPE")
    val type: String,

    @Column(name = "DESCRIPTION")
    val description: String,

    @ManyToOne
    @JoinColumn(name = "LOCAL_ID")
    val local: LocalEntity,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)