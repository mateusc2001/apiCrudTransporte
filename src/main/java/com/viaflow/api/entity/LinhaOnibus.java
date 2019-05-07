package com.viaflow.api.entity;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class LinhaOnibus {
	
	@Id
	private String linhaOnibusId;
	
	@NotEmpty
	private String idLinha;
	
	@NotEmpty
	private String codigo;

	@NotEmpty
	private String nome;
}
