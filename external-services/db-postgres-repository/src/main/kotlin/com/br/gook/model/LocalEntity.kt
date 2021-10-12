package com.br.gook.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_LOCAL")
data class LocalEntity(

    @Id
    @Column(name = "LOCAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "NAME")
    val name: String,

    @OneToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "ADDRESS_ID")
    val address: AddressEntity,

    @OneToMany(mappedBy = "localId", cascade = [CascadeType.ALL])
    val courts: MutableList<CourtEntity>,

    @Column(name = "CREATE_DATE")
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "LAST_MODIFIED_DATE")
    val lasModifiedDate: LocalDateTime

)