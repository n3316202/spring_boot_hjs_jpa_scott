package edu.hjs.scott.controller;

import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.service.DeptSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class DeptController {

    @Autowired
    private DeptSevice deptService;

    @GetMapping("/dept/all")
    public String selectAll(Model model){
        model.addAttribute("deptList", deptService.selectAll());
        return "dept";
    }



}
