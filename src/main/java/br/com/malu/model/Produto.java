package br.com.malu.model;

import java.math.BigDecimal;

import br.com.malu.enums.Tamanho;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Produto {

		@Id
		@Column(name = "id_produto")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "cod_produto")					
		private Integer cod_produto;
		
		@Column(name = "nome")
		@Size(min = 1, max = 20, message="O nome do produto deve ter no máximo 20 caracteres.")
		@NotBlank(message="Castrado não aceita produto sem nome")
		@NotNull
		private String nome;
		
		@Column(name = "descricao")
		@Size(min = 0,max= 50, message="")
		private String descricao;
		
		@Column(name = "qtd")		
		private Integer qtd;
		
		@Column(name = "tamanho")
		@Enumerated(EnumType.STRING)
		@NotNull
		private Tamanho tam;
		
		@Column(name = "compra", precision= 10, scale=2)
		@Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos e 2 decimais.")		
		@NotNull
		private BigDecimal compra;
		
		@Column(name = "venda", precision=10, scale=2)
		@Digits(integer=8, fraction=2, message="O preço deve ter no máximo 8 dígitos e 2 decimais.")
		private BigDecimal venda ;
		
		@Column(name = "fornecedor")
		@Size(min = 1, max=50, message="O fornecedor deve conter de 1 a 50 algarismos.")
		@NotBlank(message="Caso não queira identificar fornecedor, coloque 'não identificado")
		@NotNull
		private String fornecedor;
		
		@Column(name = "max_desc")	
		private Integer max_desc;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Integer getCod_produto() {
			return cod_produto;
		}

		public void setCod_produto(Integer cod_produto) {
			this.cod_produto = cod_produto;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Integer getQtd() {
			return qtd;
		}

		public void setQtd(Integer qtd) {
			this.qtd = qtd;
		}

		public Tamanho getTam() {
			return tam;
		}

		public void setTam(Tamanho tam) {
			this.tam = tam;
		}

		public BigDecimal getCompra() {
			return compra;
		}

		public void setCompra(BigDecimal compra) {
			this.compra = compra;
		}

		public BigDecimal getVenda() {
			return venda;
		}

		public void setVenda(BigDecimal venda) {
			this.venda = venda;
		}

		public String getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(String fornecedor) {
			this.fornecedor = fornecedor;
		}

		public Integer getMax_desc() {
			return max_desc;
		}

		public void setMax_desc(Integer max_desc) {
			this.max_desc = max_desc;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}
