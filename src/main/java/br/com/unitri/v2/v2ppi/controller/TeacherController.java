package br.com.unitri.v2.v2ppi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unitri.v2.v2ppi.domain.Teacher;
import br.com.unitri.v2.v2ppi.service.implement.TeacherServiceImpl;

@Controller
@RequestMapping(value="/")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping(value = "profile")
    public ModelAndView profileIndex(Principal principal){
        Teacher teacher = this.teacherService.findByUsername(principal.getName());
        ModelAndView mv = new ModelAndView("profile");
        mv.addObject("teacher", teacher);
        return mv;
    }

    @GetMapping(value="add")
    public ModelAndView add(Teacher teacher) {

        ModelAndView mv = new ModelAndView("teacher_create");
        mv.addObject("teacher", teacher);
        return mv;
    }

    @PostMapping(value="save")
    public ModelAndView save(@RequestParam(value = "password") String password, @RequestParam(value = "username") String username, @RequestParam(value = "cpf") String cpf) {
        Teacher teacher = new Teacher();
        teacher.setUsername(username);
        teacher.setCpf(cpf);
        teacher = teacherService.create(teacher, password);

        return new ModelAndView("redirect:findAll");
    }
}
