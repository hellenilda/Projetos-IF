package edu.ifpb.webII.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpb.webII.model.Aluno;
import edu.ifpb.webII.model.AlunoDTO;
import edu.ifpb.webII.model.Professor;
import edu.ifpb.webII.repository.AlunoRepository;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listarAlunos(){
		return alunoRepository.findAll();
	}
	
	public Aluno cadastrarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno listarAluno(Long matricula){
		Aluno aluno = (Aluno) alunoRepository.findById(matricula).orElse(null); 
		return aluno;
	}
	
	public String deletarAluno(Long codigo) {
		alunoRepository.deleteById(codigo);
		return "Aluno de codigo " + codigo + " deletado com sucesso";
	}
	
	public List<AlunoDTO> listarAlunosDTOProfessor(Professor professor){
		Long cod_professor = professor.getMatricula();
		return alunoRepository.findAlunoDTOByProfessor(cod_professor);
	}
	public List<Aluno> listarAlunosProfessor(Professor professor){
		Long cod_professor = professor.getMatricula();
		return alunoRepository.findAlunoByProfessor(cod_professor);
	}

}
