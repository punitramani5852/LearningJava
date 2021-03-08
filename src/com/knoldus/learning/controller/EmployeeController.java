package com.knoldus.learning.controller;

import com.knoldus.learning.entity.Employee;
import com.knoldus.learning.service.*;

import java.io.FileNotFoundException;
import java.util.List;

public class EmployeeController {

    public static void main(String[] a) throws FileNotFoundException{
        ValidateEmployeeService validateEmployeeService = new ValidateEmployeeServiceImpl();
        SaveEmployeeService saveEmployeeService = new SaveEnployeeServiceImpl();

        ReadEmployeeData readEmployeeData=new ReadEmployeeDataImpl();

        List<Employee> EmpList = readEmployeeData.readDataFromDatabase();

        System.out.println("Total employee size  :  "+EmpList.size());

        for (Employee e : EmpList) {
            if(validateEmployeeService.validateEmployee(e))
                saveEmployeeService.saveEmployee(e);
        }

        System.out.println("Saved employee count: "+saveEmployeeService.getEmployeeCount());

    }
}
