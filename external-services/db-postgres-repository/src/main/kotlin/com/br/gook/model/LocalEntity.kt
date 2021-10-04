package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.transaction.Transactional

@Entity
@Table(name = "TB_LOCAL")
data class LocalEntity(

    @Id
    @Column(name = "LOCAL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCAL_ID_SEQ")
    @SequenceGenerator(name = "LOCAL_ID_SEQ", sequenceName = "LOCAL_ID_SEQ", allocationSize = 1)
    val id: Long = 0,

    @Column(name = "NAME")
    val name: String,

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    val address: AddressEntity,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)