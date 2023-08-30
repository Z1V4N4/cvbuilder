package com.batm.cvbuilder.controller.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batm.cvbuilder.handler.Response;
import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.model.transaction.Skills;
import com.batm.cvbuilder.service.transaction.SkillsService;

@RestController
@RequestMapping("api")
public class SkillsRestController {
    @Autowired
    SkillsService skillsService;

    @GetMapping("skills")
    public ResponseEntity<Object> Get() {
        List<Skills> skills = skillsService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, skills);
    }

    @GetMapping("skills/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Skills> skills = skillsService.Get(id);
        if (skills.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, skills);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("skills/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Skill> skills = skillsService.getMySkills(id);
        if (!skills.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, skills);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("skills")
    public ResponseEntity<Object> Save(@RequestBody Skills skills) {
        boolean result = skillsService.Save(skills);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("skiils/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = skillsService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }

}
