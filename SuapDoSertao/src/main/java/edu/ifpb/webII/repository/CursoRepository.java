package edu.ifpb.webII.repository;

import org.springframework.data.jpa.repository.*; 

import edu.ifpb.webII.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long> {

}