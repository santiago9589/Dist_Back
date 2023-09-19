package com.app.app.repository;

import com.app.app.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Productos,String> {
}
