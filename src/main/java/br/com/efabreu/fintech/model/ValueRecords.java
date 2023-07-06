package br.com.efabreu.fintech.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValueRecords implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VALUE_ID")
	@JsonIgnore
    private Long valueId;
	
	private Long userId;
	
	private String descricao;
	private boolean tipo;
	private String valor;
	private Date data;
	
	@Override
	public int hashCode() {
		return Objects.hash(valueId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueRecords other = (ValueRecords) obj;
		return Objects.equals(valueId, other.valueId);
	}
	public ValueRecords(Long userId, String descricao, boolean tipo, String valor, Date data) {
		super();
		this.userId = userId;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
	}
	

	public ValueRecords() {
		super();

	}
	public ValueRecords(String descricao, boolean tipo, String valor, Date data) {
		super();
		this.userId = 1L;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
	}
	public Long getValueId() {
		return valueId;
	}
	public void setValueId(Long valueId) {
		this.valueId = valueId;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	

	
}
