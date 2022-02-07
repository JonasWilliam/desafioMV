package br.com.mv.xpto.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer idCliente;
		
		@Column(name="nome")
		private String nome;
		
		@Column(name="contato")
		private String contato;
		
		@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	    @Column(insertable = false, updatable = false)
		private List<Endereco> enderecos;
		
		public Cliente() {
			super();
		}

		public Cliente(String nome, String contato) {
			super();
			this.nome = nome;
			this.contato = contato;
		}

		@Override
		public int hashCode() {
			return Objects.hash(idCliente);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			return Objects.equals(idCliente, other.idCliente);
		}

		public Integer getId() {
			return idCliente;
		}

		public void setId(Integer id) {
			this.idCliente = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getContato() {
			return contato;
		}

		public void setContato(String contato) {
			this.contato = contato;
		}

		public List<Endereco> getEnderecos() {
			return enderecos;
		}

		public void setEnderecos(List<Endereco> enderecos) {
			this.enderecos = enderecos;
		}
		
}
