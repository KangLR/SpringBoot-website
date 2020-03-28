package com.kang.springboot.controller;

import com.kang.springboot.dao.DepartmentDao;
import com.kang.springboot.dao.EmployeeDao;
import com.kang.springboot.pojo.Department;
import com.kang.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author klr
 * @create 2020-03-27-17:48
 */
@Controller
public class EmplyeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;


    //获取全部的员工
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        System.out.println(employees);
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加员工
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        employeeDao.save(employee);//调用底层业务方法保存员工
        return "redirect:/emps";
    }
//    restful风格接收
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model
    ){
        //查出原来的数据
        System.out.println(id);
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    //删除员工
    @GetMapping("/emp/delete/{id}")
    public String delete(@PathVariable("id")int id){
        employeeDao.delete(id);
    return "redirect:/emps";
    }

}
