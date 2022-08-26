package com.br.petcorp.petshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.br.petcorp.petshop.models.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{
  
}
