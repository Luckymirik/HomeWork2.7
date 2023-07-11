package pro.sky.homework27.service;

import pro.sky.homework27.entity.EmployeeBook;

import java.util.Collection;

public interface EmployeeBookService {
    EmployeeBook add(String firstName, String lastName);

    EmployeeBook remove(String firstname, String lastname);

    EmployeeBook find(String firstName, String lastName);

    Collection<EmployeeBook> findAll();
}
