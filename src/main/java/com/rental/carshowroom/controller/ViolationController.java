package com.rental.carshowroom.controller;

import com.rental.carshowroom.model.Violation;
import com.rental.carshowroom.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/violation")
public class ViolationController {

    private ViolationService violationService;

    @Autowired
    public ViolationController(ViolationService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Violation> addViolationForUser(@RequestBody @Valid Violation violation) {
        return ResponseEntity.ok(violationService.addViolationForUser(violation));
    }

}
