package br.com.bluebank.squad3.models;

import java.util.Objects;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente", uniqueConstraints = { @UniqueConstraint(columnNames = "cpf") })
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;

	@NotNull(message = "nome não pode ser nulo e nem vazio")
	@Size(max = 120)
	@Column(name = "nome")
	private String nome;

	@NotNull(message = "cpf não pode ser nulo e nem vazio")
	@CPF
	@Column(name = "cpf", unique = true, nullable = false, length = 11)
	private String cpf;

	@NotNull(message = "telefone não pode ser nulo")
	@Column(name = "telefone")
	private Long telefone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_endereco")
  private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcontafk")
	private Conta conta;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_cliente);
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
		return Objects.equals(id_cliente, other.id_cliente);
	}

}

