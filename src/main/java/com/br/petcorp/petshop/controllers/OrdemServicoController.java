package com.br.petcorp.petshop.controllers;

import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.petcorp.petshop.dao.OrdemServicoDAO;
import com.br.petcorp.petshop.models.OrdemServico;

@RestController
public class OrdemServicoController {
  
  @Autowired
  private OrdemServicoDAO dao;

  @PostMapping("/ordens")
  public OrdemServico incluirNovo(@RequestBody OrdemServico novo){
    if (novo.getValor() >= 0){
      return dao.save(novo);
    }
    return null;
  }

  @GetMapping("/ordens")
  public ArrayList<OrdemServico> listarTodos(){
    return (ArrayList<OrdemServico>)dao.findAll();
  }

  @PutMapping("/ordens")
  public ResponseEntity<OrdemServico> atualizarCadastro(@RequestBody OrdemServico dados) {
    if (dados.getNumero() != null && dados.getValor() >= 0){
      dao.save(dados);
      return ResponseEntity.ok(dados);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/ordens/{id}")
  public void excluirOrdem(@PathVariable Integer id){
    dao.deleteById(id);
  }

  @GetMapping("/ordens/{id}")
  public OrdemServico buscarPorId(@PathVariable Integer id){
    return dao.findById(id).orElse(null);
  }


}
