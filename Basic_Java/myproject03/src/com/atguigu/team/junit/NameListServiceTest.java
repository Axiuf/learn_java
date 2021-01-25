package com.atguigu.team.junit;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * 对建好的NameList类的测试
 */

public class NameListServiceTest
{
    @Test
    public void testGetAllEmployees()
    {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i]);
    }

    @Test
    public void testGetEmployee()
    {
        NameListService serviceervice = new NameListService();
        int id;
        id = 101;

        try
        {
            Employee employee = serviceervice.getEmployee(id);
            System.out.println(employee);
        }
        catch (TeamException e)
        {
            System.out.println(e.getMessage());
        }
    }
}