package org.example.demo123.repository;

import org.example.demo123.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComputerRepository extends JpaRepository<Computer,Integer> {
    List<Computer> findAllByNameContains(String name);
    List<Computer> findAllByBrandContains(String brand);
    List<Computer> findAllByKindContains(String kind);
}
