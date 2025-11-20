package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.CategoriaFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;

@DataJpaTest(showSql = true)
public class CategoriaEntityJpaRepositoryTest {

    @Autowired

    private CategoriaEntityJpaRepository repository;

    @Test
    @Order(1)
    void findAll() {

        var Categorias = repository.findAll();

        assertAll(
                () -> assertNotNull(Categorias),
                () -> assertTrue(!Categorias.isEmpty()));
    }

    @Test
    @Order(2)
    void findById() {
        final double PRECISION = 0.001;
        update(); // Actualizo y recupero el dato controlado
        var p = CategoriaFactory.create(); // Categoria cambiado antes, vamos a ve rsi está bien

        var Categoria = repository.findById(p.getId().getValue()).get();

        assertAll(
                () -> assertNotNull(Categoria),
                () -> assertEquals(Categoria.getId(), p.getId().getValue()),
                () -> assertEquals(Categoria.getNombre(), p.getNombre()),
                );
    }

    @Test
    @Order(3)
    void findByName() {
        final double PRECISION = 0.001;
        update(); // Actualizo y recupero el dato controlado
        var p = CategoriaFactory.create(); // Categoria cambiado antes, vamos a ve rsi está bien

        var Categoria = repository.findByNombre(p.getNombre());

        assertAll(
                () -> assertNotNull(Categoria),
                () -> assertEquals(Categoria.getId(), p.getId().getValue()),
                () -> assertEquals(Categoria.getNombre(), p.getNombre())
                );
    }

    @Test
    @Order(5)
    void create() {
        var nuevo = CategoriaMapper.toEntity(CategoriaFactory.create());
        nuevo.setId(null);
        var Categoria = repository.save(nuevo);

        assertAll(
                () -> assertNotNull(Categoria),
                () -> assertTrue(Categoria.getId() != null));
    }

    @Test
    @Order(10)
    void update() {
        var nuevo = CategoriaMapper.toEntity(CategoriaFactory.create());
        var Categoria = repository.save(nuevo);

        assertAll(
                () -> assertNotNull(Categoria),
                () -> assertTrue(Categoria.getId() != null));
    }

    @Test
    @Order(15)
    void delete() {
        var Categoria = repository.findById(1);
        repository.delete(Categoria.get());

        var CategoriaEliminado = repository.findById(1).isEmpty();
        assertAll(
                () -> assertTrue(CategoriaEliminado));
    }

}
