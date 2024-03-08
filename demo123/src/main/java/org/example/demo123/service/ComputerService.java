package org.example.demo123.service;


import org.example.demo123.model.Computer;
import org.example.demo123.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepository iComputerRepository;
    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(int id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);
    }

    @Override
    public void remove(int id) {
        iComputerRepository.deleteById(id);
    }

    @Override
    public List<Computer> findAllByNameContains(String name) {
        return iComputerRepository.findAllByNameContains(name);
    }

    @Override
    public List<Computer> findAllByBrandContains(String brand) {
        return iComputerRepository.findAllByBrandContains(brand);
    }

    @Override
    public List<Computer> findAllByKindContains(String kind) {
        return iComputerRepository.findAllByKindContains(kind);
    }
}
