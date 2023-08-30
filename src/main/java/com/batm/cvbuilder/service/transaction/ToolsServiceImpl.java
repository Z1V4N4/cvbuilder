package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.model.transaction.Tools;
import com.batm.cvbuilder.repository.transaction.ToolsRepository;

@Service
public class ToolsServiceImpl implements ToolsService<Tools> {

    @Autowired
    public ToolsRepository toolsRepository;

    @Override
    public List<Tools> Get() {
        return toolsRepository.findAll();
    }

    @Override
    public Optional<Tools> Get(int id) {
        return toolsRepository.findById(id);
    }

    @Override
    public Boolean Save(Tools model) {
        toolsRepository.save(model);
        return toolsRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        toolsRepository.deleteById(id);
        return !toolsRepository.findById(id).isPresent();
    }

    @Override
    public List<Tool> getMyTools(int id) {
        Employee employee = new Employee(id);
        return toolsRepository.getMyTools(employee);
    }
}
