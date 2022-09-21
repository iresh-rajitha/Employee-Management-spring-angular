package com.example.springweb.services;

import com.example.springweb.dtos.SkillDto;
import com.example.springweb.models.Skill;
import com.example.springweb.repos.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getSkills(){
        return skillRepository.findAll();
    }
    public void addSkill(SkillDto skillDto){
        Skill skill = new Skill();
        skill.setSkillName(skillDto.getSkillName());
        skillRepository.save(skill);
    }
    public Skill getSkill(long id){
        return skillRepository.findById(id).get();
    }
    public void deleteSkill(long id){
        skillRepository.deleteById(id);
//        skillRepository.delete(getSkill(id));
    }
    public void updateSkill(long id , SkillDto newSkillDto){
        Skill skill = getSkill(id);
        skill.setSkillName(newSkillDto.getSkillName());
        skillRepository.save(skill);
    }
}
