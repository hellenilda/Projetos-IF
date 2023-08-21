package edu.ifpb.webII.model;

import java.util.List; 
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="professor_seq")
	@SequenceGenerator(name="professor_seq", sequenceName="professor_seq",allocationSize=1)
	private Long matricula;
	
	@Column
	private String nome;
	
	@Column
	private String area;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "professores")
	private List<Aluno> alunos;
	
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(matricula, other.matricula);
	}
}