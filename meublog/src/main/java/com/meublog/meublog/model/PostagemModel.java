package com.meublog.meublog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Indica que essa classe será uma entidade(tabela e mais algumas coisas) do meu jpa hibernate que linkara o banco de dados
@Table(name = "postagem") // A entidade criará uma tabela chamada "postagem"
public class PostagemModel {
	
	@Id //Chave Primária
	@GeneratedValue(strategy= GenerationType.IDENTITY) //Gerará uma identidade sem duplicidade no ID, famoso auto created
	private long id;
	
	@NotNull
	@Size(min=5,max=100)
	private String titulo;
	
	@NotNull
	@Size(min=5,max=100)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) //Informando que o tipo de dado é um tipo date.
	private Date date = new java.sql.Date(System.currentTimeMillis());//Captura a data exata do dado na classe
	
	//Relação
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public TemaModel getTema() {
		return tema;
	}
	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
	
	

}
