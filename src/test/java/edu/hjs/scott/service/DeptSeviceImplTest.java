package edu.hjs.scott.service;

import edu.hjs.scott.dto.DeptDto;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.repository.DeptRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class DeptServiceImplTest {

    @Autowired
    private DeptSeviceImpl deptSevice;

    @Test
    @DisplayName("Dept insert 테스트")
    void insertTest() {

        Dept dept = new Dept();
        dept.setDeptno(1L);
        dept.setDname("업부");
        dept.setLoc("서울");


        deptSevice.insert(dept);

    }

    @Test
    @DisplayName("Dept insert 테스트")
    void updateTest() {

        Dept dept = new Dept();
        dept.setDeptno(1L);
        dept.setDname("영업사업부");
        dept.setLoc("서울");


        deptSevice.insert(dept);

    }

    @Test
    @DisplayName("Dept delete 테스트")
    void deleteTest() {

        Dept dept = new Dept();
        dept.setDeptno(1L);
        dept.setDname("영업사업부");
        dept.setLoc("서울");


        deptSevice.delete(dept);
    }

    @Test
    @DisplayName("Dept delete 테스트")
    void selectByDeptnoTest() {

        Dept dept = deptSevice.selectByDeptno(10L);
        System.out.println(dept.getDname());
        System.out.println(dept.getLoc());
        System.out.println(dept.getDeptno());
    }
}