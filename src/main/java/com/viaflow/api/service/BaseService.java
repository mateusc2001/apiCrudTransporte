package com.viaflow.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {
	T createOrUpdate(T object);
	
	T findById(String id);
	
	void delete(String id);
	
	Page<T> findAll(int page, int count);
}
