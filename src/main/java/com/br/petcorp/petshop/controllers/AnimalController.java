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

import com.br.petcorp.petshop.dao.AnimalDAO;
import com.br.petcorp.petshop.models.Animal;

@RestController
public class AnimalController {

  @Autowired
  AnimalDAO dao;

  @PostMapping("/animais")
  public Animal incluirNovo(@RequestBody Animal novo){
    if(novo.getNome() != null){
      return dao.save(novo);
    }
    return null;
  }

  @GetMapping("/animais")
  public ArrayList<Animal> listarTodos(){
    return (ArrayList<Animal>)dao.findAll();
  }
  
  @PutMapping("/animais")
  public ResponseEntity<Animal> atualizarCadastro(@RequestBody Animal dados) {
    if (dados.getIdAnimal() != null && dados.getNome() != null){
      dao.save(dados);
      return ResponseEntity.ok(dados);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/animais/{id}")
  public void excluirCadastro(@PathVariable Integer id){
    dao.deleteById(id);
  }

  @GetMapping("/animais/{id}")
  public Animal buscarPeloId(@PathVariable Integer id){
    return dao.findById(id).orElse(null);
  }
}
