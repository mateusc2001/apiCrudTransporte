package com.viaflow.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.viaflow.api.response.Response;
import com.viaflow.api.service.BaseService;
import com.viaflow.api.validation.BaseValidation;

public abstract class BaseController<T, S extends BaseService<T>, V extends BaseValidation<T>> {
	
	protected abstract S getService();
	
	protected abstract V getValidation();
	
	@PostMapping
	public ResponseEntity<Response<T>> create(HttpServletRequest req, @RequestBody T object, 
			BindingResult result) { 
		Response<T> response = new Response<>();
		try {
			V validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(object, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			T persistedObject = getService().createOrUpdate(object);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}		
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<T>> update(HttpServletRequest req, @RequestBody T obj, 
			BindingResult result) { 
		Response<T> response = new Response<>();
		
		try {
			V validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(obj, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			T persistedObject = getService().createOrUpdate(obj);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Response<T>> findById(@PathVariable("id") String id) { 
		Response<T> response = new Response<>();
		T obj = getService().findById(id);
		if (obj == null) {
			response.getErrors().add("Register not found " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(obj);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/{page}/{count}")
	public ResponseEntity<Response<Page<T>>> findAll(@PathVariable("page") int page,
			@PathVariable("count") int count) { 
		Response<Page<T>> response = new Response<>();
		Page<T> list = getService().findAll(page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) { 
		Response<String> response = new Response<>();
		T obj = getService().findById(id);
		if (obj == null) {
			response.getErrors().add("Register not found " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		getService().delete(id);
		response.setData("Object Deleted");
		return ResponseEntity.ok(response);
	}
}
