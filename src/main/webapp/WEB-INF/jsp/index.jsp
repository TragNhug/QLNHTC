<%-- 
    Document   : index
    Created on : Aug 15, 2022, 5:23:23 PM
    Author     : HP
--%>
<!--trang chủ-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--import c-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="text-center text-primary">CHÀO MỪNG ĐẾN VỚI NHÀ HÀNG TIỆC CƯỚI</h1>

<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://happywedding.vn/PICTURE/SUPPLIER/01-2020/trung-tam-hoi-nghi-tiec-cuoi-kalina-5964.jpg" alt="Los Angeles" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="https://happywedding.vn/PICTURE/SUPPLIER/05-2018/trung-tam-hoi-nghi-tiec-cuoi-kalina-4761.jpg" alt="Chicago" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="https://happywedding.vn/PICTURE/SUPPLIER/02-2018/trung-tam-hoi-nghi-tiec-cuoi-kalina-2479.jpg" alt="New York" class="d-block w-100">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>