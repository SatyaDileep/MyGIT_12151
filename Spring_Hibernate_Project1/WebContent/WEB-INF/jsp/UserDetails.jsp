<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Hibernate | User Details</title>

</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Spring-Hibernate | User Details</div>
<br><br>
<c:if test="${!empty user}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: teal;color: white;text-align: center;" height="40px">
<td>User Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>College Id</td>
<td>Gender</td>
<td>City</td>
<td>Age</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<c:forEach items="${user}" var="user">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.firstName}"/></td>
<td><c:out value="${user.lastName}"/></td>
<td><c:out value="${user.collegeIdNumber}"/></td>
<td><c:out value="${user.gender}"/></td>
<td><c:out value="${user.city}"/></td>
<td><c:out value="${user.age}"/></td>
<td><a href = "editUser.html?collegeIdNumber=${user.collegeIdNumber}">Edit</a></td>
<td><a href = "deleteUser.html?collegeIdNumber=${user.collegeIdNumber}">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<a href="register.html" >Click Here to add new User</a>
</center>
</body>
</html>