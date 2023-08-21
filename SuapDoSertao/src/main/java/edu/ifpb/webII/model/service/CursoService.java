package edu.ifpb.webII.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifpb.webII.model.Curso;
import edu.ifpb.webII.repository.CursoRepository;


@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursorepository;
	
	public List<Curso> listarCursos(){
		return cursorepository.findAll();
	}
	
	public Curso cadastrarCurso(Curso curso) {
		return cursorepository.save(curso);
	}
	
	public Curso atualizarCurso(Curso curso) {
		return cursorepository.save(curso);
	}
	
	public Curso listarCurso(Long matricula) {
		Curso curso = (Curso) cursorepository.findById(matricula).orElse(null); 
		return curso;
	}
	
	public String deletarCurso(Curso curso) {
		Long codigo = curso.getCodigo();
		cursorepository.deleteById(codigo);
		return "Curso de codigo " + codigo + " deletado com sucesso";
	}
	public String deletarCursoporID(Long codigo) {
		cursorepository.deleteById(codigo);
		return "Curso de codigo " + codigo + " deletado com sucesso";
	}

}
