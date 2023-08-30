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
import com.batm.cvbuilder.model.transaction.Experience;
import com.batm.cvbuilder.service.transaction.ExperienceService;

@RestController
@RequestMapping("api")
public class ExperienceRestController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("experience")
    public ResponseEntity<Object> Get() {
        List<Experience> experiences = experienceService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, experiences);
    }

    @GetMapping("experience/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Experience> experience = experienceService.Get(id);
        if (experience.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, experience);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("experience/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Experience> experiences = experienceService.getMyExperiences(id);
        if (!experiences.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, experiences);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("experience")
    public ResponseEntity<Object> Save(@RequestBody Experience experience) {
        boolean result = experienceService.Save(experience);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("experience/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = experienceService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
