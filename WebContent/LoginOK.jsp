<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

</style>
<script type="text/javascript"></script>
</head>
<body>
<h1><%=request.getParameter("userName") %> 님 로그인 성공 !</h1>

<% 
	// 전달된 취미 출력하기
	Object obj = request.getAttribute("list");
	if(obj != null){
		List<String> hobbies = (List<String>)obj;
		%>
		<fieldset>
		<legend>취미 선택</legend>
		<%
		for(String h : hobbies){
			%>
			<input type="checkbox" name = "hobbies"  value="<%=h %>"/><%=h %>
			<%
		}
	}
	%>
	</fieldset>
	<%
%>
</body>
</html>