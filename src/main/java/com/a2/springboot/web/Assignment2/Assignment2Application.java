package com.a2.springboot.web.Assignment2;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.Data.Staff;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.StaffService;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
		Session session= SessionUtil.getSessionFactory().getCurrentSession();








	}

}
