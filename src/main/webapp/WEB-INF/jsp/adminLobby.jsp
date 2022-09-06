<%-- 
    Document   : adminLobby
    Created on : Aug 18, 2022, 7:45:24 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">QUẢN LÝ SẢNH</h1>

<!--thêm sản phẩm-->
<c:url value="/admin/lobby" var="action"/>
<form:form method="post" action="${action}" modelAttribute="lobby">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="name" name="name" />
        <label for="name">Ten san pham</label>
        <form:errors path="name" element="div" cssClass="invalid-feedback" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="price" id="price" placeholder="price" name="price" />
        <label for="price">Gia san pham</label>
        <form:errors path="price" element="div" cssClass="invalid-feedback" />
    </div>
    
    
    <div>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>

<!--xóa sản phẩm-->
<div class="container">
    <div class="spinner-border text-warning" id="myLoading"></div>
    <table class="table">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        <tbody id="myLobby">

        </tbody>
    </table>
</div>
<script src="<c:url value="/js/lobby.js" />"></script>
<script>
    <c:url value="/api/lobbies" var="endpoint" />
    window.onload = function () {
        loadLobies('${endpoint}');
    }
</script>