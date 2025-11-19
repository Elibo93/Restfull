package es.etg.daw.dawes.java.rest.restfull.Categorias.infraestructure.db.jpa.repository;

    package es.etg.daw.dawes.java.rest.restfull.Categorias.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaJpaRepositoryImpl implements CategoriaRepository {

    private final CategoriaEntityJpaRepository repository;

    @Override
    public Categoria save(Categoria t) {

        CategoriaEntity prod = CategoriaMapper.toEntity(t);
        return CategoriaMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Categoria> getAll() {
        return CategoriaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        Optional<Categoria> Categoria = null;
        Optional<CategoriaEntity> pe = repository.findById(id.getValue());

        if (pe.isEmpty()) {
            Categoria = Optional.empty();
        } else {
            Categoria = Optional.of(CategoriaMapper.toDomain(pe.get()));
        }

        return Categoria;
    }

    @Override
    public void deleteById(CategoriaId id) {
        repository.deleteById(id.getValue());
    }


}
