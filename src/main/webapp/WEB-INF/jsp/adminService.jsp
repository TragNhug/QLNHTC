<%-- 
    Document   : adminService
    Created on : Aug 19, 2022, 4:43:09 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-primary">QUẢN LÝ DỊCH VỤ</h1>
<!--thêm sản phẩm-->
<c:url value="/admin/service" var="action"/>
<form:form method="post" action="${action}" modelAttribute="service">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="name" name="name" />
        <label for="name">Tên dịch vụ</label>
        <form:errors path="name" element="div" cssClass="invalid-feedback" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="price" id="price" placeholder="price" name="price" />
        <label for="price">Giá dịch vụ</label>
        <form:errors path="price" element="div" cssClass="invalid-feedback" />
    </div>
    
    <div>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>


<!--xóa-->
<div class="container">
    <div class="spinner-border text-warning" id="myLoading"></div>
    <table class="table">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tbody id="myService">

        </tbody>
    </table>
</div>

<script src="<c:url value="/js/service.js" />"></script>
<script>
    <c:url value="/api/services" var="endpoint" />
    window.onload = function () {
        loadServices('${endpoint}');
    }
</script>