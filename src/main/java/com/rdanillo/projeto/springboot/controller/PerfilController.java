
package com.rdanillo.projeto.springboot.controller;

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

import com.rdanillo.projeto.springboot.Repository.PerfilRepository;
import com.rdanillo.projeto.springboot.domain.Perfil;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	private final PerfilRepository prefilRepository;
	private final String PERFIL_URI = "perfil/";

	public PerfilController(PerfilRepository prefilRepository) {
		this.prefilRepository = prefilRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Perfil> perfil = this.prefilRepository.findAll();
		return new ModelAndView(PERFIL_URI + "list","perfil",perfil);
	}

	@GetMapping("{idPerfil}")
	public ModelAndView view(@PathVariable("idPerfil") Perfil perfil) {
		return new ModelAndView(PERFIL_URI + "view","perfil",perfil);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Perfil perfil) {
		return PERFIL_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Perfil perfil,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(PERFIL_URI + "form","formErrors",result.getAllErrors()); }
		perfil = this.prefilRepository.save(perfil);
		redirect.addFlashAttribute("globalMessage","perfil gravado com sucesso");
		return new ModelAndView("redirect:/" + PERFIL_URI + "{perfil.idPerfil}","perfil.idPerfil",perfil.getIdPerfil());
	}

	@GetMapping(value = "remover/{idPerfil}")
	public ModelAndView remover(@PathVariable("idPerfil") Long id,RedirectAttributes redirect) {
		this.prefilRepository.deleteById(id);
		Iterable<Perfil> perfil = this.prefilRepository.findAll();
		
		ModelAndView mv = new ModelAndView(PERFIL_URI + "list","perfil",perfil);
		mv.addObject("globalMessage","perfil removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{idPerfil}")
	public ModelAndView alterarForm(@PathVariable("idPerfil") Perfil perfil) {
		return new ModelAndView(PERFIL_URI + "form","perfil",perfil);
	}

}
