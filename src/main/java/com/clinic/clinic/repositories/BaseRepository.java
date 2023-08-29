package com.clinic.clinic.repositories;

import com.clinic.clinic.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends Base> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}
