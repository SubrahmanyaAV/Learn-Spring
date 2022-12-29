<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Page</title>
</head>
<body>

	<h1>Student Page</h1>

	<form:form action="student.html" method="post">
		<label>Student rollno</label>
		<form:input path="rollno" />
		<br/>
		<label>Student name</label>
		<form:input path="name" />
		<br/>
		<input type="submit" value="Create" /> 
	

	</form:form>

	<h1>Student List</h1>

	<table border="1">

		<thead>
			<tr>
				<td>Rollno </td>
				<td> Name</td>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${STUDENTLIST}" var="s">
				<tr>
					<td><c:out value="${s.rollno}"></c:out></td>
					<td><c:out value="${s.name}"></c:out></td>
					<td><a href="<c:url value='/student-edit-${s.rollno}' />" >Edit</a></td>
          			<td><a href="<c:url value='/student-del-${s.rollno}' />" >Delete</a></td>
 				</tr>
				
			</c:forEach>

		</tbody>
	</table>
	
</body>
</html>