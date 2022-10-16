package edu.hjs.scott.service;


import edu.hjs.scott.dto.DeptDto;
import edu.hjs.scott.entity.Dept;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


public interface DeptSevice {

    public Dept insert(Dept dept);
    public Dept update(Dept dept);
    public Long delete(Dept dept);


    public Long count();
    public Dept selectByDeptno(Long deptno);
    public List<Dept> selectAll();

    public List<Dept> selectByLimit(int page, int size);

    public Page<Dept> selectByLimitForPage(Pageable pageable);

    public Dept selectByDname(String dname);
    public List<Dept> selectByLoc(String loc);
}
