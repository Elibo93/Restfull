package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;


public class CategoriaRepositoryMockImplTest {
    CategoriaRepository repository = new CategoriaRepositoryMockImpl();

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new CategoriaRepositoryMockImpl();

    }

    @Test
    void save() {
        var categoria = CategoriaFactory.create();

        Categoria p = repository.save(categoria);

        assertAll(
                () -> assertNotNull(p), // el producto no es nulo
                () -> assertNotNull(p.getId()), // el producto creado tiene id
                () -> assertNotNull(repository.getById(p.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        var categorias = repository.getAll();

        assertAll(
                () -> assertNotNull(categorias),
                () -> assertEquals(CategoriaFactory.getDemoData().size(), categorias.size()));
    }

}
