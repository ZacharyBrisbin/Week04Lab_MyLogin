<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="home" method="post">
            <strong>Username:</strong> <input type="text" name="username" value=""><br>
            <strong>Password:</strong> <input type="password" name="password" value=""><br>
            <input type="submit" name="login" value="Log in">
        </form>
        <p>${logout}</p>
    </body>
</html>
