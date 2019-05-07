package com.viaflow.api.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {
	
	@Id
	private String clienteId;
	
	@NotEmpty
	private String clienteNome;
	
	@DBRef
	private List<LinhaOnibus> bus;
}
