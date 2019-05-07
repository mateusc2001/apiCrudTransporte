package com.viaflow.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.api.entity.Cliente;
import com.viaflow.api.repository.ClienteRepository;
import com.viaflow.api.service.ClienteService;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, ClienteRepository> implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;  
	
	@Override
	protected ClienteRepository getRepo() {
		return this.clienteRepository;
	}

}
