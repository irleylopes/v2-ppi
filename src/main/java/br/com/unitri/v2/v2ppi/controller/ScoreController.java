package br.com.unitri.v2.v2ppi.controller;

import br.com.unitri.v2.v2ppi.models.Score;
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

    @GetMapping(value={"/"})
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("score");
        Score score = new Score("0","0","0","0","0","0");
        score.setId(1L);
        score = scoreService.create(score);
        List<Score> scores = new ArrayList<>();
        scores.add(score);
        mv.addObject("score", scores);
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Score score) {
        ModelAndView mv = new ModelAndView("score");
        mv.addObject("score", score);
        return mv;
    }

    @GetMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(scoreService.findById(id));
    }
}
