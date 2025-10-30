package es.etg.daw.dawes.java.rest.restfull.productos.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.common.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.common.domain.repository.CRUDRepository;

public interface ProductoRepository extends CRUDRepository<Producto, ProductoId> {

    public Optional<Producto> getByName(String name);

}