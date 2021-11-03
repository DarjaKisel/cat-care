package com.dzinevich.controller;

import com.dzinevich.model.Cat;
import com.dzinevich.repository.CatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cats")
public class CatsController {

    private final CatRepository catRepository;

    public CatsController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @GetMapping
    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable UUID id) {
        return catRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) throws URISyntaxException {
        Cat savedCat = catRepository.save(cat);
        return ResponseEntity
                .created(new URI("/cats/" + savedCat.getCatId()))
                .body(savedCat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cat> updateCat(@PathVariable UUID id, @RequestBody Cat cat) {
        Cat existingCat = catRepository.findById(id).orElseThrow(RuntimeException::new);
        Cat updatedCat = catRepository.save(existingCat.toBuilder()
                .name(cat.getName())
                .age(cat.getAge())
                .procedureList(cat.getProcedureList())
                .build());

        return ResponseEntity.ok(updatedCat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable UUID id) {
        catRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
