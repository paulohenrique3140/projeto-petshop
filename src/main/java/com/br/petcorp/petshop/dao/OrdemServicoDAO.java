package com.br.petcorp.petshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.br.petcorp.petshop.models.OrdemServico;

public interface OrdemServicoDAO extends CrudRepository<OrdemServico, Integer> {
  
}
