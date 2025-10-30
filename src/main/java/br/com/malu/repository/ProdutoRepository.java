package br.com.malu.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.malu.enums.Tamanho;
import br.com.malu.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	//filtrar Código
	  @Query("SELECT p FROM Produto p WHERE p.cod_produto = :valor")
	    List<Produto> filtrarCod(Integer valor);
	  
	//filtrar nome
	  @Query("SELECT p FROM Produto p WHERE p.nome = :valor")
	    List<Produto> filtrarNome(String valor);
	  
	//filtrar quantidade
	  @Query("SELECT p FROM Produto p WHERE p.qtd = :valor")
	    List<Produto> filtrarQtd(Integer valor);
	  
	//filtrar Tamanho
	  @Query("SELECT p FROM Produto p WHERE p.tam = :valor")
	    List<Produto> filtrarTam(Tamanho valor);
	  
	//filtrar Valor de compra
	  @Query("SELECT p FROM Produto p WHERE p.compra = :valor")
	    List<Produto> filtrarCompra(BigDecimal valor);
	  
	//filtrar Venda
	  @Query("SELECT p FROM Produto p WHERE p.venda = :valor")
	    List<Produto> filtrarVenda(BigDecimal valor);
	  
	//filtrar fornecedor
	  @Query("SELECT p FROM Produto p WHERE p.fornecedor = :valor")
	    List<Produto> filtrarFornecedor(String valor);
	  
	//filtrar Desconto
	  @Query("SELECT p FROM Produto p WHERE p.max_desc = :valor")
	    List<Produto> filtrarDesconto(Integer valor);

}

