<%--
  Created by IntelliJ IDEA.
  User: iU LOVE
  Date: 7/30/2021
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trung tâm quản lý tài khoản</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        td {
            font-size: 16px;
            font-family: Tahoma;
            text-align: center;
            color: black;
            background-color: white;
        }

        tr {
            background-color: gray;
            color: white;
        }

    </style>
</head>
<body>
<h1 style="text-align: center">List Product</h1>
<table style="color: blue" ; border="1px">
    <%--    Quản lý sản phẩm--%>
    <thead>
    <th colspan="10">
        <h1 style="text-align: center">Quản lý sản phẩm</h1>
    </th>
    </tr>
    <tr>
        <td width="250px" height="60px"><b>ID</b></td>
        <td width="250px" height="60px"><b>Name</b></td>
        <td width="250px" height="60px"><b>Price</b></td>
        <td width="250px" height="60px"><b>Amount</b></td>
        <td width="250px" height="60px"><b>Color</b></td>
        <td width="250px" height="60px"><b>Description</b></td>
        <td width="250px" height="60px"><b>Category</b></td>
        <td colspan="3" width="250px" height="60px"><b>Actison</b></td>


    </tr>
    </thead>
    <div>
        <c:forEach var="sp" items="${listSP}"  varStatus="loop">
                <div class="col-sm-4">
                    <tr>

                        <td>${sp.id}</td>
                        <td>${sp.name}</td>
                        <td>${sp.price} VNĐ</td>
                        <td>${sp.amount}</td>
                        <td>${sp.color}</td>
                        <td>${sp.description}</td>
                        <td>${sp.idCategory}</td>

                        <td style="width: 100px; height: 100px"><a href="/sanpham?action=edit&index=${loop.index}"
                                                                   class="btn btn-success">Edit</a></td>
                        <td style="width: 100px; height: 100px"><a href="/sanpham?action=thongbao&index=${loop.index}"
                                                                   class="btn btn-success">Delete</a></td>
                    </tr>
                </div>

        </c:forEach>
    </div>
    <br>
    <form action="/sanpham?action=findName" method="get">
        <div class="input-group" style="width: 250px;">
            <input type="text" class="form-control" placeholder="tìm kiếm" name="findName" style="width: 226px;">
            <input type="text" hidden name="action" value="findName">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit" style="width: 42px;height: 34px;"><i
                        class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>
        <a href="/sanpham?action=create" class="btn btn-success">Create</a>
        <a href="/sanpham" class="btn btn-success">home</a>
</table>

</body>
</html>
