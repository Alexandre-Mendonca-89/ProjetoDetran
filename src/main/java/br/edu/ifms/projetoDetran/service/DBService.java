package br.edu.ifms.projetodetran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetodetran.model.Apolice;
import br.edu.ifms.projetodetran.model.Carro;
import br.edu.ifms.projetodetran.model.Infracao;
import br.edu.ifms.projetodetran.model.Multa;
import br.edu.ifms.projetodetran.repository.RepositoryApolice;
import br.edu.ifms.projetodetran.repository.RepositoryCarro;
import br.edu.ifms.projetodetran.repository.RepositoryInfracao;
import br.edu.ifms.projetodetran.repository.RepositoryMulta;

@Service
public class DBService {
	
	@Autowired
	RepositoryCarro repositoryCarro;
	
	@Autowired
	RepositoryApolice repositoryApolice;
	
	@Autowired
	RepositoryInfracao repositoryInfracao;
	
	@Autowired
	RepositoryMulta repositoryMulta;
	
	public void instantiateTestDatabase() throws ParseException {
		Carro c1 = new Carro(null, "onix", "Chevrolet", "hsj7511", 2014, "Cinza", null);		
		Carro c2 = new Carro(null, "Ka", "Ford", "ABC0123", 2018, "Pretos", null);		
		Carro c3 = new Carro(null, "Gol", "Volksvagem", "HSY6439", 2007, "Cinza", null);
		
		Apolice apo1 = new Apolice(null, 3000, "Total", "12/2025", c3);
		
		Infracao i1 = new Infracao(null, "Estacionamento proibido", 7, 150.0f);
		Infracao i2 = new Infracao(null, "Sem cinto de segurança", 5, 240.0f);
		Infracao i3 = new Infracao(null, "Acima da velocidade permitida", 10, 320.0f);
		Infracao i4 = new Infracao(null, "Ultrapassagem em faixa continua", 11, 290.0f);
		Infracao i5 = new Infracao(null, "Ultrapassar no sinal vermelho", 6, 140.0f);
		
		Multa m1 = new Multa(null, "Corumbá", 2020, c2, i3);
		Multa m2 = new Multa(null, "Ladario", 2021, c1, i4);
		Multa m3 = new Multa(null, "Campo Grande", 2022, c3, i2);
		Multa m4 = new Multa(null, "Miranda", 2021, c1, i5);
		Multa m5 = new Multa(null, "Aquidauna", 2023, c2, i2);
		repositoryApolice.saveAll(Arrays.asList(apo1));
		
		repositoryCarro.saveAll(Arrays.asList(c1, c2, c3));
		//inserção de multa e infração no banco de dados
		repositoryInfracao.saveAll(Arrays.asList(i1, i2, i3, i4, i5));
		repositoryMulta.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
	}
}