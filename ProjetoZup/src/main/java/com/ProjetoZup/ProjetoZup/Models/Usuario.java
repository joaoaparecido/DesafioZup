package com.ProjetoZup.ProjetoZup.Models;


import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="O nome é obrigatório.")
    private String nome;

    @Column(unique = true)
    @NotEmpty(message="O email é obrigatório.")
    @Email(message = "O formato de email está inválido.")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "O CPF é obrigatório.")
    @Size(min=11, max=11, message="O CPF deve possuir 11 numeros.")
    @CPF
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "Data futura, portanto inválida.")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dataNascimento;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "usuario", orphanRemoval = true)
	private List<Veiculo> enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
