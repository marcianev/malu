package br.com.malu.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.malu.enums.Tamanho;
import br.com.malu.exception.ServiceExc;
import br.com.malu.model.Produto;
import br.com.malu.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository prodRep;
	
	public Produto salvar(Produto produto) throws ServiceExc{
		
		if(produto == null) {
			throw new ServiceExc("O produto não pode ser nulo!");
		}
		if(produto.getNome().trim().isEmpty()) {
			throw new ServiceExc("O nome do produto é obrigatório!");
		}
		return prodRep.save(produto);
	}
	
	public Produto buscarPorId(Long id) throws ServiceExc{
		
		Optional<Produto> produto = prodRep.findById(id);
		if(produto.isEmpty()) {
			throw new ServiceExc("Produto não encontrado para o ID: "+id);
		}
		return produto.get();
	}
	
	public List<Produto>listarTodos() throws ServiceExc{
		return prodRep.findAll();
		
	}
	
	 public List<Produto> filtrarInt(Integer coluna, Integer valor) throws ServiceExc{
		 List<Produto> filtrarInt = new ArrayList<>();
		 switch (coluna) {
		 case 1:
			 filtrarInt = prodRep.filtrarCod(valor);
			 break;
		 case 3:
			 filtrarInt = prodRep.filtrarQtd(valor);
			 break;
		 case 8:
			 filtrarInt = prodRep.filtrarDesconto(valor);
			 break;
			 default:
				 filtrarInt = new ArrayList<>();
				 break;
		 }
		 
		 return filtrarInt;
	    }
	 
	 public List<Produto> filtrarString(Integer coluna, String valor) throws ServiceExc{
		 List<Produto> filtrarString = new ArrayList<>();
		 switch (coluna) {
		 case 2:
			 filtrarString = prodRep.filtrarNome(valor);
			 break;
		 case 4:
			 Tamanho tam = Tamanho.fromLabel(valor);			
			 filtrarString = prodRep.filtrarTam(tam);
			 break;
		 case 7:
			 filtrarString = prodRep.filtrarFornecedor(valor);
			 break;
			 default:
				 filtrarString = new ArrayList<>();
			 break;
		 }
		 
		 return filtrarString;
	    }
	 
	 
	 public List<Produto> filtrarDecimal(Integer coluna, BigDecimal valor) throws ServiceExc{
		 List<Produto> filtrarDecimal = new ArrayList<>();
		 switch (coluna) {
		 case 5:
			 filtrarDecimal = prodRep.filtrarCompra(valor);
			 break;
		 case 6:
			 filtrarDecimal = prodRep.filtrarVenda(valor);
			 break;
			 default:
				 filtrarDecimal = new ArrayList<>();
				 break;
		}
		 return filtrarDecimal;
	 }
	
	public void deletar(Long id) throws ServiceExc{
		if(!prodRep.existsById(id)) {
			throw new ServiceExc("Não é possível deletar, Produto não encontrado para o ID: "+id);
		}
		prodRep.deleteById(id);
	}
}
