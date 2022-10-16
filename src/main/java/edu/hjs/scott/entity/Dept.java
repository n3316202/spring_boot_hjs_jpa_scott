package edu.hjs.scott.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
@Getter
@Setter
public class Dept {

    @Id
    private Long deptno;

    @Column(length = 14, nullable = false)
    private String dname;

    @Column(length = 13)
    private String loc;
}
