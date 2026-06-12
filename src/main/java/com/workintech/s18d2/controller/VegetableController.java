package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public ResponseEntity<List<Vegetable>> getByPriceAsc() {
        return ResponseEntity.ok(vegetableService.getByPriceAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<Vegetable>> getByPriceDesc() {
        return ResponseEntity.ok(vegetableService.getByPriceDesc());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vegetableService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Vegetable>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(vegetableService.searchByName(name));
    }

    @PostMapping
    public ResponseEntity<Vegetable> save(@RequestBody Vegetable vegetable) {
        return ResponseEntity.ok(vegetableService.save(vegetable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vegetable> delete(@PathVariable Long id) {
        return ResponseEntity.ok(vegetableService.delete(id));
    }
}