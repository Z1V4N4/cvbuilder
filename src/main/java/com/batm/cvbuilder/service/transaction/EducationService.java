package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.transaction.Education;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface EducationService<T> extends GenericService<T> {
    public List<Education> getMyEducations(int id);
}
