package com.martinsaman.categoria_producto;

import com.martinsaman.categoria_producto.model.Categoria;
import com.martinsaman.categoria_producto.model.Producto;
import com.martinsaman.categoria_producto.repository.ICategoria;
import com.martinsaman.categoria_producto.repository.IProducto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CategoriaProductoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoriaProductoApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(ICategoria iCategoria, IProducto iProducto){
        return args -> {
            iProducto.deleteAll();
            iCategoria.deleteAll();

            iProducto.save(Producto.builder()
                    .nombre("platano")
                    .precio(5.0)
                    .categoria(
                            iCategoria.save(Categoria.builder().nombre("Verdura").estado("A").build())
                    )
                    .estado("A")
                    .build()
            );
        };
    }
}
