package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
public interface CategoriaEntityJpaRepository extends JpaRepository<CategoriaEntity, Integer>{
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

   
    

}
