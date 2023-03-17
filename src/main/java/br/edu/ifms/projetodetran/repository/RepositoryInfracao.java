package br.edu.ifms.projetodetran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetodetran.model.Infracao;
@Repository
public interface RepositoryInfracao extends JpaRepository<Infracao, Long>{

}
