package com.br.petcorp.petshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
  
  @Column(name = "idAnimal")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAnimal;

  @Column(name = "nome", length = 45, nullable = false)
  private String nome;

  @Column(name = "idade", nullable = false)
  private Integer idade;

  @Column(name = "peso", nullable = false)
  private double peso;

  @ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

  public Integer getIdAnimal() {
    return idAnimal;
  }

  public void setIdAnimal(Integer idAnimal) {
    this.idAnimal = idAnimal;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  
}
