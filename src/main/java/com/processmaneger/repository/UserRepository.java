package com.processmaneger.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.processmaneger.entity.UserEntity;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	List<UserEntity> findByNomeIgnoreCaseContaining(String nome);
	List<UserEntity> findByNome(String nome);
}

