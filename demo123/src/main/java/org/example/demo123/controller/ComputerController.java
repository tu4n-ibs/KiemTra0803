package org.example.demo123.controller;

import org.example.demo123.model.Computer;
import org.example.demo123.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {
    @Autowired
    private IComputerService iComputerService;

    @GetMapping
    public ResponseEntity findAllComputer() {
        List<Computer> blogList = (List<Computer>) iComputerService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findBlogById(@PathVariable int id) {
        Optional<Computer> blogOptional = iComputerService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBlog(@RequestBody Computer computer) {
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Computer> blogOptional = iComputerService.findById(id);
        iComputerService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Computer computer) {
        Optional<Computer> blogOptional = iComputerService.findById(id);
        computer.setId(blogOptional.get().getId());
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity findByName(@RequestParam String name) {
        List<Computer> computers = iComputerService.findAllByNameContains(name);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/findByBrand")
    public ResponseEntity findByBrand(@RequestParam String brand) {
        List<Computer> computers = iComputerService.findAllByBrandContains(brand);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/findByBrand")
    public ResponseEntity findByKind(@RequestParam String kind) {
        List<Computer> computers = iComputerService.findAllByKindContains(kind);
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }
}

