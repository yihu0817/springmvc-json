package com.warmtel.springmvc.json01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warmtel.springmvc.json01.model.Employee;
import com.warmtel.springmvc.json01.model.Message;

@Controller
public class EmpoyeeController {
	/**
	 * XML配置实现
	 * @param mm
	 * @return
	 */
	@RequestMapping(value = "/showEmployeeByJson")
	public String showUserListInJson(Model mm) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("张三");
		employee1.setAge(23);
		employee1.setSalary("2300");
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("李四");
		employee2.setAge(23);
		employee2.setSalary("4300");
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		mm.addAttribute("userList", employeeList);
		mm.addAttribute("School","SuZhou");
		mm.addAttribute("Work","YanFa");
		
		return "userListJson";
	}
	/**
	 *  注解实现@ResponseBody
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getEmployeeByJson", method = RequestMethod.GET)
	public  Employee getEmployeeInJSON() {
		System.out.println("-----请求json数据--------");
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("张三");
		employee.setAge(23);
		employee.setSalary("2300");
 
		return employee;
	}
	/**
	 * 注解实现@ResponseBody
	 * 
	 * {"code":100,
	 *  "description":"请求成功",
	 *  "lists":
	 *    [
	 *      {"id":1,"name":"张三","salary":"2300","age":23},
	 *      {"id":2,"name":"李四","salary":"4300","age":23}
	 *    ]
	 * }
	 * @param mm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showEmployee")
	public Message  showUserList(Model mm) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("张三");
		employee1.setAge(23);
		employee1.setSalary("2300");
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("李四");
		employee2.setAge(23);
		employee2.setSalary("4300");
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		Message message = new Message();
		message.setCode(100);
		message.setDescription("请求成功");
		message.setLists(employeeList);
		
		return message;
	}
}
