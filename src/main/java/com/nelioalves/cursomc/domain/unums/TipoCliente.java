package com.nelioalves.cursomc.domain.unums;

public enum TipoCliente {

	PESSOASFISICA(1,"Pessoa Física"),
	PESSOASJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	//Todo construtor do tipo Enum deve ser criado como private	
	}
	
	//Criação apenas de Get
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	//REcebe um codigo e retorna um objeto do tipo cliente já instaciado
	// conforme esse codigo
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod ==null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido"+ cod);
		
		
	}
}



