package com.br.gook.repositories.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ADDRESS")
data class AddressEntity(

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "NUMBER")
    val number: Int,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CEP")
    val cep: String,

    @Column(name = "CONFIRM_DATE")
    val confirmDate: LocalDateTime,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime,

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime,
)