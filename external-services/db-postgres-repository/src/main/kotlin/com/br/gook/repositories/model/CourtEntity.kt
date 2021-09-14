package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "COURT")
data class CourtEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "TYPE")
    val type: String,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime,

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)