package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Animal;
import com.example.demo.repository.AnimalRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public Animal createAnimal(@Valid @RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal animalDetails) {
    	Animal animal = animalRepository.findById(id)
        		.orElseThrow(); 

        animal.setNome(animalDetails.getNome());
        animal.setEspecie(animalDetails.getEspecie());
        animal.setRaca(animalDetails.getRaca());
        animal.setIdade(animalDetails.getIdade());
    	animal.setEndereco(animalDetails.getEndereco());
        animal.setDescricao(animalDetails.getDescricao());
    	

        Animal updatedAnimal = animalRepository.save(animal);
        return updatedAnimal;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable(value = "id") Long animalId) {
    	Animal animal = animalRepository.findById(animalId)
        		.orElseThrow(); 
        if (animal == null) {
            return ResponseEntity.notFound().build();
        }

        animalRepository.delete(animal);
        return ResponseEntity.ok().build();
    }
}