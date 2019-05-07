package com.viaflow.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.api.entity.LinhaOnibus;

@Repository
public interface LinhaOnibusRepository extends MongoRepository<LinhaOnibus, String>{
	Page<LinhaOnibus> findByNomeIgnoreCaseContaining(String nome, Pageable pages);
	List<LinhaOnibus> findByNomeIgnoreCaseContaining(String nome);
}