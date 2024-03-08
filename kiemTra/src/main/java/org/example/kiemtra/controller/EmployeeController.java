package org.example.kiemtra.controller;

import org.example.kiemtra.model.Employee;
import org.example.kiemtra.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping
    public ResponseEntity findAllBlog() {
        List<Employee> blogList = (List<Employee>) iEmployeeService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findBlogById(@PathVariable int id) {
        Optional<Employee> blogOptional = iEmployeeService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBlog(@RequestBody Employee employee) {
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Employee> blogOptional = iEmployeeService.findById(id);
        iEmployeeService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> blogOptional = iEmployeeService.findById(id);
        employee.setId(blogOptional.get().getId());
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity findByName(@RequestParam String name) {
        List<Employee> blogList = iEmployeeService.findAllByNameContains(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/findBySalary")
    public ResponseEntity findBySalary(@RequestParam double salary1, @RequestParam double salary2) {
        List<Employee> employees = iEmployeeService.findAllBySalaryBetween(salary1, salary2);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/findByAddress")
    public ResponseEntity findByAddress(@RequestParam String address) {
        List<Employee> employees = iEmployeeService.findAllByAddressContains(address);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/findByAge")
    public ResponseEntity findByAge(@RequestParam int age) {
        List<Employee> employees = iEmployeeService.findAllByAge(age);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
