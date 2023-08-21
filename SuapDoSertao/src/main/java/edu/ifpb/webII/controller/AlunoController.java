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

import edu.ifpb.webII.model.Aluno;
import edu.ifpb.webII.model.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/alunos/cadastroAluno";
	}

	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno, RedirectAttributes attr) {
	    if (aluno.getMatricula() == null) {
	    	alunoService.cadastrarAluno(aluno);
	    } else {
	    	alunoService.atualizarAluno(aluno);
	    }
	    attr.addFlashAttribute("sucesso", "Aluno salvo com sucesso!");
	    return "redirect:/alunos/cadastrar";
	}


	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Aluno> alunos = alunoService.listarAlunos();
		model.addAttribute("alunos", alunos);
		return "/alunos/listaAluno";
	}

	@GetMapping("/editar/{matricula}")
	public String preEditar(@PathVariable("matricula") Long matricula, ModelMap model) {
		Aluno aluno = alunoService.listarAluno(matricula);
		model.addAttribute("aluno", aluno);
		return "/alunos/cadastroAluno";
	}

	@PostMapping("/editar")
	public String editar(Aluno aluno, RedirectAttributes attr) {
		alunoService.atualizarAluno(aluno);
		attr.addFlashAttribute("sucesso", "Aluno editado com sucesso!");
		return "redirect:/alunos/cadastrar";
	}

	@GetMapping("excluir/{matricula}")
	public String excluir(@PathVariable("matricula") Long matricula, ModelMap model) {
		alunoService.deletarAluno(matricula);
		model.addAttribute("sucesso", "Aluno excluído com sucesso!");
		return listar(model);
	}

}