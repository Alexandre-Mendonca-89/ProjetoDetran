package br.edu.ifms.projetodetran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetodetran.dto.CarroDto;
import br.edu.ifms.projetodetran.model.Carro;
import br.edu.ifms.projetodetran.repository.RepositoryCarro;
import br.edu.ifms.projetodetran.service.exception.ObjectNotFoundException;

@Service
public class CarroService {
	@Autowired
	private RepositoryCarro repositoryCarro;
	
		
	public List<Carro> buscarTodos(){
		return repositoryCarro.findAll();
	}	
	
	public Carro buscarPorId(Integer id) {
		Optional<Carro> carro = repositoryCarro.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Carro.class.getName()));		
	}
	public Carro inserir(Carro carro) {
		carro.setId(null);
		return repositoryCarro.save(carro);
	}
	
	public void remover(Integer id) {
		buscarPorId(id);
		repositoryCarro.deleteById(id);		
	}
	
	public Carro atualizar(Carro carro) {
		Carro carroNovo = buscarPorId(carro.getId());		
		carroNovo.setNome(carro.getNome());
		carroNovo.setPlaca(carro.getPlaca());
		carroNovo.setMarca(carro.getMarca());
		carroNovo.setModelo(carro.getModelo());
		carroNovo.setCor(carro.getCor());
		return repositoryCarro.save(carroNovo);
	}
	
	public Carro fromDto(CarroDto carroDto) {
		return new Carro(carroDto.getId(),carroDto.getNome(),carroDto.getPlaca(),carroDto.getMarca(),carroDto.getModelo(),carroDto.getCor(),null);
	}
}
