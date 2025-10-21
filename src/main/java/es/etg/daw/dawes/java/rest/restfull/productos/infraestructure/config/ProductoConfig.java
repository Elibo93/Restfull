package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.ProductoRepositoryMockImpl;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest.ProductoController;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

    private final ProductoRepository productoRepository;

    // POST
    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase(new ProductoRepositoryMockImpl());
    }

    @Bean
    public CreateProductoService createProductoService() {
        return new CreateProductoService(createProductoUseCase());
    }

    // GET
    @Bean
    public FindProductoUseCase findProductoUseCase() {
        return new FindProductoUseCase(productoRepository);
    }

    @Bean
    public FindProductoService findProductoService() {
        return new FindProductoService(findProductoUseCase());
    }

    // DELETE
    @Bean
    public DeleteProductoUseCase deleteProductoUseCase() {
        return new DeleteProductoUseCase();
    }

    @Bean
    public DeleteProductoService deleteProductoService() {
        return new DeleteProductoService();
    }

    // PUT
    @Bean
    public EditProductoUseCase editProductoUseCase() {
        return new EditProductoUseCase(new ProductoRepositoryMockImpl());
    }

    @Bean
    public EditProductoService editProductoService() {
        return new EditProductoService(editProductoUseCase());
    }
}