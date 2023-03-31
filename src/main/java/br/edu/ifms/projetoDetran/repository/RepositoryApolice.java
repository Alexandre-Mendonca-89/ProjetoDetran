package br.edu.ifms.projetodetran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetodetran.model.Apolice;
@Repository
public interface RepositoryApolice extends JpaRepository<Apolice, Integer>{

}
