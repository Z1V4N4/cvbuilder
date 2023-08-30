package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface ToolsService<T> extends GenericService<T> {
    public List<Tool> getMyTools(int id);
}
