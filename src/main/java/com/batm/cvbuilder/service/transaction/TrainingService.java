package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.transaction.Training;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface TrainingService<T> extends GenericService<T> {
    public List<Training> getMyTrainings(int id);
}
