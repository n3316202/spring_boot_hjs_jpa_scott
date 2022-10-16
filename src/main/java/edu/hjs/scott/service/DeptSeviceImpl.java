package edu.hjs.scott.service;


import edu.hjs.scott.dto.DeptDto;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptSeviceImpl implements DeptSevice {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Dept insert(Dept dept) {
        return deptRepository.save(dept);
    }

    @Override
    public Dept update(Dept dept) {

        if (dept.getDeptno() == 0L) {
            throw new RuntimeException("DEPTNO can not be 0 when try to update.");
        }

        return deptRepository.save(dept);
    }

    @Override
    public Long delete(Dept dept) {
        try {
            deptRepository.delete(dept);
        } catch (Exception e) {
            throw e;
        }

        return 1L;
    }

    @Override
    public Long count() {
        return deptRepository.count();
    }

    @Override
    public Dept selectByDeptno(Long deptno) {

        Optional<Dept> optionalDept =  deptRepository.findById(deptno);

        if(optionalDept.isPresent())
            return optionalDept.get();
        else
            return null;
    }

    @Override
    public List<Dept> selectAll() {
        return deptRepository.findAll();
    }

    @Override
    public List<Dept> selectByLimit(int page, int size) {
        return null;
    }

    @Override
    public Page<Dept> selectByLimitForPage(Pageable pageable) {
        return null;
    }


    //쿼리 메소드 활용
    @Override
    public Dept selectByDname(String dname) {
        return deptRepository.findByDname(dname);
    }

    @Override
    public List<Dept> selectByLoc(String loc) {
        return deptRepository.findByLoc(loc);
    }

}
