package br.edu.ifms.projetodetran.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.projetodetran.dto.CarroDto;
import br.edu.ifms.projetodetran.model.Carro;
import br.edu.ifms.projetodetran.service.CarroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/carro")
public class CarroResource {

	@Autowired
	CarroService carro;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carro> find(@PathVariable Integer id) {		
		Carro obj = carro.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CarroDto objDto) {
		Carro obj = carro.fromDto(objDto);
		obj = carro.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CarroDto objDto, @PathVariable Integer id) {
		Carro obj = carro.fromDto(objDto);
		obj.setId(id);
		obj = carro.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Carro obj,@PathVariable Integer id){
		carro.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CarroDto>> findAll() {		
		List<Carro> list = carro.buscarTodos();
		List<CarroDto> listDto = list.stream().map(obj -> new CarroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
