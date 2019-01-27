package com.rdanillo.projeto.springboot.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotNull
	@Length(min = 2, max = 60, message = "O tamanho do nome deve so tamnaho de {max} caracteres")
	private String nomeUsuario;

	@NotNull
	@Length(min = 12, max = 12, message = "O tamanho do login deve so tamnaho de {max} caracteres")
	private String login;

	@NotNull
	@Length(max = 60, message = "O tamanho do email não pode ser maior que  {max} caracteres")
	@Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email Inválido")
	private String email;

	@NotNull
	@Length(min = 8, max = 45, message = "O tamanho da senha deve so tamnaho de {max} caracteres")
	private String senha;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar dataCriacao;
	
	@NotNull
	private int tempoExpiracaoSenha;
	
	@NotNull
	private String codAutorizacao;
	
	@NotNull
	private String statusUsuario;
	
	@NotNull
	private int codPessoa;

	//@OneToMany(mappedBy = "aparelhos", fetch = FetchType.EAGER)
	@ManyToMany
	@Cascade(CascadeType.MERGE)
	private List<Aparelho> listaAparelhos;

	//@OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER)
	@ManyToMany
	@Cascade(CascadeType.MERGE)
	private List<Perfil> listaPerfil;

	public Usuario(int idUsuario, String nomeUsuario, String login, String email, String senha, Calendar dataCriacao, int tempoExpiracaoSenha, String codAutorizacao, String statusUsuario, int codPessoa, List<Aparelho> listaAparelhos, List<Perfil> listaPerfil) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
		this.tempoExpiracaoSenha = tempoExpiracaoSenha;
		this.codAutorizacao = codAutorizacao;
		this.statusUsuario = statusUsuario;
		this.codPessoa = codPessoa;
		this.listaAparelhos = listaAparelhos;
		this.listaPerfil = listaPerfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getTempoExpiracaoSenha() {
		return tempoExpiracaoSenha;
	}

	public void setTempoExpiracaoSenha(int tempoExpiracaoSenha) {
		this.tempoExpiracaoSenha = tempoExpiracaoSenha;
	}

	public String getCodAutorizacao() {
		return codAutorizacao;
	}

	public void setCodAutorizacao(String codAuTorizacao) {
		this.codAutorizacao = codAuTorizacao;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public List<Aparelho> getListaAparelhos() {
		return listaAparelhos;
	}

	public void setListaAparelhos(List<Aparelho> listaAparelhos) {
		this.listaAparelhos = listaAparelhos;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

}
