package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmpService;

@WebServlet("/delete")
public class DeleteEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id")) ;
		EmpService empservice =new EmpService();
		int deletedEmp=empservice.delete(new Employee(id));
		PrintWriter out=resp.getWriter();
		if(deletedEmp!=0) {
			RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");
			rd.include(req, resp);
		}
		else {
			out.println("Mentioned Id is not available");
		}
	}
	
}
