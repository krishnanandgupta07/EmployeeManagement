<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<script type="text/javascript"  src="js/Validation.js">

</script>
<h1 style="color:red;text-align: center;">Update Employee</h1>
<frm:form modelAttribute="emp"  onsubmit="return doValidation(this)">
	<%-- <p style="color:red; text-align=center"> 
		 <frm:errors path="*"/>
	</p> --%>
	<table align="center" bgcolor="cyan">
	
	<tr>
		<td>Employee Number::</td>
		<td><frm:input path="empno" readonly="true"/></td>
	</tr>
	<tr>
		<td>Employee Name::</td>
		<td><frm:input path="ename"/><frm:errors path="ename" style="color:red"/><span id="enameErr" style="color:red"/></td>
	</tr>
	<tr>
		<td>Employee Designation::</td>
		<td><frm:input path="job"/><frm:errors path="job" style="color:red"/><span id="jobErr" style="color:red"/></td>
	</tr>
	<tr>
		<td>Employee Salary::</td>
		<td><frm:input path="sal"/><frm:errors path="sal" style="color:red"/><span id="salErr" style="color:red"/></td>
	</tr>
	<tr>
		<td>Employee DeptNo::</td>
		<td><frm:input path="deptno"/><frm:errors path="deptno" style="color:red"/><span id="deptnoErr" style="color:red"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Update Employee"></td>
		<td><input type="reset" value="cancel"></td>
	</tr>
	</table>
	
	<frm:hidden path="csvStatus"/>
</frm:form>