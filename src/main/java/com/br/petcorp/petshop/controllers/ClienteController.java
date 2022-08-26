package com.br.petcorp.petshop.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.petcorp.petshop.dao.ClienteDAO;
import com.br.petcorp.petshop.models.Cliente;

@RestController
public class ClienteController {
  
  @Autowired
  private ClienteDAO dao;

  @PostMapping("/clientes")
  public Cliente incluirNovo(@RequestBody Cliente novo){ //RequestBody: como o proprio nome
    if (novo.getNome() != null) { //validando se o atributo nome da classe Departamento nao esta vazia
      return dao.save(novo); //salva um novo registro em departamento
    }
    return novo;
  }

  @GetMapping("/clientes")
  public ArrayList<Cliente> listarTodos(){
    return (ArrayList<Cliente>)dao.findAll();
  }

  @PutMapping("/clientes")
  public ResponseEntity<Cliente> atualizarCadastro(@RequestBody Cliente dados){
    if (dados.getIdCliente() != null && dados.getNome() != null){
      dao.save(dados);
      return ResponseEntity.ok(dados);
    }  
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/clientes/{id}")
  public void excluirCadastro(@PathVariable Integer id){
      dao.deleteById(id);
  }

  @GetMapping("/clientes/{id}")
  public Cliente buscarPorId(@PathVariable Integer id){
    return dao.findById(id).orElse(null);
  }


  
}
