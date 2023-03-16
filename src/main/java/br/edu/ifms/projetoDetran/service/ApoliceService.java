package br.edu.ifms.projetoDetran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifms.projetoDetran.dto.ApoliceDto;
import br.edu.ifms.projetoDetran.dto.CarroDto;
import br.edu.ifms.projetoDetran.model.Apolice;
import br.edu.ifms.projetoDetran.model.Carro;
import br.edu.ifms.projetoDetran.repository.RepositoryApolice;
import br.edu.ifms.projetoDetran.repository.RepositoryCarro;

public class ApoliceService {
	@Autowired
	private RepositoryApolice repositoryApolice;
	
	public List<Apolice> buscarTodos(){
		return repositoryApolice.findAll()
;	}
	
	public Apolice buscaPorId(Long id) {
		Optional<Apolice> apolice = repositoryApolice.findById(id);
		return apolice.orElseThrow();
	}
	
	public Apolice inserir(Apolice apolice) {
		apolice.setId(null);
		return repositoryApolice.save(apolice);
	}
	
	public void remover(Long id) {
		buscaPorId(id);
		repositoryApolice.deleteById(id);
	}
	
	public Apolice atualizar(Apolice apolice) {
		Apolice apoliceNovo = buscaPorId(apolice.getId());
		apoliceNovo.setValor(apolice.getValor());
		apoliceNovo.setCobertura(apolice.getCobertura());
		apoliceNovo.setVigencia(apolice.getVigencia());
		return repositoryApolice.save(apoliceNovo);
	}
	
	public Apolice fromDto(ApoliceDto apoliceDto) {
		return new Apolice(apoliceDto.getId(), apoliceDto.getValor(), apoliceDto.getCobertura(), apoliceDto.getVigencia(), null);
	}
	
	/*public List<Carro> buscaPorPlaca(String str) {
		return repositoryCarro.findByPlacaContaing(str);
	}*/
}
