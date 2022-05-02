package com.meublog.meublog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meublog.meublog.model.UsuarioModel;

public interface UserRepository extends JpaRepository<UsuarioModel, Long>{

	public  Optional<UsuarioModel> findByUsuario(String usuario);
}
