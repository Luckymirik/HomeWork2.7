package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework27.entity.EmployeeBook;
import pro.sky.homework27.service.EmployeeBookServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookServiceImpl employeeBookServiceImpl;

    public EmployeeBookController(EmployeeBookServiceImpl employeeBookServiceImpl) {
        this.employeeBookServiceImpl = employeeBookServiceImpl;
    }
    @GetMapping("/add")
    public EmployeeBook add(@RequestParam String firstName, @RequestParam String lastName){
        return employeeBookServiceImpl.add(firstName,lastName);
    }
    @GetMapping("/remove")
    public EmployeeBook remove(@RequestParam String firstName, @RequestParam String lastName){
        return employeeBookServiceImpl.remove(firstName,lastName);
    }
    @GetMapping("/find")
    public EmployeeBook find(@RequestParam String firstName, @RequestParam String lastName){
        return employeeBookServiceImpl.find(firstName,lastName);
    }
    @GetMapping
    public Collection<EmployeeBook> findAll(){
        return employeeBookServiceImpl.findAll();

    }

}
