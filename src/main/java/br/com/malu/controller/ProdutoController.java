package br.com.malu.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.malu.enums.Tamanho;
import br.com.malu.exception.ServiceExc;
import br.com.malu.model.Produto;
import br.com.malu.model.Usuario;
import br.com.malu.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService prodServ;
	
	@GetMapping("/estoque")
	public ModelAndView listar(HttpSession session,
								@RequestParam(required = false, defaultValue = "estoque") String tab) throws ServiceExc{
		ModelAndView mav = new ModelAndView();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null) {
			mav.setViewName("redirect:/");
			return mav;
		}
		mav.addObject("usuarioLogado", usuarioLogado);
		mav.addObject("produtos", prodServ.listarTodos());
		mav.addObject("tabAtiva", tab);
		mav.addObject("produto", new Produto());
		mav.addObject("tamanhos", Tamanho.values()); 
		mav.setViewName("navegacao/navegacao");
		return mav;
	}//fecha listar
	
	@PostMapping("/estoque/salvar")
	public ModelAndView salvar(
			@Valid Produto prod,
			BindingResult res,
			HttpSession session) throws ServiceExc{
		System.out.println("cheguei aqui");
		
		ModelAndView mav = new ModelAndView();
		Usuario logado =(Usuario) session.getAttribute("usuarioLogado");
		mav.addObject("produto", new Produto());
		if(logado == null) {
			mav.setViewName("redirect:/");
			return mav;
		}
		
		if(res.hasErrors()) {
			mav.setViewName("navegacao/navegacao");
			mav.addObject("tabAtiva", "estoque");
			mav.addObject("usuarioLogado", logado);
			mav.addObject("produtos", prodServ.listarTodos());
		} else {
			prodServ.salvar(prod);			
			mav.setViewName("redirect:/estoque?tab=estoque");
			
		}
		mav.addObject("tamanhos", Tamanho.values()); 
		return mav;
	}//fecha salvar
	
	@GetMapping("/estoque/deletar")
	public ModelAndView deletar(@RequestParam("id") Long id, HttpSession session) {
	    System.out.println("### Entrou no método deletar() com ID: " + id);

	    ModelAndView mav = new ModelAndView();
	    Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
	    if (logado == null) {
	        mav.setViewName("redirect:/");
	        return mav;
	    }

	    try {
	        prodServ.deletar(id);
	        System.out.println("### Produto " + id + " deletado com sucesso!");
	    } catch (Exception e) {
	        System.out.println("### ERRO ao deletar: " + e.getMessage());
	    }

	    mav.setViewName("redirect:/estoque?tab=estoque");
	    mav.addObject("tamanhos", Tamanho.values()); 
	    return mav;
	}
	
	
	
	@GetMapping("/estoque/editar/{id}")
	public ModelAndView editar(
			@PathVariable("id") Long id,
			HttpSession session) throws ServiceExc{
			
		ModelAndView mav = new ModelAndView();
		Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
		
		if(logado==null) {
			mav.setViewName("redirect:/");
			return mav;
		}//fecha if
		Produto prod = prodServ.buscarPorId(id);
		if(prod == null) {
			mav.setViewName("redirect:/estoque?tab=estoque");
			return mav;
		}//fecha if
		mav.addObject("usuarioLogado", logado);
		mav.addObject("produto", prod);
		mav.addObject("tabAtiva", "estoque");
		mav.addObject("tamanhos", Tamanho.values()); 
		mav.setViewName("navegacao/navegacao");
		System.out.println(id);	
		return mav;
	}//fecha editar
	
	@GetMapping("/estoque/filtro")
	public ModelAndView trocarFiltro(HttpSession session,
								@RequestParam(required = false, defaultValue = "filtro") String tab) {
		ModelAndView mav = new ModelAndView();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null) {
			mav.setViewName("redirect:/");
			return mav;
		}
		mav.addObject("usuarioLogado", usuarioLogado);
		mav.addObject("tamanhos", Tamanho.values()); 
		mav.addObject("tabAtiva", tab);
		mav.addObject("produto", new Produto());
		
		mav.setViewName("navegacao/navegacao");
		return mav;
	}
	@PostMapping("/estoque/filtro")
    public ModelAndView filtrar(HttpSession session,
                                @RequestParam String coluna,
                                @RequestParam String valor) throws ServiceExc {
			
		
        ModelAndView mav = new ModelAndView();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            mav.setViewName("redirect:/");
            return mav;
        }
        try {           
            int col = Integer.parseInt(coluna);
            if(col == 4) {
            	 if (valor != null && valor.contains(",")) {
            	        valor = valor.substring(valor.lastIndexOf(",") + 1).trim();
            	    }
            	   
            	    if (valor != null) {
            	        valor = valor.trim();
            	    }
            	    
            } else {
            	if (valor != null && valor.contains(",")) {
            	    valor = valor.substring(0, valor.indexOf(",")).trim();
            	}
            }
          
            if(col == 1 || col == 3 || col == 8 ) {
            	mav.addObject("produtos", prodServ.filtrarInt(col, Integer.parseInt(valor)));
            	
            }else if(col == 2 || col == 4 || col == 7){
            	
            	mav.addObject("produtos", prodServ.filtrarString(col, valor));
            }else {
            	mav.addObject("produtos", prodServ.filtrarDecimal(col, new BigDecimal(valor)));
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido para conversão: " + valor);
            mav.addObject("erroFiltro", "O valor informado não é um número válido.");
            mav.addObject("produtos", null);
        }

        mav.addObject("usuarioLogado", usuarioLogado);
        mav.addObject("tabAtiva", "filtro");
        mav.addObject("produto", new Produto());     
        mav.addObject("tamanhos", Tamanho.values()); 
        mav.setViewName("navegacao/navegacao");
      
        return mav;
    }

}//fecha classe
			
