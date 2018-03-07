package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Usuario;
import br.ufc.npi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repo;
	
	public Usuario salvarUser(Usuario usuario){
		repo.save(usuario);
		return usuario;
	}
	
	public String removerUser(int id){
		Usuario user = repo.findById(id);
		repo.delete(user);
		return "Usuario removido!";
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repo.findAll();
	}
	
	public Usuario getUsuario(int id){
		return repo.findById(id);
	}
}
