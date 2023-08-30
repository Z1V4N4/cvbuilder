package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.repository.master.ToolRepository;

@Service
public class ToolServiceImpl implements ToolService<Tool> {

    @Autowired
    public ToolRepository toolRepository;

    @Override
    public List<Tool> Get() {
        return toolRepository.findAll();
    }

    @Override
    public Optional<Tool> Get(int id) {
        return toolRepository.findById(id);
    }

    @Override
    public Boolean Save(Tool model) {
        toolRepository.save(model);
        return toolRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        toolRepository.deleteById(id);
        return !toolRepository.findById(id).isPresent();
    }

}
