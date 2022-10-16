package edu.hjs.scott.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emp")
@ToString(exclude={"staff"})
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    @Id //PK임을 지정
    private Long empno;

    @Column(length = 10, nullable = false)
    private String ename;

    @Column(length = 9)
    private String job;

    @ManyToOne
    @JoinColumn(name="mgr")
    private Emp mgr;

    @Builder.Default//@Builder는 초기화를 무시한다.
    @OneToMany(mappedBy = "mgr")
    @JsonIgnore
    private List<Emp> staff = new ArrayList<Emp>();

    @Temporal(TemporalType.DATE)
    private Date hiredate;

    private Double sal;
    private Double comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
}
