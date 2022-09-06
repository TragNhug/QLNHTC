<%-- 
    Document   : density
    Created on : Sep 3, 2022, 12:06:59 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-primary">THỐNG KÊ MẬT ĐỘ TIỆC CƯỚI</h1>


<h3 class="text-danger"> Theo Tháng</h3>
<form action="">
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>

    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>

<div>
    <canvas id="myWeddingStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Số tiệc cưới </th>
    </tr>
    <c:forEach items="${density}" var= "w">
        <tr>
            <td>${w[0]}/${w[1]}</td>
            <td>${w[2]}</</td>

        </tr>
    </c:forEach>
</table>

<script>

    
</script>
<h3 class="text-danger"> Theo Quý</h3>
<div>
    <canvas id="myWeddingStatsChartQuarter"></canvas>
</div>

<table class="table">
    <tr>
        <th>Quý</th>
        <th>Số tiệc cưới </th>
    </tr>
    <c:forEach items="${densityQuarter}" var= "q">
        <tr>
            <td>${q[0]}/${q[1]}</td>
            <td>${q[2]}</</td>

        </tr>
    </c:forEach>
</table>
<h3 class="text-danger"> Theo Năm</h3>
<!--<form action="">
    <div class="form-group">
        <label>Từ năm</label>
        <input type="number" name="fromYear" class="form-control" />
    </div>

    <div class="form-group">
        <label>Đến năm</label>
        <input type="number" name="toYear" class="form-control" />
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>-->

<div>
    <canvas id="myWeddingStatsChartYear"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Số tiệc cưới </th>
    </tr>
    <c:forEach items="${densityYear}" var= "d">
        <tr>
            <td>${d[0]}</td>
            <td>${d[1]}</</td>

        </tr>
    </c:forEach>
</table>

<script>
//    theo tháng
    let productLabels = [], productInfo = []

    <c:forEach items="${density}" var="w">
    productLabels.push('${w[0]}/${w[1]}');
        productInfo.push(${w[2]});

    </c:forEach>
//        window.onload = function () {
//            
//        }
//theo năm
    let productLabelsYear = [], productInfoYear = []

    <c:forEach items="${densityYear}" var="d">
    productLabelsYear.push(${d[0]});
        productInfoYear.push(${d[1]});

    </c:forEach>
//        theo quý
        let productLabelsQuarter = [], productInfoQuarter = []

    <c:forEach items="${densityQuarter}" var="q">
    productLabelsQuarter.push('${q[0]}/${q[1]}');
        productInfoQuarter.push(${q[2]});

    </c:forEach>
        
        window.onload = function () {
            weddingChart("myWeddingStatsChart", productLabels, productInfo);
            weddingChart("myWeddingStatsChartYear", productLabelsYear, productInfoYear);
             weddingChart("myWeddingStatsChartQuarter", productLabelsQuarter, productInfoQuarter);
        }
</script>
<script src="<c:url value="/js/stats.js" />"></script>