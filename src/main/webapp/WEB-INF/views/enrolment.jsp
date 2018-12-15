<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h3>2019년 1학기 수강신청</h3>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doEnrolment" modelAttribute="course">

		<table>
			<tr>
				<td>강좌명:</td>
				<td><sf:input type="text" path="name"/>
					<sf:errors path="name" class="error"/></td>
			</tr>
			<tr>
				<td>과목코드:</td>
				<td><sf:input type="text" path="code"/>
				<sf:errors path="code" class="error"/></td>
			</tr>
			<tr>
				<td>구분:</td>
				<td><sf:input type="text" path="classify"/></td>
			</tr>
			<tr>
				<td>학점:</td>
				<td><sf:input type="number" path="credit"/>
				<sf:errors path="credit" class="error"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수강신청하기"></td>
			</tr>

		</table>




	</sf:form>

</body>
</html>