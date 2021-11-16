package com.br.gook.specification

import com.br.gook.data.output.PageSchedulerOutputPort
import com.br.gook.model.CourtEntity
import com.br.gook.model.SchedulerEntity
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.Predicate


class SpecificationSchedulerByFilter {

    private val COURT_ID = "id"
    private val COURT = "court"
    private val CUSTOMER_EMAIL = "customerEmail"
    private val STATUS = "status"

    fun findOrderByCriteria(request: PageSchedulerOutputPort): Specification<SchedulerEntity?> =
        Specification<SchedulerEntity?> { root, _, cb ->
            val predicates: MutableList<Predicate> = mutableListOf()

            if (request.courtId != null) {
                predicates.add(cb.equal(root.join<CourtEntity, Long>(COURT).get<Long>(COURT_ID), request.courtId))
            }
            if (request.status?.name != null) {
                predicates.add(cb.equal(root.get<String>(STATUS), request.status!!.name))
            }
            if (!request.customerEmail.isNullOrBlank()) {
                predicates.add(cb.like(root.get(CUSTOMER_EMAIL), request.customerEmail))
            }
//            if (request.getDateFrom() != null && request.getDateTo() != null) {
//                predicates.add(
//                    cb.between(
//                        root.get(request.getIdentifierDate()),
//                        request.getDateFrom(),
//                        request.getDateTo()
//                    )
//                )
//            }
            cb.and(*predicates.toTypedArray())
        }

}