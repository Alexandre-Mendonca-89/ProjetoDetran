package br.edu.ifms.projetoDetran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetoDetran.model.Apolice;
import br.edu.ifms.projetoDetran.model.Carro;
import br.edu.ifms.projetoDetran.repository.RepositoryApolice;
import br.edu.ifms.projetoDetran.repository.RepositoryCarro;

@Service
public class DBService {
	
	@Autowired
	RepositoryCarro repositoryCarro;
	
	@Autowired
	RepositoryApolice repositoryApolice;
	
	public void instantiateTestDatabase() throws ParseException {
		Carro c1 = new Carro(null, "onix", "Chevrolet", 2014, "hsj7511", "Cinza", null);		
		Carro c2 = new Carro(null, "Ka", "Ford", 2018, "ABC0123", "Pretos", null);		
		Carro c3 = new Carro(null, "Gol", "Volksvagem", 2007, "HSY6439", "Cinza", null);
		
		Apolice apo1 = new Apolice(null, 3000, "Total", "12/2025", c3);
		
		repositoryCarro.saveAll(Arrays.asList(c1, c2, c3));
		repositoryApolice.saveAll(Arrays.asList(apo1));
		
	}
}
