package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_ADDRESS")
data class AddressEntity(

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "NAME")
    val name: String,

    @Column(name = "NUMBER")
    val number: Int,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "CEP")
    val cep: String,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime,
)