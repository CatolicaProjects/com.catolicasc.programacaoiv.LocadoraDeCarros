package com.catolicasc.programacaoiv.model;

import java.util.Date;

public class User {
	
public static final int TP_USER_BASIC = 1;
    
    public static final int MASC = 1;
    public static final int FEM = 2;
    
    private Long id;
    private String email;
    private String user;
    private String name;
    private String password;
    private Integer tpuser; 
    private Date dtcreate; 
    private Date dtedit;
    private String phone;
    private Integer status;
    private Integer gender;
    private Date dtbirth;
    private Double latitude;
    private Double longitude;
}
