package br.com.unitri.v2.v2ppi.controller;

import br.com.unitri.v2.v2ppi.models.Student;
import br.com.unitri.v2.v2ppi.service.interfaceServ.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value={"/"})
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("student");///chama pagina
        mv.addObject("students", studentService.findAll());
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Student student) {
        ModelAndView mv = new ModelAndView("student_create");
        mv.addObject("student", student);
        return mv;
    }

    @PostMapping(value="/save")
    public ModelAndView save(@Valid Student student, BindingResult result) {
        if(result.hasErrors()) {
            return add(student);
        }
        studentService.create(student);
        return findAll();
    }

    @GetMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(studentService.findById(id));
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return findAll();
    }
}
