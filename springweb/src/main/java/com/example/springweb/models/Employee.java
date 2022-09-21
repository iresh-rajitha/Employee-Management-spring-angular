package com.example.springweb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String dob;

    private String email;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY , cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable( name = "employee_skill",
                joinColumns = { @JoinColumn(name = "employee_id")},
                inverseJoinColumns = {@JoinColumn( name = "skill_id")})
    private Set<Skill> skillset = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Skill> getSkillset() {
        return skillset;
    }

    public void setSkillset(Set<Skill> skillset) {
        this.skillset = skillset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
