package edu.hjs.scott.service;


import edu.hjs.scott.dto.EmpDTO;
import edu.hjs.scott.dto.PageRequestDTO;
import edu.hjs.scott.dto.PageResultDTO;
import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.entity.Emp;
import edu.hjs.scott.repository.DeptRepository;
import edu.hjs.scott.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EmpSeviceImpl implements EmpSevice {

    @Autowired
    private EmpRepository empRepository;


    @Override
    public Long register(EmpDTO dto) {
        Emp emp = dtoToEntity(dto);

        empRepository.save(emp);

        return emp.getEmpno();
    }

    @Override
    public Long count() {
        return empRepository.count();
    }

    @Transactional
    @Override
    public List<Emp> selectAll() {

        return empRepository.findAll();
    }

    @Override
    public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("empno").descending());

        Page<Emp> result = empRepository.findAll(pageable);

        Function<Emp,EmpDTO> fn = (entity -> entityToDto(entity));

        // JPA의 처리결과인 Page<Entity>와 Function을 전달해 엔티티 객체들을 DTO의 리스트로 변환하고 화면에 페이지 처리와 필요한 값들을 생성한다
        return new PageResultDTO<>(result,fn);
    }




}
