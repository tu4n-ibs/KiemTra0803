package org.example.kiemtra.service;

import org.example.kiemtra.model.Employee;
import org.example.kiemtra.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByNameContains(String name) {
        return iEmployeeRepository.findAllByNameContains(name);
    }

    @Override
    public List<Employee> findAllBySalaryBetween(double salary1, double salary2) {
        return iEmployeeRepository.findAllBySalaryBetween(salary1,salary2);
    }

    @Override
    public List<Employee> findAllByAddressContains(String address) {
        return iEmployeeRepository.findAllByAddressContains(address);
    }

    @Override
    public List<Employee> findAllByAge(int age) {
        return iEmployeeRepository.findAllByAge(age);
    }
}
