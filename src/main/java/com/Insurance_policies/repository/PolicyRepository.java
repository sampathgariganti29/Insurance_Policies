package com.Insurance_policies.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Insurance_policies.model.policiesModel;

public interface PolicyRepository extends JpaRepository<policiesModel, Long> {
}