package edu.hjs.scott.controller;

import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.service.DeptSevice;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@RestController
@RequestMapping("/rest")
public class DeptRestController {

    @Autowired
    private DeptSevice deptService;

    @GetMapping("/dept/all")
    public List<Dept> selectAll(){
        return deptService.selectAll();
    }


}
