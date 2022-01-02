package com.icommerce.product.repository.shared;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericSearchSpecification<T> implements Specification<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2446230160485297675L;
	private SearchCriteria searchCriteria;

	public GenericSearchSpecification(final SearchCriteria criteria) {
		this.searchCriteria = criteria;
	}

	public SearchCriteria getCriteria() {
		return searchCriteria;
	}

	@Override
	public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {

		switch (searchCriteria.getOperation()) {
		case EQUALITY:
			return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(searchCriteria.getKey()), searchCriteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
		case LIKE:
			return builder.like(builder.lower(root.get(searchCriteria.getKey())), searchCriteria.getValue().toString().toLowerCase());
		case STARTS_WITH:
			return builder.like(builder.lower(root.get(searchCriteria.getKey())), searchCriteria.getValue().toString().toLowerCase() + "%");
		case ENDS_WITH:
			return builder.like(builder.lower(root.get(searchCriteria.getKey())), "%" + searchCriteria.getValue().toString().toLowerCase());
		case CONTAINS:
			return builder.like(builder.lower(root.get(searchCriteria.getKey())), "%" + searchCriteria.getValue().toString().toLowerCase() + "%");
		default:
			return null;
		}
	}

}
