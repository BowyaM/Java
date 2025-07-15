package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.Employee;
import com.Service.EmpService;

@WebServlet("/edit")
public class EditEmp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	PrintWriter out=resp.getWriter();
    	int id=Integer.parseInt(req.getParameter("id")) ;
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		int sal=Integer.parseInt(req.getParameter("sal"));
		String address=req.getParameter("addr");
		
		EmpService empservice=new EmpService();
		Employee emp=new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setAge(age);
		emp.setSal(sal);
		emp.setAddress(address);
		
		Employee updEmp=empservice.update(emp);
		if(updEmp!=null) {
		RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");
		rd.include(req, resp);
		}
		else
			out.println("<h1> Something went wrong!! </h1>");
			
    }
}



