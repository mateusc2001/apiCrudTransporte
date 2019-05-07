package com.viaflow.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.api.entity.LinhaOnibus;
import com.viaflow.api.repository.LinhaOnibusRepository;
import com.viaflow.api.service.LinhaOnibusService;

@Service
public class LinhaOnibusServiceImpl extends BaseServiceImpl<LinhaOnibus, LinhaOnibusRepository>
		implements LinhaOnibusService {

	@Autowired
	private LinhaOnibusRepository linhaOnibusRepository;

	@Override
	protected LinhaOnibusRepository getRepo() {
		return this.linhaOnibusRepository;
	}

	@Override
	public Page<LinhaOnibus> findByNome(String nome, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByNomeIgnoreCaseContaining(nome, pages);
	}
	
	@Override
	public List<LinhaOnibus> findByNome(String nome) {
		return this.getRepo().findByNomeIgnoreCaseContaining(nome);
	}
}
