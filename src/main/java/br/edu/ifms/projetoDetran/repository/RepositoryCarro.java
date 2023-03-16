package br.edu.ifms.projetoDetran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetoDetran.model.Carro;
@Repository
public interface RepositoryCarro extends JpaRepository<Carro, Long>{
	public List<Carro> findByPlacaContainfindByPlacaContaing();
}
