package com.viaflow.api.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
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
	
	@CNPJ
	private String clienteCnpj;
	
	@NotEmpty
	private String endereco;
	
	@NotEmpty
	private String numero;
	
	private String complemento;
	
	@NotEmpty
	private String cidade;
	
	@NotEmpty
	private String bairro;
	
	@NotEmpty
	private String uf;
	
	private String fone;
	
	private String email;
	
	@DBRef
	private List<LinhaOnibus> linhaOnibus;
	
}
