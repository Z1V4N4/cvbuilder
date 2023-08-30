package com.batm.cvbuilder.controller.master;

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
import com.batm.cvbuilder.service.master.SkillService;

@RestController
@RequestMapping("api")
public class SkillRestController {
    @Autowired
    SkillService skillService;

    @GetMapping("skill")
    public ResponseEntity<Object> Get() {
        List<Skill> skills = skillService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, skills);
    }

    @GetMapping("skill/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Skill> skill = skillService.Get(id);
        if (skill.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, skill);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("skill")
    public ResponseEntity<Object> Save(@RequestBody Skill skill) {
        boolean result = skillService.Save(skill);
        if (result) {
            Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("skill/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = skillService.Delete(id);
        if (result) {
            Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
