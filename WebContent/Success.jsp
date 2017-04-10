<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Crime.Profile"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success!!</title>
</head>
<body>
<h1>  Hello ! You are Successfully Registered </h1>
<%
	Profile p=(Profile)request.getAttribute("Profile");
%>
<h1>ID:<%=p.getId()%> </h1>
<h1>PASSWORD:<%=p.getPassword()%> </h1>
</body>
</html>