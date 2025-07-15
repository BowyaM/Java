package com.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmpService extends HttpServlet {
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction et;
	
	static {
		emf=Persistence.createEntityManagerFactory("bowya");
		em=emf.createEntityManager();
		et=em.getTransaction();
	}
	
	public void save(Employee emp) {
		et.begin();
		em.persist(emp);
		et.commit();
	}
	
	public List<Employee> fetch() {
		Query query=em.createQuery("from Employee");
		List<Employee>emps=query.getResultList();
		return emps;
	}
	
	public Employee update(Employee emp) {
		Employee e1=em.find(Employee.class, emp.getId());
		if(e1!=null) {
			e1.setName(emp.getName());
			e1.setAge(emp.getAge());
			e1.setSal(emp.getSal());
			e1.setAddress(emp.getAddress());
			
			et.begin();
			em.merge(e1);
			et.commit();
		}
		return e1;
	}
	
	public Employee delete(Employee emp) {
		Employee e1=em.find(Employee.class, emp.getId());
		if(e1!=null) {
			et.begin();
			em.remove(e1);
			et.commit();
		}
		return e1;
	}
}
