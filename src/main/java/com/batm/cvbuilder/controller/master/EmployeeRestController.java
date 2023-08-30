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
import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.service.master.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("employee")
    public ResponseEntity<Object> Get() {
        List<Employee> employees = employeeService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, employees);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Employee> employee = employeeService.Get(id);
        if (employee.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, employee);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("employee")
    public ResponseEntity<Object> Save(@RequestBody Employee employee) {
        boolean result = employeeService.Save(employee);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK, null);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = employeeService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);

        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
