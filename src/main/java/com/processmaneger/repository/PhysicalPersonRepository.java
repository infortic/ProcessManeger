package com.processmaneger.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.processmaneger.entity.PhysicalPerson;

import java.util.List;

public interface PhysicalPersonRepository extends PagingAndSortingRepository<PhysicalPerson, Long> {
	List<PhysicalPerson> findByNomeIgnoreCaseContaining(String nome);
	List<PhysicalPerson> findByNome(String nome);
}

