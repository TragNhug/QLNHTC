<%-- 
    Document   : employee
    Created on : Sep 3, 2022, 8:23:21 PM
    Author     : HP
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="text-primary"> Thêm nhân viên </h3>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/admin/employee" var="action" />
<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute ="user">
    <div class="form-group">
        <label for="firstname">First Name</label>
        <form:input type="text" id="firstname" path="firstname" class="form-control" />

    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <form:input type="text" id="lastname" path="lastname" class="form-control" />

    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="text" id="email" path="email" class="form-control" />

    </div>
    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input type="text" id="phone" path="phone" class="form-control" />

    </div>
    <div class="form-group">
        <label for="address">Address</label>
        <form:input type="text" id="address" path="address" class="form-control" />

    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />

    </div>


    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />

    </div>
    <div class="form-group">
        <label for="confirmpassword">Confirm Password</label>
        <form:input type="password" id="confirmpassword" path="confirmpassword" class="form-control" />

    </div>
    <div class="form-group">
        <label for="image">Avatar</label>
        <form:input type="file" id="image" path="file" class="form-control" />

    </div>
        <br/> 
    <div class="form-group">
        <input type="submit" value="Thêm nhân viên" class="btn btn-danger" />
    </div>
</form:form>
<br/>
<form class="d-flex">
    <input class="form-control me-2" name="un" type="text" placeholder="Search"/>
    <input type="submit" value="Tìm kiếm" class="btn btn-success"/>
</form>
        
 <div class="container">
   
    <table class="table">
        <tr>
            <th></th>
            <th>Mã nhân viên</th>
            <th>UserName</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th></th>
        </tr>
        
        <c:forEach items="${employee}" var="e">
            <tr>
                <td><img src="${e[4]}" width="60" height="60" /></td>
                <td>${e[0]}</td>
                <td>${e[1]}</td>
                <td>${e[2]}</td>
                <td>${e[3]}</td>
                <td>
                    <input type="button" 
                           value="Xoa" 
                           onclick="deleteEmployee(${e[0]})"
                           class="btn btn-danger" />
                </td>
            </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>
</div>
<script src="<c:url value="/js/employee.js" />"></script>
