<%-- 
    Document   : admin-left
    Created on : Sep 2, 2022, 11:48:04 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar bg-light">
  <div class="container-fluid">
    <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/lobby" />">Quản lý sảnh</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/menu" />">Quản lý menu</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/service" />">Quản lý dịch vụ</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/employee" />">Quản lý nhân viên</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/wedding" />">Tra cứu tiệc cưới</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/density" />">Thống kê mật độ tiệc cưới</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/revenue" />">Thống kê doanh thu tiệc cưới</a>
      </li>
      
    </ul>
  </div>
</nav>