<%-- 
    Document   : p-detail
    Created on : Aug 24, 2022, 1:11:43 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">CHI TIET SAN PHAM</h1>

<div class="row">
    <div class="col-md-5">
        <img src="${product.image}" class="img-fluid" />
    </div>
    <div class="col-md-7">
        <h1>${product.name}</h1>
    </div>
</div>