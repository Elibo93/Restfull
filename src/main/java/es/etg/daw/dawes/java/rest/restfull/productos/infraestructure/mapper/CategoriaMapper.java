package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaResponse;



public class CategoriaMapper {
    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest) {
        return new CreateCategoriaCommand(categoriaRequest.nombre());
    }

    public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest) {
        // pasamos del int a CategoriaId
        return new EditCategoriaCommand(new CategoriaId(id), categoriaRequest.nombre());
    }

    public static CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId().getValue(), // lo pasamos a int
                categoria.getNombre(),
                categoria.getCreatedAt());

    }
    
    public static CategoriaEntity toEntity(Categoria p){

        // Defino la categoría
        CategoriaId id = p.getId();
        return CategoriaEntity.builder().id(id!=null?id.getValue():null)
                                        .nombre(p.getNombre())
                                       .build();

    }

    public static Categoria toDomain(CategoriaEntity p){
        return Categoria.builder().id(new CategoriaId(p.getId()))
                                 .nombre(p.getNombre())
                                 .build();

    }

    public static List<Categoria> toDomain(List<CategoriaEntity> lista){
        List<Categoria> lp = new ArrayList<>();
        for(CategoriaEntity pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }
}


