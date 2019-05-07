package com.viaflow.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.api.entity.Cliente;

@Component
public class ClienteValidation implements BaseValidation<Cliente>{

	@Override
	public boolean validateObject(Cliente object, BindingResult result) {
		return true;
	}

}
