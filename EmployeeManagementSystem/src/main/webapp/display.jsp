<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.Entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	h2{
	text-align: center; 
	margin-bottom: 20px;
	}
	table {
	width: 50%;
	border-collapse: collapse; 
	margin: 10px auto;
	}
	.actions {
    text-align: center; 
    margin-top: 20px; /* Space between table and buttons */
    font-weight: bold;
    }
    th, td {
    border: 1px solid black; padding: 10px; text-align: left; 
    }
    th {
    background-color: #f2f2f2;
    }
</style>
</head>
<body>
	<h2>Employees List</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th>Address</th>
    </tr>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees != null && !employees.isEmpty()) {
            for (Employee emp : employees) {
    %>
    <tr>
        <td><%= emp.getId() %></td>
        <td><%= emp.getName() %></td>
        <td><%= emp.getAge() %></td>
        <td><%= emp.getSal() %></td>
        <td><%= emp.getAddress() %></td>
        
    </tr>
    <% 
           }
        }
        else {
    %>
     <tr>
        <td colspan="5" style="text-align: center;">No employees found.</td>
    </tr>
    <% } %>
</table>
<div class="actions">
<a href="./EditPage.html">Edit </a>
<a href="./DeletePage.html">/Delete </a>
</div>
</body>
</html>