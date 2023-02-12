package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 50)
  private String nome;

  @NotBlank
  @Column(unique = true)
  @Size(min = 11, max = 11)
  private String cpf;

  @NotBlank
  @Size(min = 8, max = 22)
  private String telefone;

  @NotBlank
  @Size(min = 10, max = 100)
  private String endereco;

  @NotBlank
  @Size(min = 10, max = 100)
  private String email;
  
  @NotBlank
  private String senha;
  
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getEmail() {
	    return email;
	  }

  public void setEmail(String email) {
	    this.email = email;
  }

  public String getSenha() {
	    return senha;
	  }

  public void setSenha(String senha) {
	    this.senha = senha;
  }
}