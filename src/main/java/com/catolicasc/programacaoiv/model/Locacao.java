package com.catolicasc.programacaoiv.model;

public class Locacao {
	private Long id;

	private Carro carro;
	private Long idCarro;
	
	private PrecoLocacao precoLocacao;
	private Long idPrecoLocacao;
	
	private Cliente cliente;
	private Long idCliente;
	
	private String dataLocacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public Long getIdPrecoLocacao() {
		return idPrecoLocacao;
	}

	public void setIdPrecoLocacao(Long idPrecoLocacao) {
		this.idPrecoLocacao = idPrecoLocacao;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public PrecoLocacao getPrecoLocacao() {
		return precoLocacao;
	}

	public void setPrecoLocacao(PrecoLocacao precoLocacao) {
		this.precoLocacao = precoLocacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDataLocacao() {
		return this.dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
}
