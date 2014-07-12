<%-- 
    Document   : useradd
    Created on : 11.07.2014, 14:50:47
    Author     : mvas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add user</title>
    </head>
    <body>
        <h1>Add user</h1>
        <form action="/user/add" method="post">
            <input name="login" type="text"/>
            <select name="role">
                <option value="0">First</option>
                <option value="1">Second</option>
                <option value="2">Third</option>
            </select>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
