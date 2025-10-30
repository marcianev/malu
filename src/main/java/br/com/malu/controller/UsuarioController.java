package br.com.malu.controller;

import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.malu.exception.ServiceExc;
import br.com.malu.model.Usuario;
import br.com.malu.service.UsuarioService;
import br.com.malu.util.Util;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class UsuarioController {
	
	
	
	@Autowired 
	private UsuarioService userServ;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/login");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	/*@GetMapping("/navegacao")
	public ModelAndView navegacao() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("navegacao/navegacao");		
		return mav;
	}*/
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br,
								HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mav = new ModelAndView();
		//mav.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mav.setViewName("login/login");			
		}
		
		  System.out.println("📩 Código recebido: " + usuario.getCodigoUser());
		    System.out.println("🔑 Senha recebida (sem MD5): " + usuario.getSenha());

		
		Usuario userLogin = userServ.loginUser(usuario.getCodigoUser(), Util.md5(usuario.getSenha()));
		if(userLogin==null) {
			mav.addObject("msg", "Usuário não encontrado.Tente novamente.");
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			mav.setViewName("redirect:/estoque?tab=estoque");
		}
		return mav;
	}
	

}
