package br.com.unitri.v2.v2ppi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @GetMapping("/fragments")
    public String getHome() {
        return "created.html";
    }
}
