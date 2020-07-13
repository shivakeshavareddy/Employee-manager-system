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
</head>
<body>
<div class = "wrapper">
    
    <form action="checkmanager" class="form-signin" method="post">
        <h2 class="form-signin-heading text-center">Enter your ssn</h2>
    <input class="form-control" type="text" name="essn" required minlength="9" maxlength="9" size="10">
    <button class="btn btn-lag btn-primary btn-block" type="submit">submit</button>
    </form>
</div>
</body>
</html>
