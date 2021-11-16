package com.br.gook.specification

import com.br.gook.data.output.PageCourtOutputPort
import com.br.gook.model.CourtEntity
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.Predicate


class SpecificationCourtByFilter {

    private val ID = "id"
    private val LOCAL_ID = "localId"
    private val TYPE = "type"

    fun findOrderByCriteria(request: PageCourtOutputPort): Specification<CourtEntity?> =
        Specification<CourtEntity?> { root, _, cb ->
            val predicates: MutableList<Predicate> = mutableListOf()

            if (request.localId != null) {
                predicates.add(cb.equal(root.get<Long>(LOCAL_ID), request.localId!!))
            }
            if (!request.type.isNullOrBlank()) {
                predicates.add(cb.like(root.get(TYPE), request.type))
            }

            cb.and(*predicates.toTypedArray())
        }

}