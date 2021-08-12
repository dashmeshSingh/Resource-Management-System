package com.codekul.controller;

import com.codekul.entities.Employee;
import com.codekul.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path="/hrms")
    public class AddEmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @GetMapping("/getemployee")
        public List<Employee> getEmployees()
        {
            return this.employeeService.getEmployees();

        }

        //Check the employee id
        @GetMapping("/getemployee/{employeeId}")
        public Employee getEmployee(@PathVariable String employeeId)
        {
            return this.employeeService.getEmployee(Integer.parseInt(employeeId));
        }

        //add the employee
        @PostMapping(path="/addemployee",consumes="application/json")
        public Employee addEmployee(@RequestBody Employee employee)
        {
            return this.employeeService.addEmployee(employee);
        }
}
