package com.catolicasc.programacaoiv.model;

public class PrecoLocacao {
	public static final Integer TP_KM_LIVRE = 1;
    public static final Integer TP_KM_PERCORRIDO = 2;
    
    private Long id;
    private Long idcategoria;
    private Double preco;
    private Integer tpkm;
    private Categoria categoria;
}
