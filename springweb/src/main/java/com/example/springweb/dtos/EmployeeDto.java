package com.example.springweb.dtos;

import java.util.Set;

public class EmployeeDto {
    private Long id;
    private String name;
    private String dob;
    private String email;
    private Set<SkillDto> skillset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<SkillDto> getSkillset() {
        return skillset;
    }

    public void setSkillset(Set<SkillDto> skillset) {
        this.skillset = skillset;
    }
}
