package com.icommerce.product.service.shared;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class AbstractCustomValidator<T> {

	private Validator validator;

	public AbstractCustomValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Evaluates all Bean Validations on the attributes of this instance.
	 */
	@SuppressWarnings("unchecked")
	public void validateSelf(Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate((T) this, groups);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
}
