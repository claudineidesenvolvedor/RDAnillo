package com.rdanillo.projeto.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name="aparelho")
public class Aparelho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAparelho;
	
	@NotNull
	@Length(min = 2, max = 15, message = "O tamanho da descrição do aparelho, deve so tamnaho de {max} caracteres")
	private String descricaoAparelho;
	
	@NotNull
	@Length(min = 8, max = 100, message = "O tamanho do código do aparelho deve so tamnaho de {max} caracteres")
	private String codigoAparelho;

	public Aparelho() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAparelho() {
		return idAparelho;
	}

	public void setIdAparelho(int idAparelho) {
		this.idAparelho = idAparelho;
	}

	public String getDescricaoAparelho() {
		return descricaoAparelho;
	}

	public void setDescricaoAparelho(String descricaoAparelho) {
		this.descricaoAparelho = descricaoAparelho;
	}

	public String getCodigoAparelho() {
		return codigoAparelho;
	}

	public void setCodigoAparelho(String codigoAparelho) {
		this.codigoAparelho = codigoAparelho;
	}

}
