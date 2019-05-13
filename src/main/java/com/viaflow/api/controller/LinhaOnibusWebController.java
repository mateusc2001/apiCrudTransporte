package com.viaflow.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.api.entity.LinhaOnibus;
import com.viaflow.api.response.Response;
import com.viaflow.api.service.LinhaOnibusService;
import com.viaflow.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/linhaOnibus")
@CrossOrigin(origins = "*")
public class LinhaOnibusWebController
		extends BaseController<LinhaOnibus, LinhaOnibusService, BaseValidation<LinhaOnibus>> {

	@Autowired
	private LinhaOnibusService linhaOnibusService;

	@Autowired
	private BaseValidation<LinhaOnibus> linhaOnibusValidation;

	@Override
	protected LinhaOnibusService getService() {
		return this.linhaOnibusService;
	}

	@Override
	protected BaseValidation<LinhaOnibus> getValidation() {
		return this.linhaOnibusValidation;
	}

	@GetMapping(value = "/find/name/{name}/{page}/{count}")
	public ResponseEntity<Response<Page<LinhaOnibus>>> getContractByName(@PathVariable("name") String nome, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<LinhaOnibus>> response = new Response<>();
		Page<LinhaOnibus> linhaOnibus = getService().findByNome(nome, page, count);
		if(linhaOnibus == null) {
			response.getErrors().add("Register not found "+ nome);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(linhaOnibus);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/name/{name}")
	public ResponseEntity<Response<List<LinhaOnibus>>> getContractByName(@PathVariable("name") String nome){
		Response<List<LinhaOnibus>> response = new Response<>();
		List<LinhaOnibus> linhaOnibus = getService().findByNome(nome);
		if(linhaOnibus == null) {
			response.getErrors().add("Register not found "+ nome);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(linhaOnibus);
		return ResponseEntity.ok(response);
	}

}
