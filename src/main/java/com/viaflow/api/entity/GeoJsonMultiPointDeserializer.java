package com.viaflow.api.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPoint;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class GeoJsonMultiPointDeserializer extends JsonDeserializer<GeoJsonMultiPoint> {
	
	@Override
	public GeoJsonMultiPoint deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		List<Point> points = new ArrayList<Point>();
		final JsonNode tree = jsonParser.getCodec().readTree(jsonParser);
		final JsonNode coordsNode = tree.get("coordinates");
		for (JsonNode jsonNode : coordsNode) {
			points.add(new Point(jsonNode.get("x").asDouble(), jsonNode.get("y").asDouble()));
		}		
		return new GeoJsonMultiPoint(points);
	}
}
