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
@Table (name="OrdemServico")
public class OrdemServico {
  
  @Column(name = "numero")
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer numero;

  @Column(name = "valor", nullable = false)
  private double valor;

  @Column(name = "hora_entrada", length = 30, nullable = false)
  private String hora_entrada;

  @Column(name = "hora_retirada", length = 30, nullable = false)
  private String hora_retirada;

  @ManyToOne
  @JoinColumn(name="idCliente")
	private Cliente cliente;

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String getHora_entrada() {
    return hora_entrada;
  }

  public void setHora_entrada(String hora_entrada) {
    this.hora_entrada = hora_entrada;
  }

  public String getHora_retirada() {
    return hora_retirada;
  }

  public void setHora_retirada(String hora_retirada) {
    this.hora_retirada = hora_retirada;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  
}
