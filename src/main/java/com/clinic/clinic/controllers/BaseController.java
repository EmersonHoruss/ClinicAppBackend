package com.clinic.clinic.controllers;

import com.clinic.clinic.entities.Base;
import com.clinic.clinic.DTOs.entites.BaseDTO;
import com.clinic.clinic.DTOs.reponses.ResponseDTO;
import com.clinic.clinic.services.BaseService;
import com.clinic.clinic.utils.mappers.MapperBaseController;
import com.clinic.clinic.utils.specification.Specification;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class BaseController<E extends Base, DTO extends BaseDTO> {
    @Autowired
    private BaseService<E> service;
    private MapperBaseController<E, DTO> mapper = new MapperBaseController(getClass());

    @GetMapping("")
    public ResponseEntity<?> get(@RequestParam(required = false) String query,@ParameterObject Pageable pageable) {
        Page<E> entities = service.get(new Specification<E>(query), pageable);
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@Valid @PathVariable Long id) {
        E entity = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(entity));
    }

    @PostMapping("")
    public Object create(@Valid @RequestBody DTO entityDTO) {
        E entity = mapper.getMapperTypes().mapToEntity(entityDTO);
        entity = service.save(entity);

        //return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(savedEntity));
        return entity;
    }

    @PutMapping("")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody DTO entityDTO) {
        E entity = mapper.getMapperTypes().mapToEntity(entityDTO);
        E savedEntity = service.update(entity);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(savedEntity));
    }

    @DeleteMapping("/{id}/{soft}")
    public ResponseEntity<ResponseDTO> delete(
            @Valid @PathVariable Long id,
            @Valid @PathVariable boolean soft) {
        System.out.println("soft: " + soft);
        E entity = null;
        if (soft) {
            entity = service.deleteSoft(id);
        } else {
            entity = service.deleteHard(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(entity));
    }
}
