package br.com.malu.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.malu.exception.CodigoExistsException;
import br.com.malu.exception.CriptoExistsException;
import br.com.malu.exception.ServiceExc;
import br.com.malu.model.Usuario;
import br.com.malu.repository.UsuarioRepository;
import br.com.malu.util.Util;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRep;
	
	public void SalvarUsuario(Usuario user) throws Exception{
		try {
			if(userRep.findByCodigo(user.getCodigoUser()) !=null) {
				throw new CodigoExistsException("Este código de usuário já está sendo utilizado:" + user.getCodigoUser());
				
			}
			user.setSenha(Util.md5(user.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Erro na criptografia");
		}
		userRep.save(user);
	}
	
	public Usuario loginUser(Integer user, String senha) throws ServiceExc{
		
		return userRep.buscarLogin(user, senha);
	}
}
