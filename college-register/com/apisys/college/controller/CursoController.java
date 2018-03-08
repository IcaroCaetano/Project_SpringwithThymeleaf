package com.apisys.college.controller;
import com.apisys.college.model.Curso;
import com.apisys.college.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/cursos")
@Controller
public class CursoController {

      @Autowired
       CursoRepository cursoRepository;
      
      @GetMapping("/")
      public ModelAndView findAll() {
  		ModelAndView modelAndView = new ModelAndView("/post");
  		modelAndView.addObject("cursos", cursoRepository.findAll());
  		return modelAndView;
      }
  	
  	@GetMapping("/add")
      public ModelAndView add(Curso curso) {
  		ModelAndView modelAndView = new ModelAndView("/postAdd");
  		modelAndView.addObject("cursos", curso);
  		return modelAndView;
      }
  	
  	@GetMapping("/edit/{id}")
      public ModelAndView edit(@PathVariable("id") Long id) {
  		Optional<Curso> cursos = cursoRepository.findById(id);
      	return add(cursos.get());
      }
  	
  	@GetMapping("/delete/{id}")
      public ModelAndView delete(@PathVariable("id") Long id) {
  		cursoRepository.deleteById(id);
      	return findAll();
      }
  	
  	@PostMapping("/save")
      public ModelAndView save(@Valid Curso curso, BindingResult result) {
  		if(result.hasErrors()) {
  			return add(curso);
  		}
  		cursoRepository.save(curso);
  		return findAll();
      }


	//@RequestMapping(value = "/cursos/new", method = RequestMethod.GET)
    //public String create(@Valid Curso curso, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
     //   if (bindingResult.hasErrors()) {
     //       populateEditForm(uiModel, curso);
     //       return "cursos/create";
     //   }
    //    uiModel.asMap().clear();
    //    cursoRepository.persist();
    //    return "redirect':/cursos/" + encodeUrlPathSegment(curso.getId().toString(), httpServletRequest);
    //}
    
    
    //@RequestMapping("/cursos/{cursoId}")
    //public String show(@PathVariable("id") Long id, Model uiModel) {
    //    uiModel.addAttribute("curso", cursoRepository.findCurso(id));
    //    uiModel.addAttribute("itemId", id);
    //    return "cursos/show";
    //}
    
    //@RequestMapping(value = "/cursos", method = RequestMethod.GET)
    //public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    //    if (page != null || size != null) {
    //        int sizeNo = size == null ? 10 : size.intValue();
    //        final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
    //        uiModel.addAttribute("cursos", cursoRepository.findCursoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
    //        float nrOfPages = (float) cursoRepository.countcursos() / sizeNo;
    //        uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
    //    } else {
    //        uiModel.addAttribute("cursos", cursoRepository.findAllcursos(sortFieldName, sortOrder));
    //    }
    //    return "cursos/list";
    //}
    
    
    @GetMapping("/cursos")
    public String listar() {
    	return "ListaCursos";
    }
    
    //@RequestMapping(value = "/cursos/{cursoId}/edit", method = RequestMethod.GET)
    //public String update(@Valid Curso curso, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    //    if (bindingResult.hasErrors()) {
    //        populateEditForm(uiModel, curso);
    //        return "cursos/update";
     //   }
    //    uiModel.asMap().clear();
    //    cursoRepository.merge();
    ///    return "redirect:/cursos/" + encodeUrlPathSegment(curso.getId().toString(), httpServletRequest);
    //}
    
    //@RequestMapping(value = "/cursos/{cursoId}/edit", method = RequestMethod.GET)
    //public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    //    populateEditForm(uiModel, cursoRepository.findCurso(id));
    //    return "cursos/update";
    //}
    
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    //public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
   //     Curso curso = cursoRepository.findCurso(id);
   //     cursoRepository.remove();
    //    uiModel.asMap().clear();
   //     uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
   //     uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
   //     return "redirect:/cursos";
   // }
    
    //void populateEditForm(Model uiModel, Curso curso) {
     //   uiModel.addAttribute("curso", curso);
    //}
    
    //String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
     //   String enc = httpServletRequest.getCharacterEncoding();
      //  if (enc == null) {
      //      enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
      //  }
      //  pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
      //  return pathSegment;
    //}
}
