package com.meublog.meublog.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meublog.meublog.model.UsuarioLogin;
import com.meublog.meublog.model.UsuarioModel;
import com.meublog.meublog.repository.UserRepository;

@Service
public class UsuarioService {

	@Autowired
	private UserRepository repository;
	
	
	public UsuarioModel CadastrarUser(UsuarioModel user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(user.getSenha());
		user.setSenha(senhaEncoder);
		return repository.save(user);
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuarioModel  = repository.findByUsuario(user.get().getUsuario());
		
		if(usuarioModel.isPresent()) {
			if(encoder.matches(user.get().getSenha(),usuarioModel.get().getSenha())) {
				String auth = user.get().getUsuario()+":"+user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic"+new String(encodeAuth);
				user.get().setToken(authHeader);
				user.get().setNome(usuarioModel.get().getNome());
				return user;
			}
		}
		return null;
	}
}
