package edu.ifpb.webII.model;

import java.util.Objects; 

import jakarta.persistence.*;

@Entity
@Table(name="Responsavel")
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="responsavel_seq")
	@SequenceGenerator(name="responsavel_seq", sequenceName="responsavel_seq",allocationSize=1)
	private Long id_resp;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;

	public Long getId_resp() {
		return id_resp;
	}
	public void setId_resp(Long id_resp) {
		this.id_resp = id_resp;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_resp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		return Objects.equals(id_resp, other.id_resp);
	}
	
	
}
