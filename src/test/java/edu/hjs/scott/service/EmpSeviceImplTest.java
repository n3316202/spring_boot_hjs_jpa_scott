package edu.hjs.scott.service;

import edu.hjs.scott.dto.EmpDTO;
import edu.hjs.scott.dto.PageRequestDTO;
import edu.hjs.scott.dto.PageResultDTO;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.entity.Emp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class EmpSeviceImplTest {

    @Autowired
    private EmpSeviceImpl empSevice;

    @Test
    @DisplayName("Emp paging 테스트")
    void getListTest() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<EmpDTO, Emp> resultDTO = empSevice.getList(pageRequestDTO);

        for(EmpDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }
    }

    @Test
    @DisplayName("Emp paging 테스트")
    void registerTest() {

        for(int i =1 ; i<=300; i++){
            EmpDTO empDTO = new EmpDTO();
            empDTO.setComm(null);
            empDTO.setEmpno((long)i);
            empDTO.setEname("홍길동" + i);
            empDTO.setMgr(null);

            empSevice.register(empDTO);
        }
    }

}