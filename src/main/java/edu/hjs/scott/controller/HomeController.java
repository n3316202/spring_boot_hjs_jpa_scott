package edu.hjs.scott.controller;

import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.service.DeptSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
