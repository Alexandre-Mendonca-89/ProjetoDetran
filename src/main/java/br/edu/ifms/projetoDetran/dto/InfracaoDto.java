package br.edu.ifms.projetoDetran.dto;

import br.edu.ifms.projetoDetran.model.Infracao;

public class InfracaoDto {
	private Long id;
	private String descricao;
	private int pontos;
	private double valor;
	
	public InfracaoDto() {
		// TODO Auto-generated constructor stub
	}

	//Instanciando um objeto da classe Infracao dentro do atributo infracao
	public InfracaoDto(Infracao infracao) {
		super();
		this.id = infracao.getId();
		this.descricao = infracao.getDescricao();
		this.pontos = infracao.getPontos();
		this.valor = infracao.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
