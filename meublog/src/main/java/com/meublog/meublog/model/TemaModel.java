package com.meublog.meublog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE) 
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagem;
	//MappedBy indica a variavel dentro do postagem
	//Cascade significa que todas as postagem relacionadas ao tema serão removidas se eu excluir o tema.
	//É preciso por isso pois o banco de dados naturalmente não deixa eu remover o tema se ele tiver associado
	// com alguma coisa outra coisa, no nosso caso as postagens, oq o mysql faz se chama integridade de dados

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

	

}
