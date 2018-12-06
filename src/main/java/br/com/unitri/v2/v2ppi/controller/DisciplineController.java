package br.com.unitri.v2.v2ppi.controller;

import br.com.unitri.v2.v2ppi.models.entity.Discipline;
import br.com.unitri.v2.v2ppi.service.interfaceServ.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping(value={"/home"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("disciplines", disciplineService.findAll());
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Discipline discipline) {
        ModelAndView mv = new ModelAndView("discipline_create");
        mv.addObject("discipline", discipline);
        return mv;
    }

    @PostMapping(value="/save")
    public ModelAndView save(@Valid Discipline discipline, BindingResult result) {
        if(result.hasErrors()) {
            return add(discipline);
        }
        disciplineService.create(discipline);
        return home();
    }

    @GetMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(disciplineService.findById(id));
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        disciplineService.delete(id);
        return home();
    }
}
