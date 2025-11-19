package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;
  

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;
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
