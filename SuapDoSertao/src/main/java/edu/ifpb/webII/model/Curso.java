package edu.ifpb.webII.model;

import java.util.Objects; 

import jakarta.persistence.*;

@Entity
@Table(name="Curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="curso_seq")
	@SequenceGenerator(name="curso_seq", sequenceName="curso_seq",allocationSize=1)
	private Long codigo;

	@Column
	private String nome;
	
	@Column
	private String area;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}
