package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.repository.master.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> Get() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> Get(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Boolean Save(Employee model) {
        employeeRepository.save(model);
        return employeeRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.findById(id).isPresent();
    }

}
