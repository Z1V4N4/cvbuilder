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
import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.service.master.UserService;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<Object> Get() {
        List<User> users = userService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, users);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<User> user = userService.Get(id);
        if (user.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, user);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("user")
    public ResponseEntity<Object> Save(@RequestBody User user) {
        boolean result = userService.Save(user);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK, null);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = userService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);

        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
