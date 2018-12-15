<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload='document.f.username.focus();'>
	<h2>Login</h2>
	<c:if test="${not empty logoutMsg}">
		<div style="color: #0000ff">
			<h3>${logoutMsg }</h3>
		</div>
	</c:if>

	<form name='f' method="POST" action="<c:url value="/login"/>">
		<c:if test="${not empty errorMsg}">
			<div style="color: #ff0000">
				<h3>${errorMsg }</h3>
			</div>
		</c:if>
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" type="submit" value="Login"></td>
			</tr>
			<input name="${_csrf.parameterName }" type="hidden"
				value="${_csrf.token }" />
		</table>


	</form>
</body>
</html>