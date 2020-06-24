package com.martinsaman.categoria_producto.repository;

import com.martinsaman.categoria_producto.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoria extends MongoRepository<Categoria, String> {
}
