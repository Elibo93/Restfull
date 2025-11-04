package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import es.etg.daw.dawes.java.rest.restfull.common.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.DeleteProductoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProductoService {

    private final DeleteProductoUseCase deleteProductoUseCase;

    public void delete(ProductoId id) {
        deleteProductoUseCase.delete(id);

    }

}
