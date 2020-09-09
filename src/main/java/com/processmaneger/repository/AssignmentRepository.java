package com.processmaneger.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.processmaneger.entity.Assignment;

import java.util.List;

public interface AssignmentRepository extends PagingAndSortingRepository<Assignment, Long> {
	List<Assignment> findByNomeIgnoreCaseContaining(String description);
	List<Assignment> findByNome(String description);
//	List<Assignment> findAll();
}

