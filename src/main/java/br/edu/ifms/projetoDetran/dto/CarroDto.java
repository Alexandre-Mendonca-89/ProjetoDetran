package br.edu.ifms.projetodetran.dto;

import java.io.Serializable;

import br.edu.ifms.projetodetran.model.Carro;

public class CarroDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String placa;
	private String marca;
	private int modelo;
	private String cor;
	
	public CarroDto() {
		// TODO Auto-generated constructor stub
	}

	public CarroDto(Carro carro) {
		super();
		this.id = carro.getId();
		this.nome = carro.getNome();
		this.placa = carro.getPlaca();
		this.marca = carro.getMarca();
		this.modelo = carro.getModelo();
		this.cor = carro.getCor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}	
	
}
