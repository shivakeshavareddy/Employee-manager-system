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
/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
</style>
<meta charset="ISO-8859-1">
<title>delete employee</title>
</head>
<body>
<div class="wrapper">
    <form class="form-signin" action="deleteempservlet" method="post">
        <tr>
            <td><h3>
                employee ssn
            </h3></td></tr><tr>
                <td><input onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control" type="text" name="dssn" required minlength="9" maxlength="9" ></td>
            </tr>
        
    <button class="btn btn-lag btn-primary btn-block" type="submit">submit</button>
    </form>
</div>
</body>
</html>