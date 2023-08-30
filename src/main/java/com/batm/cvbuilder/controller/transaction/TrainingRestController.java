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
import com.batm.cvbuilder.model.transaction.Training;
import com.batm.cvbuilder.service.transaction.TrainingService;

@RestController
@RequestMapping("api")
public class TrainingRestController {
    @Autowired
    TrainingService trainingService;

    @GetMapping("training")
    public ResponseEntity<Object> Get() {
        List<Training> trainings = trainingService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, trainings);
    }

    @GetMapping("training/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Training> training = trainingService.Get(id);
        if (training.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, training);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("training/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Training> trainings = trainingService.getMyTrainings(id);
        if (!trainings.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, trainings);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("training")
    public ResponseEntity<Object> Save(@RequestBody Training training) {
        boolean result = trainingService.Save(training);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("training/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = trainingService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
