
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

import com.rdanillo.projeto.springboot.Repository.AparelhoRepository;
import com.rdanillo.projeto.springboot.domain.Aparelho;

@Controller
@RequestMapping("/aparelho")
public class AparelhoController {

	private final AparelhoRepository aparelhoRepository;
	private final String APARELHO_URI = "aparelho/";

	public AparelhoController(AparelhoRepository aparelhoRepository) {
		this.aparelhoRepository = aparelhoRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Aparelho> aparelho = this.aparelhoRepository.findAll();
		return new ModelAndView(APARELHO_URI + "list","aparelho",aparelho);
	}

	@GetMapping("{idAparelho}")
	public ModelAndView view(@PathVariable("idAparelho") Aparelho aparelho) {
		return new ModelAndView(APARELHO_URI + "view","aparelho",aparelho);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Aparelho aparelho) {
		return APARELHO_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Aparelho aparelho,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(APARELHO_URI + "form","formErrors",result.getAllErrors()); }
		aparelho = this.aparelhoRepository.save(aparelho);
		redirect.addFlashAttribute("globalMessage","aparelho gravado com sucesso");
		return new ModelAndView("redirect:/" + APARELHO_URI + "{aparelho.idAparelho}","aparelho.idAparelho",aparelho.getIdAparelho());
	}

	@GetMapping(value = "remover/{idAparelho}")
	public ModelAndView remover(@PathVariable("idaparelho") Long id,RedirectAttributes redirect) {
		this.aparelhoRepository.deleteById(id);
		Iterable<Aparelho> aparelho = this.aparelhoRepository.findAll();
		
		ModelAndView mv = new ModelAndView(APARELHO_URI + "list","aparelho",aparelho);
		mv.addObject("globalMessage","aparelho removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{idAparelho}")
	public ModelAndView alterarForm(@PathVariable("idAparelho") Aparelho aparelho) {
		return new ModelAndView(APARELHO_URI + "form","aparelho",aparelho);
	}

}