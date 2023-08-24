package com.giordy.giordy.repositories;

import com.giordy.giordy.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends Base> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}
