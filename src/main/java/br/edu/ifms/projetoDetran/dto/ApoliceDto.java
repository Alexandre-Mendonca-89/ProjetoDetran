package br.edu.ifms.projetodetran.dto;

import java.io.Serializable;

import br.edu.ifms.projetodetran.model.Apolice;

public class ApoliceDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private float valor;
	private String cobertura;
	private String vigencia;
	
	public ApoliceDto() {
		// TODO Auto-generated constructor stub
	}

	public ApoliceDto(Apolice apolice) {
		super();
		this.id = apolice.getId();
		this.valor = apolice.getValor();
		this.cobertura = apolice.getCobertura();
		this.vigencia = apolice.getVigencia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}	
	
}
