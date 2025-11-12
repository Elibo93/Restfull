package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.ProductoFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest.ProductoController;

@SpringBootTest
public class ProductoControllerItTest {

    // Le decimos que nos inyecte el controlador (no hay new())
    @Autowired
    private ProductoController controller;

    @Test
    public void When_AllProductos_Expect_Lista() {

        int numProductos = ProductoFactory.getDemoData().values().size();

        var lista = controller.allProductos();

        assertAll(
                () -> assertNotNull(lista),
                () -> assertEquals(numProductos, lista.size()));

    }

}
