package br.com.unitri.v2.v2ppi.controller;

import br.com.unitri.v2.v2ppi.domain.Score;
import br.com.unitri.v2.v2ppi.service.interfaceServ.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    private Long studentId;
    @GetMapping(value={"/{id}"})
    public ModelAndView findAll(@PathVariable("id") Long id) {
        this.studentId = id;
        ModelAndView mv = new ModelAndView("score");
        mv.addObject("scores",scoreService.findAll(id));
        return mv;
    }

    @GetMapping(value={"/home"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("score");
        mv.addObject("scores",scoreService.findAll(studentId));
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Score score) {
        ModelAndView mv = new ModelAndView("score_create");
        mv.addObject("score", score);
        return mv;
    }

    @GetMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(scoreService.findById(id));
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        scoreService.delete(id);
        return findAll(studentId);
    }

    @PostMapping(value="/save")
    public ModelAndView save(@Valid Score score, BindingResult result) {
        if(result.hasErrors()) {
            return add(score);
        }
        scoreService.create(score, studentId);
        return findAll(studentId);
    }

}
