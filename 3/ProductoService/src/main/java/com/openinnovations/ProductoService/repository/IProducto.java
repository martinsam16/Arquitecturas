package com.openinnovations.ProductoService.repository;

import com.openinnovations.ProductoService.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProducto extends JpaRepository<Producto, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Producto p set p.ESTPROD='I' WHERE p.IDPROD = :idproducto")
    void eliminarProducto(@Param(value = "idproducto") Long idproducto);
    
}