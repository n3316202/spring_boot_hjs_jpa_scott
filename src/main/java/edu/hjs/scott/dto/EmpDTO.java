package edu.hjs.scott.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {
    private Long empno;
    private String ename;
    private String job;
    private EmpDTO mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private double deptno;
}
