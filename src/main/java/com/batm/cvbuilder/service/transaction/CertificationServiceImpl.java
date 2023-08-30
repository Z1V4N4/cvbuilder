package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Certification;
import com.batm.cvbuilder.repository.transaction.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService<Certification> {

    @Autowired
    public CertificationRepository certificationRepository;

    @Override
    public List<Certification> Get() {
        return certificationRepository.findAll();
    }

    @Override
    public Optional<Certification> Get(int id) {
        return certificationRepository.findById(id);
    }

    @Override
    public Boolean Save(Certification model) {
        certificationRepository.save(model);
        return certificationRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        certificationRepository.deleteById(id);
        return !certificationRepository.findById(id).isPresent();
    }

    @Override
    public List<Certification> getMyCertification(int id) {
        Employee employee = new Employee(id);
        return certificationRepository.getMyCertifications(employee);
    }

}
