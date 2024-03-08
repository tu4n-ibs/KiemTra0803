package org.example.kiemtra.service;

import org.example.kiemtra.model.Employee;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    List<Employee> findAllByNameContains(String name);
    List<Employee> findAllBySalaryBetween(double salary1, double salary2);
    List<Employee> findAllByAddressContains(String address);
    List<Employee> findAllByAge(int age);
}
