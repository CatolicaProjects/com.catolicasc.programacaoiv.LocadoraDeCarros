package com.catolicasc.programacaoiv.model;

public class PrecoLocacao {
	public static final Integer TP_KM_LIVRE = 1;
	public static final Integer TP_KM_PERCORRIDO = 2;

	private Long id;

	private Double preco;
	private Integer tpkm;

	private Categoria categoria;
	private Long idCategoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTipoKilometragem() {
		if (this.tpkm == 1) {
			return "KM LIVRE";
		} else {
			return "KM PERCORRIDO";
		}
	}

	@Override
	public String toString() {
		return "[ R$" + this.getPreco() + " ] " + " [ " + this.getTipoKilometragem() + " ] " + " [ " + this.getCategoria().getNome() + " ]";
	}
}
