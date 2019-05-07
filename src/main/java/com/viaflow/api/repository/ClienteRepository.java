package com.viaflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.api.entity.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
