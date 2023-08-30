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
import com.batm.cvbuilder.model.transaction.Education;
import com.batm.cvbuilder.service.transaction.EducationService;

@RestController
@RequestMapping("api")
public class EducationRestController {
    @Autowired
    EducationService educationService;

    @GetMapping("education")
    public ResponseEntity<Object> Get() {
        List<Education> educations = educationService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, educations);
    }

    @GetMapping("education/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Education> education = educationService.Get(id);
        if (education.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, education);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("education/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Education> educations = educationService.getMyEducations(id);
        if (!educations.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, educations);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("education")
    public ResponseEntity<Object> Save(@RequestBody Education education) {
        boolean result = educationService.Save(education);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("education/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = educationService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
