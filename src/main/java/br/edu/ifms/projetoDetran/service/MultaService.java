package br.edu.ifms.projetoDetran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifms.projetoDetran.dto.CarroDto;
import br.edu.ifms.projetoDetran.dto.MultaDto;
import br.edu.ifms.projetoDetran.model.Carro;
import br.edu.ifms.projetoDetran.model.Multa;
import br.edu.ifms.projetoDetran.repository.RepositoryCarro;
import br.edu.ifms.projetoDetran.repository.RepositoryMulta;

public class MultaService {

	@Autowired
	private RepositoryMulta repositoryMulta;
	
	public List<Multa> buscarTodos(){
		return repositoryMulta.findAll()
;	}
	
	public Multa buscaPorId(Long id) {
		Optional<Multa> multa = repositoryMulta.findById(id);
		return multa.orElseThrow();
	}
	
	public Multa inserir(Multa multa) {
		multa.setId(null);
		return repositoryMulta.save(multa);
	}
	
	public void remover(Long id) {
		buscaPorId(id);
		repositoryMulta.deleteById(id);
	}
	
	public Multa atualizar(Multa multa) {
		Multa multaNovo = buscaPorId(multa.getId());
		multaNovo.setCidade(multa.getCidade());
		multaNovo.setAno(multa.getAno());
		return repositoryMulta.save(multaNovo);
	}
	
	public Multa fromDto(MultaDto multaDto) {
		return new Multa(multaDto.getId(), multaDto.getCidade(), multaDto.getAno(), null, null);
	}
	
	/*public List<Carro> buscaPorPlaca(String str) {
		return repositoryCarro.findByPlacaContaing(str);
	}*/
}
