package ru.savin.spring.rest.dao;

import ru.savin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getAllEmployees(int id);

    public void deleteEmployee(int id);
}
