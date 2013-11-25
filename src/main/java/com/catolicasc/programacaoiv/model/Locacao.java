package com.catolicasc.programacaoiv.model;

public class Locacao {

	private Long id;
	private Long idCarro;
	private Long idPrecoLocacao;
	private Double preco;
	private Integer tpkm;
	private Carro carro;
	private PrecoLocacao precoLocacao;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getTpkm() {
		return tpkm;
	}

	public void setTpkm(Integer tpkm) {
		this.tpkm = tpkm;
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
}
