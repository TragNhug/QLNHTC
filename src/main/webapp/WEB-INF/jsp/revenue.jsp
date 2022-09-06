<%-- 
    Document   : revenue
    Created on : Sep 3, 2022, 6:14:53 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <canvas id="revenueStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu </th>
    </tr>
    <c:forEach items="${revenue}" var= "m">
        <tr>
            <td>${m[0]}/${m[1]}</td>
            <td>${m[2]}</</td>

        </tr>
    </c:forEach>
</table>

<script>


</script>
<h3 class="text-danger"> Theo Quý</h3>
<div>
    <canvas id="revenueStatsChartQuarter"></canvas>
</div>

<table class="table">
    <tr>
        <th>Quý</th>
        <th>Doanh thu </th>
    </tr>
    <c:forEach items="${revenueQuarter}" var= "q">
        <tr>
            <td>${q[0]}/${q[1]}</td>
            <td>${q[2]}</</td>

        </tr>
    </c:forEach>
</table>
<h3 class="text-danger"> Theo Năm</h3>


<div>
    <canvas id="revenueStatsChartYear"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Doanh thu </th>
    </tr>
    <c:forEach items="${revenueYear}" var= "y">
        <tr>
            <td>${y[0]}</td>
            <td>${y[1]}</</td>

        </tr>
    </c:forEach>
</table>

<script>
//    theo tháng
    let productLabels = [], productInfo = []

    <c:forEach items="${revenue}" var="w">
    productLabels.push('${w[0]}/${w[1]}');
        productInfo.push(${w[2]});

    </c:forEach>
//        window.onload = function () {
//            
//        }
//theo năm
        let productLabelsYear = [], productInfoYear = []

    <c:forEach items="${revenueYear}" var="d">
        productLabelsYear.push(${d[0]});
        productInfoYear.push(${d[1]});

    </c:forEach>
//        theo quý
        let productLabelsQuarter = [], productInfoQuarter = []

    <c:forEach items="${revenueQuarter}" var="q">
        productLabelsQuarter.push('${q[0]}/${q[1]}');
        productInfoQuarter.push(${q[2]});

    </c:forEach>

            window.onload = function () {
                revenueChart("revenueStatsChart", productLabels, productInfo);
                revenueChartYear("revenueStatsChartYear", productLabelsYear, productInfoYear);
                revenueChartQuarter("revenueStatsChartQuarter", productLabelsQuarter, productInfoQuarter);
            }
</script>
<script src="<c:url value="/js/revenue.js" />"></script>
