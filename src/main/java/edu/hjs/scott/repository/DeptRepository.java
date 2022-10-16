package edu.hjs.scott.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hjs.scott.entity.Dept;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface DeptRepository extends JpaRepository<Dept,Long> {
    //쿼리 메소드 = find + (엔티티이름) + By + 변수이름
    public Dept findByDname(String dname);
    public List<Dept> findByLoc(String loc);
}
