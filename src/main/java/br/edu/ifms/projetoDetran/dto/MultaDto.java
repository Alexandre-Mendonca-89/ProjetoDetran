package br.edu.ifms.projetoDetran.dto;

import br.edu.ifms.projetoDetran.model.Multa;

public class MultaDto {
	private Long id;
	private String cidade;
	private int ano;
	
	public MultaDto() {
		// TODO Auto-generated constructor stub
	}

	//Instanciando um objeto da classe Multa dentro do atributo multa
	public MultaDto(Multa multa) {
		super();
		this.id = multa.getId();
		this.cidade = multa.getCidade();
		this.ano = multa.getAno();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
}
