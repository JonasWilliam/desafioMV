package br.com.mv.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.xpto.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
