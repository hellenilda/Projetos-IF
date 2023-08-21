package edu.ifpb.webII.model;

import java.util.List; 
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="Aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="aluno_seq")
	@SequenceGenerator(name="aluno_seq", sequenceName="aluno_seq",allocationSize=1)
	private Long matricula;
	
	@Column
	private String nome;

	@Embedded
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_resp", referencedColumnName = "id_resp")
	private Responsavel responsavel;
	
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	@ManyToMany
	@JoinTable(name="aluno_professor",
				joinColumns = {@JoinColumn(name="matricula_aluno")},
				inverseJoinColumns = {@JoinColumn(name="matricula_professor")} 
			)
	private List<Professor> professores;
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome; 
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
	
	
	
	

}
