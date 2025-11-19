package es.etg.daw.dawes.java.rest.restfull.productos.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Producto {

	// Atributos
	private ProductoId id;
	private String nombre;
	private double precio;
	private LocalDateTime createdAt;

	// Agregamos la categoría
	private CategoriaId categoria;
}