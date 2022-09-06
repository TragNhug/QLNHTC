<%-- 
    Document   : updateLobby
    Created on : Sep 4, 2022, 5:14:34 PM
    Author     : HP
--%>+

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="btn-success text-center">CHỈNH SỬA THÔNG TIN SẢNH CƯỚI</h1>

<form:form action="${updateU}" method="post" modelAttribute="lobby" >
    <div id="fom-update">
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="name" id="name" placeholder="name" name="name" />
            <label for="name">Tên sảnh</label>
            <form:errors path="name" element="div" cssClass="invalid-feedback" />
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" path="price" id="price" placeholder="price" name="price" />
            <label for="price">Giá sảnh</label>
            <form:errors path="price" element="div" cssClass="invalid-feedback" />
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" path="qtytable" id="qtytable" placeholder="qtytable" name="qtytable" />
            <label for="name">Số bàn tối đa</label>

        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" path="qtystaff" id="qtystaff" placeholder="qtystaff" name="qtystaff" />
            <label for="price">Số nhân viên phục vụ</label>

        </div>
        <div>
            <input type="submit" value="Cập nhật thông tin" class="btn btn-danger" />
        </div>
    </div>
</form:form>
