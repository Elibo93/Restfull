package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;

public record CategoriaRequest(String nombre) {
    public CategoriaRequest(Categoria c) {
        this(c.getNombre());
    }

}