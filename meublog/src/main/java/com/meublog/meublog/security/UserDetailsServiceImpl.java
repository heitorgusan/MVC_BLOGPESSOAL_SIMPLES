package com.meublog.meublog.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.meublog.meublog.model.UsuarioModel;
import com.meublog.meublog.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UsuarioModel> user = userRepository.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username+" not found"));
		return user.map(UserDetailsImpl::new).get();
	}
		
}
