<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>invalid</title>
</head>
<body>
    <div class="wrapper">


        <form action="invalidservlet" method="get">
        <h2 class="form-signin-heading text-center">you are not a manager you can not proceed future</h2>
        <button class="btn btn-lag btn-primary btn-block" type="submit">go back</button>
        </form>
    </div>

</body>
</html>