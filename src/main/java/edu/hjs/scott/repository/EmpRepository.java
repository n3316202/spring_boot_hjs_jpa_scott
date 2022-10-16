package edu.hjs.scott.repository;

import edu.hjs.scott.entity.Dept;
import edu.hjs.scott.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmpRepository extends JpaRepository<Emp,Long> {
    //쿼리 메소드 = find + (엔티티이름) + By + 변수이름
}
