package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductoUseCase {

	private ProductoRepository productoRepository;

	public Producto create(CreateProductoCommand comando) {

		// Se puede usar comando.id() y no getId() por usar @Accessors(fluent = true)
		// en la clase CreateProductoCommand
		Producto producto = Producto.builder()
				.nombre(comando.nombre())
				.precio(comando.precio())
				.createdAt(LocalDateTime.now()).build();

		productoRepository.save(producto);
		return producto;

	}
}