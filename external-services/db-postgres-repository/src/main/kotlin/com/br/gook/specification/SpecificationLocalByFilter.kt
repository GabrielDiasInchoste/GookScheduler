package com.br.gook.specification

import com.br.gook.data.output.PageLocalOutputPort
import com.br.gook.model.CourtEntity
import com.br.gook.model.LocalEntity
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.Predicate


class SpecificationLocalByFilter {

    private val ID = "id"
    private val COURTS = "courts"
    private val ADDRESS = "address"

    fun findOrderByCriteria(request: PageLocalOutputPort): Specification<LocalEntity?> =
        Specification<LocalEntity?> { root, _, cb ->
            val predicates: MutableList<Predicate> = mutableListOf()

            if (request.courtId != null) {
                predicates.add(cb.equal(root.join<CourtEntity, Long>(COURTS).get<Long>(ID), request.courtId))
            }
            if (request.addressId != null) {
                predicates.add(cb.equal(root.join<CourtEntity, Long>(ADDRESS).get<Long>(ID), request.addressId))
            }

            cb.and(*predicates.toTypedArray())
        }

}