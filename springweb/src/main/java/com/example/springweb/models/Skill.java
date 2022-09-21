package com.example.springweb.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Getter
//@Setter
//@ToString
@Entity
@Table( name = "skill")
public class Skill{

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    private String skillName;

    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}  , mappedBy = "skillset" )
    @ManyToMany(fetch = FetchType.LAZY ,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    } , mappedBy = "skillset" )
    private Set<Employee> employees= new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
