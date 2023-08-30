package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.transaction.Certification;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface CertificationService<T> extends GenericService<T> {
    public List<Certification> getMyCertification(int id);
}
