<%-- 
    Document   : wedding
    Created on : Sep 4, 2022, 12:12:32 AM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="text-primary"> Tra cứu tiệc cưới </h3>

<form class="d-flex">
    <input class="form-control me-2" name="fromPrice" type="text" placeholder="Giá từ"/>
    <input class="form-control me-2" name="toPrice" type="text" placeholder="Giá đến"/>
    <div class="form-group">
        <label>Ngày tổ chức</label>
        <input type="date" name="date" class="form-control" />
    </div>
    <input type="submit" value="Tìm kiếm" class="btn btn-success"/>
</form>
        
 <div class="container">
   
    <table class="table">
        <tr>
            <th>Mã tiệc cưới</th>
            <th>Ngày tổ chức</th>
            <th>Giá</th>
        </tr>
        
        <c:forEach items="${weddingStats}" var="w">
            <tr>
                
                <td>${w[0]}</td>
                <td>${w[1]}</td>
                <td>${w[2]} VND</td>
            
               
            </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>
</div>


