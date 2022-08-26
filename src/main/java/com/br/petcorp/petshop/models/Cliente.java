package com.br.petcorp.petshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="cliente")
public class Cliente {
  
  @Column(name = "idCliente")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCliente;

  @Column(name = "nome", length = 60, nullable = false)
  private String nome;

  @Column(name = "telefone", length = 20, nullable = false)
  private String telefone;

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
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

  
}
