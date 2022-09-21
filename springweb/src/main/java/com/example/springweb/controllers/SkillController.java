package com.example.springweb.controllers;

import com.example.springweb.dtos.SkillDto;
import com.example.springweb.models.Skill;
import com.example.springweb.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getSkills(){
        return skillService.getSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable("id") long id){
        return skillService.getSkill(id);
    }

    @PostMapping
    public void addSkill(@RequestBody SkillDto skillDto){
        skillService.addSkill(skillDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable("id") long id){
        skillService.deleteSkill(id);;
    }

    @PutMapping("/{id}")
    public void updateSkill(@PathVariable("id") long id , @RequestBody SkillDto skillDto){
        skillService.updateSkill(id,skillDto);
    }
}
