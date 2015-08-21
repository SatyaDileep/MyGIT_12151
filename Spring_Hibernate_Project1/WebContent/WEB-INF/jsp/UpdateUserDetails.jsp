<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Hibernate | Registration Form</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Spring-Hibernate | Registration Form</div>
<br><br>
<c:if test="${!empty userModel.user}">
<c:url var="updateUserDetails" value="updateUser.html"/>
<form:form id="updateForm" modelAttribute="updatedUserDetails" method="post" action="${updateUserDetails}">
<c:forEach items="${userModel.user}" var="user">
<table width="400px" height="150px">
<tr>
<td><input type= "hidden" name = "id" value = "${user.id }"/></td>
</tr>
<tr>
<td><label>First Name</label></td>
<td><input type = "text" name="firstName" value = "${user.firstName }"/></td>
</tr>
<tr>
<td><label>Last Name</label></td>
<td><input type = "text" name="lastName" value = "${user.lastName }"/></td>
</tr>
<tr>
<td><label>College Id Number</label></td>
<td><input type = "text"  name="collegeIdNumber" value = "${user.collegeIdNumber }"/></td>
</tr>
<tr>
<td><label>Age</label></td>
<td><input type = "text" name="age" value = "${user.age }"/></td>
</tr>
<tr>
<td><label>Gender</label></td>
<td><input type="radio" name="gender" value="Male" ${user.gender=='Male'?'checked':'true'}>Male
<input type="radio" name="gender" value="Female" ${user.gender=='Female'?'checked':'true'}>Female
</tr>
<tr>
<td><label>City</label></td>
<td>
	<select name="city">
		<c:forEach items="${userModel.cityList}" var="cityList">
  			<option  ${cityList == user.city ? 'selected' : '' }>${cityList}</option>
  		</c:forEach>
  	</select>
  	
  
	</td>
</tr>
<tr><td></td><td>
<input type="submit" value="Update" />
</td></tr>
</table>
</c:forEach>
</form:form>
</c:if>
<br>
<a href="userList.html" >Click Here to see User List</a>
</center>
</body>
</html>