package br.edu.ifms.projetoDetran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetoDetran.model.Infracao;
@Repository
public interface RepositoryInfracao extends JpaRepository<Infracao, Long>{
	
}
