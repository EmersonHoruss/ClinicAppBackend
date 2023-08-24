package com.giordy.giordy.utils.mappers;

import com.giordy.giordy.DTOs.entites.BaseDTO;
import com.giordy.giordy.DTOs.reponses.ResponseDTO;
import com.giordy.giordy.entities.Base;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@ToString
public class MapperBaseController<E extends Base, DTO extends BaseDTO> {

    private @Getter MapperBaseControllerTypes mapperTypes;

    public MapperBaseController(Class<?> baseControllerClass) {
        mapperTypes = new MapperBaseControllerTypes(baseControllerClass);
    }

    public ResponseDTO mapToDTOs(Page<E> entities, String query) {
        Page<DTO> entitiesDTO = entities.map(mapperTypes::mapToDTO);
        return new ResponseDTO(entitiesDTO.getContent(), entitiesDTO, query);
    }

    public ResponseDTO mapToDTO(E entity) {
        DTO entityDTO = mapperTypes.mapToDTO(entity);
        return new ResponseDTO(entityDTO);
    }

    public ResponseDTO mapToEntity(DTO entityDTO) {
        E entity = mapperTypes.mapToEntity(entityDTO);
        return new ResponseDTO(entity);
    }

    public class MapperBaseControllerTypes {
        private Mapper mapper = null;
        private Type entityType = null;
        private Type entityDTOType = null;

        public MapperBaseControllerTypes(Class<?> baseControllerClass) {
            mapper = new Mapper();
            try {
                String canonicalName = baseControllerClass.getCanonicalName();
                Type genericSuperClass = Class.forName(canonicalName).getGenericSuperclass();
                Type[] types = ((ParameterizedType) genericSuperClass).getActualTypeArguments();
                entityType = types[0];
                entityDTOType = types[2];
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public E mapToEntity(DTO entityDTO) {
            return mapper.map(entityDTO, entityType);
        }

        public DTO mapToDTO(E entity) {
            return mapper.map(entity, entityDTOType);
        }
    }
}
