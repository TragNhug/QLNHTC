<%-- 
    Document   : lobby
    Created on : Aug 15, 2022, 6:14:59 PM
    Author     : HP
--%>
<!--SẢNH-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--import c-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-primary">SẢNH TIỆC CƯỚI</h1>



<div class="container">
    <!--phaan trang-->
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(lobbyCounter/pageSize)}" var="i">
            <c:url value="/lobby/" var="u" >
                <c:param name="page" value="${i}" />

            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
            </c:forEach>
    </ul>
    <!--đổ danh sách sản phẩm ra--> 
    <div class="row">
        <c:forEach items="${lobbies}" var="p">
            <div class="col-md-3 col-12" style="padding: 10px;">
                <div class="card">
                    <img class="card-img-top" class="img-fluid" src="${p.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>
                        <p class="card-text">
                            <fmt:formatNumber value="${p.price}" type="currency"/> VND
                        </p>
                        <a href="#" class="btn btn-primary"onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Chọn sảnh</a>
                        <a href="<c:url value="/lobby/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="<c:url value="/js/cart.js" />"></script>


