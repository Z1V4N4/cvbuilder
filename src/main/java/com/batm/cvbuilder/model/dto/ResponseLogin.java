package com.batm.cvbuilder.model.dto;

import java.util.List;
import java.util.Optional;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.model.transaction.Certification;
import com.batm.cvbuilder.model.transaction.Education;
import com.batm.cvbuilder.model.transaction.Experience;
import com.batm.cvbuilder.model.transaction.Training;

public class ResponseLogin {
    Optional<Employee> employee;
    List<Skill> skill;
    List<Tool> tool;
    List<Experience> experience;
    List<Training> training;
    List<Certification> certificate;
    List<Education> education;

    public Optional<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Optional<Employee> employee) {
        this.employee = employee;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public List<Tool> getTool() {
        return tool;
    }

    public void setTool(List<Tool> tool) {
        this.tool = tool;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Training> getTraining() {
        return training;
    }

    public void setTraining(List<Training> training) {
        this.training = training;
    }

    public List<Certification> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<Certification> certificate) {
        this.certificate = certificate;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

}
