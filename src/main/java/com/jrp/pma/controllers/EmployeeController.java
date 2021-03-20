package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayEmployee(Model model) {
        List<Employee> employees = empService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/form")
    public String displayEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(@Valid @ModelAttribute("emp") Employee employee,
                                 BindingResult errors) {
        if (errors.hasErrors()){
            return "employees/new-employee";
        }

        empService.save(employee);

        return "redirect:/employee";
    }


    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") Long theId, Model model){
        Employee theEmp = empService.findByEmployeeId(theId);

        model.addAttribute("emp", theEmp);

        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long theId, Model model){
        Employee theEmp = empService.findByEmployeeId(theId);

        empService.delete(theEmp);

        return "redirect:/employee";
    }



}
