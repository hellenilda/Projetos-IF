package edu.ifpb.webII.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.ifpb.webII.model.Professor;
import edu.ifpb.webII.model.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService profesorService;

	@GetMapping("/cadastrar")
	public String cadastrar(Professor professor) {
		return "/professores/cadastroProfessor";
	}

	
	@PostMapping("/salvar")
	public String salvar(Professor professor, RedirectAttributes attr) {
	    if (professor.getMatricula() == null) {
	        profesorService.cadastrarProfessor(professor);
	    } else {
	        profesorService.atualizarProfessor(professor);
	    }
	    attr.addFlashAttribute("sucesso", "Professor salvo com sucesso!");
	    return "redirect:/professores/cadastrar";
	}


	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Professor> professores = profesorService.listarProfessores();
		model.addAttribute("professores", professores);
		return "/professores/listaProfessor";
	}

	@GetMapping("/editar/{matricula}")
	public String preEditar(@PathVariable("matricula") Long matricula, ModelMap model) {
		Professor professor = profesorService.listarProfessor(matricula);
		model.addAttribute("professor", professor);
		return "/professores/cadastroProfessor";
	}

	@PostMapping("/editar")
	public String editar(Professor professor, RedirectAttributes attr) {
		profesorService.atualizarProfessor(professor);
		attr.addFlashAttribute("sucesso", "Professor editado com sucesso!");
		return "redirect:/professores/cadastrar";
	}

	@GetMapping("excluir/{matricula}")
	public String excluir(@PathVariable("matricula") Long matricula, ModelMap model) {
		profesorService.deletarProfessor(matricula);
		model.addAttribute("sucesso", "Professor excluído com sucesso!");
		return listar(model);
	}

}