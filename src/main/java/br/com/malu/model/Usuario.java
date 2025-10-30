package br.com.malu.model;

import br.com.malu.enums.Acesso;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Usuario {

		@Id
		@Column(name = "id_user")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "codigo_user")	    		
		private Integer codigoUser;
		
		@Column(name = "senha")
		@Size(min=8, max=32, message="A senha deve ter pelo menos 8 caracteres.")
		@NotBlank(message="Digite a senha")
		@NotNull
		private String senha;
		
		@Column(name = "acesso")
		@Enumerated(EnumType.STRING)
		@NotNull
		private Acesso acesso;
		
		@Column(name = "nome")
		@Size(min = 1, max = 100, message="O nome deve ter de 1 a 100 caracteres.")
		@NotBlank(message = "Digite o nome do funcionário.")
		@NotNull
		private String nome;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Integer getCodigoUser() {
			return codigoUser;
		}

		public void setCodigoUser(Integer codigo_user) {
			this.codigoUser = codigo_user;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Acesso getAcesso() {
			return acesso;
		}

		public void setAcesso(Acesso acesso) {
			this.acesso = acesso;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
		
		
}
