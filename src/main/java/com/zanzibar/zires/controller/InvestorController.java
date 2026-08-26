package com.zanzibar.zires.controller;

import com.zanzibar.zires.entity.Investor;
import com.zanzibar.zires.service.InvestorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
@CrossOrigin(origins = "*")
public class InvestorController {

    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        return ResponseEntity.ok(investorService.createInvestor(investor));
    }

    @GetMapping
    public ResponseEntity<List<Investor>> getAllInvestors() {
        return ResponseEntity.ok(investorService.getAllInvestors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {

        return investorService.getInvestorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investor> updateInvestor(
            @PathVariable Long id,
            @RequestBody Investor investor) {

        return ResponseEntity.ok(
                investorService.updateInvestor(id, investor)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestor(@PathVariable Long id) {

        investorService.deleteInvestor(id);

        return ResponseEntity.noContent().build();
    }
}