package edu.hjs.scott.repository;

import edu.hjs.scott.entity.Dept;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    @Transactional
    @DisplayName("Dept 조회 테스트")
    public void findAllDeptTest(){

        long count = deptRepository.count();

        List<Dept> depts = deptRepository.findAll();

        for(Dept dept : depts){
            System.out.println(dept.getDname() + ":::" + dept.getLoc() + ":::"  + dept.getDeptno());
        }
    }
}