package org.example.demo123.service;

import org.example.demo123.model.Computer;

import java.util.List;

public interface IComputerService extends IGeneralService<Computer> {
    List<Computer> findAllByNameContains(String name);
    List<Computer> findAllByBrandContains(String brand);
    List<Computer> findAllByKindContains(String kind);
}
