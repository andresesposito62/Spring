package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.Category;
import com.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    // Esta anotacion le indica
    // a mapstruct que esta es la operacion inversa
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)//Productos no existe en Categoriy
    Categoria toCategoria(Category category);

}
