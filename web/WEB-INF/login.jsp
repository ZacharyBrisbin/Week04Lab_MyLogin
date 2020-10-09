<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <strong>Username:</strong> <input type="text" name="username" value="${username}"><br>
            <strong>Password:</strong> <input type="password" name="password" value="${password}"><br>
            <input type="submit" value="Log in">
        </form>
            <c:if test="${logout}">
                <p>You have successfully been logged out</p>
            </c:if>
                
            <c:if test="${error}">
                <p>You must enter both values</p>
            </c:if>
                
            <c:if test="${loginError}">
                <p>Incorrect username or password</p>
            </c:if>
    </body>
</html>
