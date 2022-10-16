package edu.hjs.scott.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "salgrade")
@Getter
@Setter
public class Salgrade {

    @Id
    private Integer grade;

    @Column(nullable = false)
    private Double losal;

    @Column(nullable = false)
    private Double hisal;
}
