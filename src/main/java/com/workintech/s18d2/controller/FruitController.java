package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getByPriceAsc() {
        return ResponseEntity.ok(fruitService.getByPriceAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<Fruit>> getByPriceDesc() {
        return ResponseEntity.ok(fruitService.getByPriceDesc());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getById(@PathVariable Long id) {
        return ResponseEntity.ok(fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Fruit>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(fruitService.searchByName(name));
    }

    @PostMapping
    public ResponseEntity<Fruit> save(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.save(fruit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fruit> delete(@PathVariable Long id) {
        return ResponseEntity.ok(fruitService.delete(id));
    }
}