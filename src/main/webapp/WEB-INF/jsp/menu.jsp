<%-- 
    Document   : menu
    Created on : Aug 16, 2022, 9:38:24 PM
    Author     : HP
--%>

<!--SẢNH-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--import c-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-primary">THỰC ĐƠN</h1>

<!--đổ danh sách sản phẩm ra-->
<div class="container">
    <!--phaan trang-->
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(menuCounter/pageSize)}" var="i">
            <c:url value="/menu/" var="u" >
                <c:param name="page" value="${i}" />

            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
            </c:forEach>
    </ul>
    <div class="row">
        <c:forEach items="${menus}" var="m">
            <div class="col-md-3 col-12" style="padding: 10px;">
                <div class="card">
                    <img class="card-img-top" class="img-fluid" src="${m.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${m.name}</h4>
                        <p class="card-text">
                            <fmt:formatNumber value="${m.price}" type="currency"/> VND
                        </p>
                        <a href="#" class="btn btn-primary"onclick="addToCart(${m.id}, '${m.name}', ${m.price})">Chọn thực đơn</a>
                        <a href="<c:url value="/menu/${m.id}" />" class="btn btn-primary">Xem chi tiet</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="<c:url value="/js/cart.js" />"></script>


