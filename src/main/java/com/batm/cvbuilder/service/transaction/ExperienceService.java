package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.transaction.Experience;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface ExperienceService<T> extends GenericService<T> {
    public List<Experience> getMyExperiences(int id);
}
