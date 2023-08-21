package edu.ifpb.webII.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpb.webII.model.Professor;
import edu.ifpb.webII.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> listarProfessores(){
		return professorRepository.findAll();
	}
	
	public Professor cadastrarProfessor(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor atualizarProfessor(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor listarProfessor(Long matricula) {
		Professor professor = (Professor) professorRepository.findById(matricula).orElse(null); 
		return professor;
	}
	
	public String deletarProfessor(Long codigo) {
		professorRepository.deleteById(codigo);
		return "Professor de codigo " + codigo + " deletado com sucesso";
	}

}
