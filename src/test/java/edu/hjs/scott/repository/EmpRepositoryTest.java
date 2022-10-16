package edu.hjs.scott.repository;

import edu.hjs.scott.dto.EmpDTO;
import edu.hjs.scott.dto.PageRequestDTO;
import edu.hjs.scott.dto.PageResultDTO;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.entity.Emp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class EmpRepositoryTest {

    @Autowired
    private EmpRepository empRepository;

    @Test
    void displayTest(){

        System.out.println("나와라 뽕");
        
    }

    @Transactional
    @Test
    @DisplayName("Emp 조회 테스트")
    public void findAllEmpTest(){

        long count = empRepository.count();

        System.out.println(count);

        List<Emp> emps = empRepository.findAll();

        for(Emp emp : emps){
            System.out.println(emp);
            System.out.println(emp.getStaff());
        }
    }

    @Test
    @DisplayName("Emp 페이징 테스트")
    public void findAllPagingEmpTest(){

/*      log.info("전체 페이지 수: " + testEntities.getTotalPages());
        log.info("현재 페이지 번호: " + testEntities.getPageable().getPageNumber());
        log.info("페이지 별 사이즈: " + testEntities.getPageable().getPageSize());
        log.info("조건 일치 총 항목 수: " + testEntities.getTotalElements());*/

        Sort sort = Sort.by("empno").descending();
        Pageable pageable = PageRequest.of(0,10,sort);

        Page<Emp> result = empRepository.findAll(pageable);

        System.out.println(result);

        System.out.println(result.getTotalPages());
        System.out.println(result.getTotalElements());
        System.out.println(result.getNumber());
    }

 }