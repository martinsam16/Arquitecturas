package com.example.categoria.repository;

import com.example.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICategoria extends JpaRepository<Categoria, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Categoria c set c.ESTCAT='I' WHERE c.IDCAT = :idcategoria")
    void eliminarCategoria(@Param(value = "idcategoria") Long idcategoria);

}
