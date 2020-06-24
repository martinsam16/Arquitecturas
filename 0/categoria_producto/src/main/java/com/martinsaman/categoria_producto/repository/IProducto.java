package com.martinsaman.categoria_producto.repository;

import com.martinsaman.categoria_producto.model.Categoria;
import com.martinsaman.categoria_producto.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProducto extends MongoRepository<Producto, String> {

    List<Producto> findAllByCategoria_Id(String categoria_id);
}
