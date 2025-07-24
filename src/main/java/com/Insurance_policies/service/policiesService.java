package com.Insurance_policies.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance_policies.model.policiesModel;
import com.Insurance_policies.repository.PolicyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class policiesService {
	@Autowired
    private PolicyRepository policyRepository;
    public policiesModel createPolicy(policiesModel policy) {
        return policyRepository.save(policy);
    }
    public policiesModel updatePolicy(Long id, policiesModel policy) {
    	policiesModel existing = policyRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Policy not found"));
        existing.setHolderName(policy.getHolderName());
        existing.setType(policy.getType());
        existing.setStartDate(policy.getStartDate());
        existing.setEndDate(policy.getEndDate());
        existing.setPremiumAmount(policy.getPremiumAmount());
        return policyRepository.save(existing);
    }
    public List<policiesModel> getAllPolicies() {
        return policyRepository.findAll();
    }
    public policiesModel getPolicyById(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Policy not found"));
    }
}