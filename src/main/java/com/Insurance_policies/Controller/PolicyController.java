package com.Insurance_policies.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Insurance_policies.model.policiesModel;
import com.Insurance_policies.service.policiesService;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {

	@Autowired
    private policiesService policyService;

    @PostMapping
    public ResponseEntity<policiesModel> create(@Valid @RequestBody policiesModel policy) {
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }
    @PutMapping("/{id}")
    public ResponseEntity<policiesModel> update(@PathVariable Long id, @Valid @RequestBody policiesModel policy) {
        return ResponseEntity.ok(policyService.updatePolicy(id, policy));
    }
    @GetMapping
    public ResponseEntity<List<policiesModel>> getAll() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<policiesModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }
}