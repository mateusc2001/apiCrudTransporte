package com.viaflow.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.api.entity.Cliente;
import com.viaflow.api.service.ClienteService;
import com.viaflow.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteWebController extends BaseController<Cliente, ClienteService, BaseValidation<Cliente>>{

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BaseValidation<Cliente> baseValidation;
	
	@Override
	protected ClienteService getService() {
		return this.clienteService;
	}

	@Override
	protected BaseValidation<Cliente> getValidation() {
		return this.baseValidation;
	}

}
