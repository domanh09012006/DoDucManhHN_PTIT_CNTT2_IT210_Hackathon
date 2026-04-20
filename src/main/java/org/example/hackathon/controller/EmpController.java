package org.example.hackathon.controller;

import org.example.hackathon.model.Employee;
import org.example.hackathon.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", empService.findAll());
        return "detail";
    }

    @GetMapping("/add")
    public String viewAdd(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("action", "add");
        return "add-employee";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", empService.findById(id));
        model.addAttribute("action", "edit");
        return "add-employee";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        empService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        empService.delete(id);
        return "redirect:/employees";
    }
}