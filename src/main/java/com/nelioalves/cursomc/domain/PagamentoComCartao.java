package com.nelioalves.cursomc.domain;

import javax.persistence.Entity;

import com.nelioalves.cursomc.domain.unums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numumeroDeParcelas;
	
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numumeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumumeroDeParcelas() {
		return numumeroDeParcelas;
	}

	public void setNumumeroDeParcelas(Integer numumeroDeParcelas) {
		this.numumeroDeParcelas = numumeroDeParcelas;
	}
	
	
	
	

}
