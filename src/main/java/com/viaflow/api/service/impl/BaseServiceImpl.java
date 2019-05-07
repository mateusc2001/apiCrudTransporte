package com.viaflow.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.viaflow.api.service.BaseService;

public abstract class BaseServiceImpl<T, S extends MongoRepository<T, String>> implements BaseService<T> {

	protected abstract S getRepo();
	
	@Override
	public T createOrUpdate(T object) {
		return this.getRepo().save(object);
	}

	@Override
	public T findById(String id) {
		return this.getRepo().findById(id).get();
	}

	@Override
	public void delete(String id) {
		this.getRepo().deleteById(id);
	}

	@Override
	public Page<T> findAll(int page, int count) {
		Pageable pageable = PageRequest.of(page, count);
		return this.getRepo().findAll(pageable);
	}
}
