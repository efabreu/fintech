package br.com.efabreu.fintech.dto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.efabreu.fintech.model.ValueRecords;

public class ValueRecordsDTO {

	
	private Long userId;
	
	private String descricao;
	private boolean tipo;
	private String valor;
	private String data;
	

	/**
	  * This constructor takes a <code>Long</code>, <code>String</code>, <code>boolean</code>, <code>String</code>, <code>String</code> and <code>Date</code>
	  * and create a ValueRecordsDTO in the given <code>ValueRecordsDTO<Object></code>
	  * 
	  * @param userId
	  *        Id do usuário
	  * @param descricao
	  *        descricao do registro
	  * @param tipo
	  *        boolean, true para entrada e false para saída de recurso
	  * @param valor
	  *        String, valor para registro    
	  * @param tipo
	  *        Date, data do registro    
	  *        
	  * @return objeto ValueRecordsDTO
	  */
	public ValueRecordsDTO(Long userId, String descricao, boolean tipo, String valor, String data) {
		super();
		this.userId = userId;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
	}
	

	public ValueRecordsDTO() {
		super();
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public ValueRecords toObject() {
		SimpleDateFormat formatoDataBanco = new SimpleDateFormat("yyyy-MM-dd");
		Date diaDate = null;
		try {
			diaDate = formatoDataBanco.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ValueRecords(descricao, tipo, valor, diaDate);
	}
	

	
}
