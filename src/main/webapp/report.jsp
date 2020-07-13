<%@page import="model.dependentsmodel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.employee"%>
<%@page import="model.works_on"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>

body{
    background: #eee;
 
    margin: 0 auto;
}
.wrapper{
    margin: 80px;
}
.form-signin{
    max-width: 380px;
    margin:0 auto;
}
</style>
</head>
<body>
<form action="reportservlet" class="form-signin" method="post">
<% 
  employee e1 =(employee) session.getAttribute("e1");
ArrayList<works_on> wlist = (ArrayList<works_on>) session.getAttribute("wlist");
ArrayList<dependentsmodel> dlist = (ArrayList<dependentsmodel>) session.getAttribute("dlist");
	out.println("<h3>employee:</h3>");
	out.println(e1);
	out.println("<br>");
	out.println("<h3>projects assigned:</h3>");
	for (works_on w : wlist){
		out.println(w);
		out.println("<br>");
	}
	out.println("<h3>dependents (if any):</h3>");
	for (dependentsmodel d:dlist){
		out.println(d);
		out.println("<br>");
	}
%>
<button class="btn btn-lag btn-primary btn-block" type="submit">confirm</button>
</form>
</body>
</html>