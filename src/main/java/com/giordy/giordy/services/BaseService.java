package com.giordy.giordy.services;

import com.giordy.giordy.entities.Base;
import com.giordy.giordy.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;

public abstract class BaseService<E extends Base> {
    @Autowired
    protected BaseRepository<E> baseRepository;

    public Page<E> get(Specification<E> specification, Pageable pageable) {
        Page<E> page = baseRepository.findAll(specification, pageable);
        return new PageImpl<E>(page.getContent(), pageable, page.getTotalElements());
    }

    public Page<E> get(Specification<E> specification) {
        return (Page<E>) baseRepository.findAll(specification);
    }

    public E getById(Long id) {
        return findById(id);
    }

    @Transactional
    public E save(E entity) {
        baseRepository.save(entity);
        return getById(entity.getId());
    }

    @Transactional
    public E update(E entity) {
        getById(entity.getId());
        return save(entity);
    }

    @Transactional
    public E deleteSoft(Long id) {
        E entity = findById(id);
        entity.setActivated(false);
        return baseRepository.save(entity);
    }

    @Transactional
    public E deleteHard(Long id) {
        E entity = findById(id);
        baseRepository.deleteById(id);
        return entity;
    }

    public abstract E findById(Long id);
}
