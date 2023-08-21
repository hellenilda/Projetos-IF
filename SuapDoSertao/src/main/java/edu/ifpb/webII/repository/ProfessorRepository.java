package edu.ifpb.webII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifpb.webII.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
	


}
