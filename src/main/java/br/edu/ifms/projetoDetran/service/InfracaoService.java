package br.edu.ifms.projetoDetran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifms.projetoDetran.dto.CarroDto;
import br.edu.ifms.projetoDetran.dto.InfracaoDto;
import br.edu.ifms.projetoDetran.model.Carro;
import br.edu.ifms.projetoDetran.model.Infracao;
import br.edu.ifms.projetoDetran.repository.RepositoryCarro;
import br.edu.ifms.projetoDetran.repository.RepositoryInfracao;

public class InfracaoService {

	@Autowired
	private RepositoryInfracao repositoryInfracao;
	
	public List<Infracao> buscarTodos(){
		return repositoryInfracao.findAll()
;	}
	
	public Infracao buscaPorId(Long id) {
		Optional<Infracao> infracao = repositoryInfracao.findById(id);
		return infracao.orElseThrow();
	}
	
	public Infracao inserir(Infracao infracao) {
		infracao.setId(null);
		return repositoryInfracao.save(infracao);
	}
	
	public void remover(Long id) {
		buscaPorId(id);
		repositoryInfracao.deleteById(id);
	}
	
	public Infracao atualizar(Infracao infracao) {
		Infracao infracaoNovo = buscaPorId(infracao.getId());
		infracaoNovo.setDescricao(infracao.getDescricao());
		infracaoNovo.setPontos(infracao.getPontos());
		infracaoNovo.setValor(infracao.getValor());
		return repositoryInfracao.save(infracaoNovo);
	}
	
	public Infracao fromDto(InfracaoDto infracaoDto) {
		return new Infracao(infracaoDto.getId(), infracaoDto.getDescricao(), infracaoDto.getPontos(), infracaoDto.getValor());
	}
	
	/*public List<Carro> buscaPorPlaca(String str) {
		return repositoryCarro.findByPlacaContaing(str);
	}*/
}
