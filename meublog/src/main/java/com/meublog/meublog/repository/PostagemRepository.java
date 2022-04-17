package com.meublog.meublog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meublog.meublog.model.PostagemModel;

@Repository //Semelhante ao DAO Data Access Object
public interface PostagemRepository extends JpaRepository<PostagemModel,Long> { //Entidade,Tipo de dado ID
	
	
	public List<PostagemModel>findAllByTituloContainingIgnoreCase(String titulo);
	
}
