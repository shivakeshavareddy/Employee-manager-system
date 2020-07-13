<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="wrapper">
    <form action="dependentservlet" class="form-signin" method="post">
    <% int dependentnum= Integer.parseInt(request.getParameter("depenedentnum"));
    	out.println("<p id=\"dependentnum\" value="+dependentnum+"> </p>");
    %>
        <table>
            <%
             for (int j =0; j<dependentnum;j++){
            	 out.println(" <tr> <td>dependent name</td> <td><input class=\"form-control\" type=\"text\" maxlength=\"15\" required name=\"dependentname\"></td> </tr><tr><td>dependent sex</td> <td><input type=\"radio\" required name=\"dependentsex\" value=\"M\">male</td><td><input type=\"radio\" name=\"dependentsex\" value=\"F\">female</td></tr><tr><td>dependent birthdate</td><td><input  type=\"date\" name=\"dependentbdate\"></td></tr><tr><td>dependent relationship</td><td><input class=\"form-control\" type=\"text\" maxlength=\"9\" name=\"dependentrealtionship\"></td></tr>");
             }
            %>
            
            <tr> <td><button class="btn btn-lag btn-primary btn-block" type="submit">submit</button></td></tr>
        </table>
    </form>
</div>
</body>
</html>