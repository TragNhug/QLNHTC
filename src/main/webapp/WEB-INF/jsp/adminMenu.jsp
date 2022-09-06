<%-- 
    Document   : adminMenu
    Created on : Aug 19, 2022, 4:43:23 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">QUẢN LÝ MENU</h1>
<!--thêm sản phẩm-->
<c:url value="/admin/menu" var="action"/>
<form:form method="post" action="${action}" modelAttribute="menu">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="name" name="name" />
        <label for="name">Tên menu</label>
        
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="price" id="price" placeholder="price" name="price" />
        <label for="price">Giá menu</label>
      
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="appetizer" id="appetizer" placeholder="appetizer" name="appetizer" />
        <label for="name">Món khai vị</label>
       
    </div>
    
   <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="maincourse1" id="maincourse1" placeholder="maincourse1" name="maincourse1" />
        <label for="name">Món chính 1</label>
       
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="maincourse2" id="maincourse2" placeholder="maincourse2" name="maincourse2" />
        <label for="name">Món chính 2</label>
      
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="maincourse3" id="maincourse3" placeholder="maincourse3" name="maincourse3" />
        <label for="name">Món chính 3</label>
      
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="dessert" id="dessert" placeholder="dessert" name="dessert" />
        <label for="name">Tráng miệng</label>
    
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="drinks" id="drinks" placeholder="drinks" name="drinks" />
        <label for="name">Thức uống</label>
       
    </div>
    <div>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>

<!--xóa menu-->
<div class="container">
    <div class="spinner-border text-warning" id="myLoading"></div>
    <table class="table">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tbody id="myMenu">

        </tbody>
    </table>
</div>
<script src="<c:url value="/js/menu.js" />"></script>
<script>
    <c:url value="/api/menus" var="endpoint" />
    window.onload = function () {
        loadMenus('${endpoint}');
    }
</script>
