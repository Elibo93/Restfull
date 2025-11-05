package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

    public Categoria create(CreateCategoriaCommand comando) {

        // Se puede usar comando.id() y no getId() por usar @Accessors(fluent = true)
        // en la clase CreateProductoCommand
        Categoria categoria = Categoria.builder()
                .nombre(comando.nombre())
                .createdAt(LocalDateTime.now()).build();

        categoriaRepository.save(categoria);
        return categoria;

    }
}
