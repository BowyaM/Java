package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmpService;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String usn="postgres";
	private static String pswd="123";
	static Connection con;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,usn,pswd);
		}
		catch (ClassNotFoundException e) {
		
		} catch (SQLException e) {
			
		}
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		EmpService empservice=new EmpService();
		List<Employee> emp=empservice.fetch();
		PrintWriter out=res.getWriter();
		res.setContentType("text/html"); //This ensures the browser interprets the response as HTML.
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "	   <style>\r\n"
				+ "        th,td {\r\n"
				+ "            padding: 10px;\r\n"
				+ "        } \r\n"
				+ "        table, th, td {\r\n"
				+ "            border: 1px solid black;\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "    </style>"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class="+"container"+">\r\n"
				+ "        <h1>Employees Table </h1>\r\n"
				+ "        <table class="+"table"+">\r\n"
				+ "            <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                    <th> Id </th>\r\n"
				+ "                    <th> Name </th>\r\n"
				+ "                    <th> Age </th>\r\n"
				+ "                    <th> Salary </th>\r\n"
				+ "                    <th> Address </th>\r\n"
				+ "					   <th> Edit/Delete </th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "				<tbody>");
		for(Employee emps:emp) {
			int id=emps.getId();
			String name=emps.getName();
			int age=emps.getAge();
			int sal=emps.getSal();
			String address=emps.getAddress();
			out.print("              <tr>\r\n"
					+ "                    <td> " +id+ "</td>\r\n"
					+ "                    <td>" +name+ "</td>\r\n"
					+ "                    <td>" +age+ "</td>\r\n"
					+ "                    <td>" +sal+ "</td>\r\n"
					+ "                    <td>" +address+ "</td>\r\n"
					+ "                    <td>\r\n"
					+ "                        <a href="+"./EditPage.html"+"> Edit</a>\r\n"
					+ "                        <a href="+"./DeletePage.html"+"> Delete</a>\r\n"
					+ "                    </td>\r\n"
					+ "                </tr>\r\n"
					+ "            </tbody>");
		}
		
		out.print("        </table>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
	}	
}
