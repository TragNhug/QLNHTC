<%-- 
    Document   : service
    Created on : Aug 16, 2022, 10:24:05 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--import c-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-primary">DỊCH VỤ TIỆC CƯỚI</h1>

<!--đổ danh sách sản phẩm ra-->
<div class="container">
    <!--phaan trang-->
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(serviceCounter/pageSize)}" var="i">
            <c:url value="/service/" var="u" >
                <c:param name="page" value="${i}" />

            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
            </c:forEach>
    </ul>
    <div class="row">
        <c:forEach items="${services}" var="s">
            <div class="col-md-3 col-12" style="padding: 10px;">
                <div class="card">
                    <img class="card-img-top" class="img-fluid" src="${s.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${s.name}</h4>
                        <p class="card-text">
                            <fmt:formatNumber value="${s.price}" type="currency"/> VND
                        </p>
                        <a href="#" class="btn btn-primary"onclick="addToCart(${s.id}, '${s.name}', ${s.price})">Chọn dịch vụ</a>

                        <a href="<c:url value="/service/${s.id}" />" class="btn btn-primary">Xem chi tiet</a>
                        
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="<c:url value="/js/cart.js" />"></script>
