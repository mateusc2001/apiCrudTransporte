package com.viaflow.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.api.entity.LinhaOnibus;

@Component
public class LinhaOnibusValidation implements BaseValidation<LinhaOnibus>{

	@Override
	public boolean validateObject(LinhaOnibus object, BindingResult result) {
		// TODO Auto-generated method stub
		return true;
	}

}
