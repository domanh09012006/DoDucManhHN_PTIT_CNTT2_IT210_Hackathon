package org.example.hackathon.service;

import org.example.hackathon.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {

    private List<Employee> employees = new ArrayList<>();

    public EmpService() {
        employees.add(new Employee("NV001", "Nguyễn Văn A", "Developer", 1000.0, "avatar1.jpg"));
        employees.add(new Employee("NV002", "Trần Thị B", "Tester", 2000.0, "avatar2.jpg"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public boolean save(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                return true;
            }
        }
        return employees.add(employee);
    }

    public boolean delete(String id) {
        return employees.removeIf(employee -> employee.getId().equals(id));
    }
}