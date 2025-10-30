package br.com.malu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.malu.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	// query busca usuario por código
	@Query("select e from Usuario e where e.codigoUser= :codigo_user")
	public Usuario findByCodigo(Integer codigo_user);
	
	//query compara codigo e senha de usuario
	@Query("select l from Usuario l where l.codigoUser= :codigo_user and l.senha= :senha")
	public Usuario buscarLogin(Integer codigo_user, String senha);
	
}
