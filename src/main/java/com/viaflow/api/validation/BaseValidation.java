package com.viaflow.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface BaseValidation<T> {
	boolean validateObject(T object, BindingResult result);
}
