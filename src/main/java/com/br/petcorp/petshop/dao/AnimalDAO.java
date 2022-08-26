package com.br.petcorp.petshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.br.petcorp.petshop.models.Animal;

public interface AnimalDAO extends CrudRepository<Animal, Integer>{
  
}
