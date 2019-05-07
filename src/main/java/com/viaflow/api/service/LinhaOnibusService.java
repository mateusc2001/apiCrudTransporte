package com.viaflow.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.api.entity.LinhaOnibus;

@Service
public interface LinhaOnibusService extends BaseService<LinhaOnibus>{
	Page<LinhaOnibus> findByNome(String nome, int page, int count);
	List<LinhaOnibus> findByNome(String nome);
}
