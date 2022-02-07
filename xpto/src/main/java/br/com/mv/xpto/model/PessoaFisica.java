package br.com.mv.xpto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica extends Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="cpf")
	private String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String contato, String cpf) {
		super(nome, contato);
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
