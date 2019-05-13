package com.viaflow.api.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
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
	
	private List<Coordenadas> coordenadas;
	
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonMultiPoint location;	
}
