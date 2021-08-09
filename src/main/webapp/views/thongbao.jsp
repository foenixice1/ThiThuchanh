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
<h1 style="text-align: center">Bạn có thực sự muốn xóa ?</h1>
<table style="color: blue" ; border="1px">
    <%--    Quản lý sản phẩm--%>
    <div>
            <div class="col-sm-4">
                <tr>
                    <td style="width: 100px; height: 100px"><a href="/sanpham?action=delete"
                                                               class="btn btn-success">Yes</a></td>
                    <td style="width: 100px; height: 100px"><a href="/sanpham"
                                                               class="btn btn-success">No</a></td>
                </tr>
            </div>

    </div>
    <br>
</table>

</body>
</html>
