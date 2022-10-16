package edu.hjs.scott.service;


import edu.hjs.scott.dto.EmpDTO;
import edu.hjs.scott.dto.PageRequestDTO;
import edu.hjs.scott.dto.PageResultDTO;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.entity.Emp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmpSevice {

    public Long register(EmpDTO empDTO); //insert
    //public Emp update(Emp dept);
    //public Emp delete(Emp dept);


    public Long count();
    //public Emp selectByDeptno(Long deptno);
    public List<Emp> selectAll();
    //Long register(EmpDTO dto);
    public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO requestDTO);


    //public List<Dept> selectByLimit(int page, int size);
    //public Page<Dept> selectByLimitForPage(Pageable pageable);

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    // java 8 버전부터 인터페이스의 실제 내용을 가지는 코드는 default라는 키워드로 생성할 수 있다 -> 실제 코드를 인터페이스에 선언할 수 있다
    // => 추상클래스를 생략하는것이 가능해 졌다

   default Emp dtoToEntity(EmpDTO dto){

       Emp entity = Emp.builder()
                .comm(dto.getComm())
                .empno(dto.getEmpno())
                .hiredate(dto.getHiredate())
                .sal(dto.getSal())
                //.mgr(dtoToEntity(dto.getMgr()))
                .job(dto.getJob())
                .ename(dto.getEname())
                .build();

       return entity;
    }

    default EmpDTO entityToDto(Emp entity){

        EmpDTO dto = EmpDTO.builder()
                .comm(entity.getComm())
                //.deptno(entity.getDept().getDeptno())
                .empno(entity.getEmpno())
                .ename(entity.getEname())
                .job(entity.getJob())
                .sal(entity.getSal())
                .hiredate(entity.getHiredate())
                //.mgr(entity.getMgr().getEmpno())
                .build();

        return dto;
    }
}
