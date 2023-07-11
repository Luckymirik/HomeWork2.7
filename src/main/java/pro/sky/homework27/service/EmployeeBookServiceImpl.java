package pro.sky.homework27.service;

import org.springframework.stereotype.Service;
import pro.sky.homework27.entity.EmployeeBook;
import pro.sky.homework27.exception.EmployeeAlreadyAddedException;
import pro.sky.homework27.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    private final Map<String , EmployeeBook> employees;

    public EmployeeBookServiceImpl() {
        this.employees = new HashMap<>() ;
    }
    @Override
    public EmployeeBook add(String firstName, String lastName){
        EmployeeBook employeeBook = new EmployeeBook(firstName,lastName);
        if (employees.containsKey(employeeBook.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeBook.getFullName(),employeeBook);
                return employeeBook;
    }
    @Override
    public EmployeeBook remove(String firstName, String lastName){
        EmployeeBook employeeBook = new EmployeeBook(firstName,lastName);
        if(employees.containsKey(employeeBook.getFullName())){
          return employees.remove(employeeBook.getFullName());

        }
throw new EmployeeNotFoundException();

    }
    @Override
    public EmployeeBook find(String firstName,String lastName){
        EmployeeBook employeeBook = new EmployeeBook(firstName,lastName);
        if (employees.containsKey(employeeBook.getFullName())){
            return employees.get(employeeBook.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection <EmployeeBook>findAll() {
        return Collections.unmodifiableCollection(employees.values());

    }

}
