<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color: red; text-align: center;">Report Page</h1>

<c:choose>
	<c:when test="${!empty empList }">
		<table border="1" align="center" bgcolor="yellow">
			<tr><th>empno</th><th>ename</th><th>job</th><th>sal</th><th>deptno</th><th>Operations</th> </tr>
		
		<c:forEach var="emp" items="${empList}">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.sal}</td>
			<td>${emp.deptno}</td>
			<td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.jpeg" width="30px" height="30px"></a>
			&nbsp;&nbsp;<a href="emp_delete?no=${emp.empno}" onclick="return confirm('Sure ! Do You Want To Delete')"><img src="images/delete.png" width="30px" height="30px"></a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: cyan;text-align: center;">No Record Found</h1>
		</c:otherwise>
</c:choose>
	<center><h1 style="color:maroon">${resultMsg}</h1>
<br><br>
<h1 style="text-align: center;"><a href="./">Home<img src="images/home.png" width="50px",height="50px"></a></h1>
<h1 style="text-align: center;"><a href="emp_add">Add Employees<img src="images/add.png" width="50px",height="50px"></a></h1>
