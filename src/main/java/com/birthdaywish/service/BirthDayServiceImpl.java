package com.birthdaywish.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.birthdaywish.model.Employee;

@Service
public class BirthDayServiceImpl implements BirthDayService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private final List<Employee> employees = new ArrayList<>();
	
	public BirthDayServiceImpl() {
		
		
		employees.add(new Employee("John Doe", "2000-09-05"));
		employees.add(new Employee("Alice Smith", "2001-05-15"));
        
    }

	@Override
	public void sendBirthdayWishes(Employee employee) {
		 String recipientEmail = "souravkarmakarsimlapal@gmail.com";

	        // Create a MimeMessage
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        try {
	            // Set email properties
	        	
	            helper.setTo(recipientEmail);
	            helper.setSubject("Happy Birthday!");
	            helper.setText("Dear " + employee.getName() + ",\n\nHappy Birthday! Have a fantastic day!");

	            // Send the email
	            javaMailSender.send(message);
	            
	            System.out.println("Birthday wishes sent via email to " + recipientEmail);
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            System.out.println("Failed to send birthday wishes via email to " + recipientEmail);
	        }
		
	}
	
	@Scheduled(cron = "0 0 8 * * ?") // Runs daily at 8:00 AM
    public void sendScheduledBirthdayWishes() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        
		
		for (Employee employee : employees) {
            LocalDate birthday = LocalDate.parse(employee.getBirthday(), formatter);
            if (isSameMonthAndDay(birthday, today)) {
                sendBirthdayWishes(employee);
            }
        }
    }

	private boolean isSameMonthAndDay(LocalDate birthday, LocalDate today) {
		return birthday.getMonth() == today.getMonth() && birthday.getDayOfMonth() == today.getDayOfMonth();
	}

}
