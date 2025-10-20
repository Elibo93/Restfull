package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import java.time.LocalDateTime;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;

public class EditProductoUseCase {
    public Producto update(EditProductoCommand comando) {

        // Se puede usar comando.id() y no getId() por usar @Accessors(fluent = true)
        // en la clase CreateProductoCommand
        Producto producto = Producto.builder()
                .id(comando.id())
                .nombre(comando.nombre())
                .precio(comando.precio())
                .createdAt(LocalDateTime.now()).build();

        // TODO Faltaría la lógica sobre el producto, por ejemplo, almacenarlo en una
        // base de datos.
        return producto;

    }
}
