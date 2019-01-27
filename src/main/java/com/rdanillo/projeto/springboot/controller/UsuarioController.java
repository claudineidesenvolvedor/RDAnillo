
package com.rdanillo.projeto.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rdanillo.projeto.springboot.Repository.AparelhoRepository;
import com.rdanillo.projeto.springboot.Repository.PerfilRepository;
import com.rdanillo.projeto.springboot.Repository.UsuarioRepository;
import com.rdanillo.projeto.springboot.domain.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;
	private final PerfilRepository perfilRepository;
	private final AparelhoRepository aparelhoRepository;
 	private final String USUARIO_URI = "usuario/";

	public UsuarioController(UsuarioRepository clienteRepository, PerfilRepository perfilRepository, AparelhoRepository aparelhoRepository) {
		this.usuarioRepository = clienteRepository;
		this.perfilRepository = perfilRepository;
		this.aparelhoRepository = aparelhoRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Usuario> usuario = this.usuarioRepository.findAll();
		return new ModelAndView(USUARIO_URI + "list","usuario",usuario);
	}

	@GetMapping("{idUsuario}")
	public ModelAndView view(@PathVariable("idUsuario") Usuario usuario) {
		return new ModelAndView(USUARIO_URI + "view","usuario",usuario);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Usuario usuario) {
		return USUARIO_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Usuario usuario,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(USUARIO_URI + "form","formErrors",result.getAllErrors()); }
		usuario = this.usuarioRepository.save(usuario);
		redirect.addFlashAttribute("globalMessage","usuario gravado com sucesso");
		return new ModelAndView("redirect:/" + USUARIO_URI + "{usuario.idUsuario}","usuario.idUsuario",usuario.getIdUsuario());
	}

	@GetMapping(value = "remover/{idUsuario}")
	public ModelAndView remover(@PathVariable("idUsuaro") Long id,RedirectAttributes redirect) {
		this.usuarioRepository.deleteById(id);
		Iterable<Usuario> usuarios = this.usuarioRepository.findAll();
		
		ModelAndView mv = new ModelAndView(USUARIO_URI + "list","usuarios",usuarios);
		mv.addObject("globalMessage","usuario removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{idUsuario}")
	public ModelAndView alterarForm(@PathVariable("idUsuario") Usuario usuario) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("todosPerfil",perfilRepository.findAll());
		model.put("todosAparelhos",aparelhoRepository.findAll());
		model.put("usuario",usuario);
		return new ModelAndView(USUARIO_URI + "form","usuario",usuario);
	}

}
