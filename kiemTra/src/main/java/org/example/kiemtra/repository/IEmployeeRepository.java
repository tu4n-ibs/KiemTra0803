package org.example.kiemtra.repository;

import org.example.kiemtra.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByNameContains(String name);
    List<Employee> findAllBySalaryBetween(double salary1, double salary2);
    List<Employee> findAllByAddressContains(String address);
    List<Employee> findAllByAge(int age);
}
