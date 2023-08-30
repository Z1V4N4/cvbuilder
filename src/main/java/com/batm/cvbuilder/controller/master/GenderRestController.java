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
import com.batm.cvbuilder.model.master.Gender;
import com.batm.cvbuilder.service.master.GenderService;

@RestController
@RequestMapping("api")
public class GenderRestController {
    @Autowired
    GenderService genderService;

    @GetMapping("gender")
    public ResponseEntity<Object> Get() {
        List<Gender> genders = genderService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, genders);
    }

    @GetMapping("gender/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Gender> gender = genderService.Get(id);
        if (gender.isPresent()) {
            return Response.generate("data tidak ditemukan", HttpStatus.OK);
        }
        return Response.generate("data ditemukan", HttpStatus.OK, gender);
    }

    @PostMapping("gender")
    public ResponseEntity<Object> Save(@RequestBody Gender gender) {
        boolean result = genderService.Save(gender);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("gender/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = genderService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
