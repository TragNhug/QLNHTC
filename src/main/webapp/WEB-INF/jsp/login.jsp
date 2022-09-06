<%-- 
    Document   : login
    Created on : Aug 27, 2022, 3:07:12 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <h1 class="text-center text-primary"> ĐĂNG NHẬP</h1>
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" />

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" />
        </div>
        <br>
        <div class="form-group">
            <input class="btn btn-danger" type="submit" value="Đăng nhập" />
        </div>
</form>