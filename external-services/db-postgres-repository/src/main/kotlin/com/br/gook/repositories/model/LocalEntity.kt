package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "LOCAL")
data class LocalEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "NAME")
    val name: String,

    @OneToOne
    @Column(name = "ADDRESS")
    val address: AddressEntity,

    @OneToMany
    @Column(name = "COURTS")
    val courts: List<CourtEntity>,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)