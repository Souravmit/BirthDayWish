package com.birthdaywish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.birthdaywish.model.Employee;
import com.birthdaywish.service.BirthDayService;



@Controller
public class BirthDayWish {
	
	@Autowired
	private BirthDayService birthDayService;
	
	
	
	public String sendBirthdayWishes(Model model) {
		
        // Fetch Employee and send birthday wishes
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setBirthday("2000-09-05");
        birthDayService.sendBirthdayWishes(employee);
        
    

        // Add employee data to the view
        model.addAttribute("employee", employee);

        return "BirthDay";
    }

}
