package com.apisys.college.controller;

import com.apisys.college.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.apisys.college.repository.AlunoRepository;
import java.util.Optional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@RequestMapping("/alunos")
@Controller
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;

	@GetMapping("/")
    public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("/post");
		modelAndView.addObject("alunos", alunoRepository.findAll());
		return modelAndView;
    }
	
	@GetMapping("/add")
    public ModelAndView add(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("/postAdd");
		modelAndView.addObject("aluno", aluno);
		return modelAndView;
    }
	
	@GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Aluno> alunos = alunoRepository.findById(id);
    	return add(alunos.get());
    }
	
	@GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
    	alunoRepository.deleteById(id);
    	return findAll();
    }
	
	@PostMapping("/save")
    public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
		if(result.hasErrors()) {
			return add(aluno);
		}
		alunoRepository.save(aluno);
		return findAll();
    }

	//@RequestMapping(value = "/alunos/new", method = RequestMethod.GET)
	//public String createForm(Model uiModel) {
	//	populateEditForm(uiModel, new Aluno());
	//	return "alunos/create";
	//}

	//@RequestMapping(value = "/alunos/new", method = RequestMethod.POST)
	//public String create(@Valid Aluno aluno, BindingResult bindingResult, Model uiModel,
	//		HttpServletRequest httpServletRequest) {
	//	if (bindingResult.hasErrors()) {
	//		populateEditForm(uiModel, aluno);
	//		return "alunos/create";
	//	}
	//	uiModel.asMap().clear();
	//	alunoRepository.save(aluno);
	//	return "redirect:/alunos/" + encodeUrlPathSegment(aluno.getId().toString(), httpServletRequest);
	//}

	//@RequestMapping(value = "/alunos/{alunoId}/edit", method = RequestMethod.POST)
	//public String update(@Valid Aluno aluno, BindingResult bindingResult, Model uiModel,
	//		HttpServletRequest httpServletRequest) {
	//	if (bindingResult.hasErrors()) {
	//		populateEditForm(uiModel, aluno);
	//		return "alunos/update";
	//	}
	//	uiModel.asMap().clear();
	//	alunoRepository.save(aluno);
	//	return "redirect:/alunos/" + encodeUrlPathSegment(aluno.getId().toString(), httpServletRequest);
	//}

	//@RequestMapping(value = "/alunos/{alunoId}/edit", method = RequestMethod.GET)
	//public String updateForm(@PathVariable("id") Long id, Model uiModel) {
	//	populateEditForm(uiModel, alunoRepository.findById(id));
	//	return "alunos/update";
	//}

	//@RequestMapping("/alunos/{alunoId}")
	//public String show(@PathVariable("id") Long id, Model uiModel) {
	//	uiModel.addAttribute("aluno", alunoRepository.findAluno(id));
		
	//	uiModel.addAttribute("itemId", id);
	//	return "alunos/show";
	//}

	//@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	//public String list(@RequestParam(value = "page", required = false) Integer page,
	//		@RequestParam(value = "size", required = false) Integer size,
	//		@RequestParam(value = "sortFieldName", required = false) String sortFieldName,
	//		@RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
		
	//	if (page != null || size != null) {
	//		int sizeNo = size == null ? 10 : size.intValue();
	//		final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	//		uiModel.addAttribute("alunos",alunoRepository.findAlunoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
	//		float nrOfPages = (float) alunoRepository.count() / sizeNo;
	//		uiModel.addAttribute("maxPages",
	//				(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	//	} else {
	//		uiModel.addAttribute("alunos", alunoRepository.findAllalunos(sortFieldName, sortOrder));
	//	}
		
	//	return "alunos/list";
	//}

	//@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	//public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page,
	//		@RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	//	Optional<Aluno> alunos = alunoRepository.findById(id);
	//	alunoRepository.delete(alunos.get());
	//	uiModel.asMap().clear();
	//	uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	//	uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	//	return "redirect:/alunos";
	//}

	//void populateEditForm(Model uiModel, Aluno aluno) {
	//	uiModel.addAttribute("aluno", aluno);
	//	uiModel.addAttribute("cursos", cursoRepository.findAll());
	//	uiModel.addAttribute("status", Arrays.asList(Status.values()));
	//}

	//String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
	//	String enc = httpServletRequest.getCharacterEncoding();
	//	if (enc == null) {
	//		enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
	//	}
	//	pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
	//	return pathSegment;
	//}

}
