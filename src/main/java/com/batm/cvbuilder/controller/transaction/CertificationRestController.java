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
import com.batm.cvbuilder.model.transaction.Certification;
import com.batm.cvbuilder.service.transaction.CertificationService;

@RestController
@RequestMapping("api")
public class CertificationRestController {
    @Autowired
    CertificationService certificationService;

    @GetMapping("certification")
    public ResponseEntity<Object> Get() {
        List<Certification> certifications = certificationService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, certifications);
    }

    @GetMapping("certification/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Certification> certification = certificationService.Get(id);
        if (certification.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, certification);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("certification/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Certification> certification = certificationService.getMyCertification(id);
        if (!certification.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, certification);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("certification")
    public ResponseEntity<Object> Save(@RequestBody Certification certification) {
        boolean result = certificationService.Save(certification);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("certification/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = certificationService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
