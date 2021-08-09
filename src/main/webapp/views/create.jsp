<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="author" content="Kodinger">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>My Login Page &mdash; Bootstrap 4 Login Page Snippet</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/my.css">
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <br>
                <br>
                <br>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Create Product</h4>
                        <form action="/sanpham?action=create" method="post" class="my-login-validation" novalidate="">

                            <div class="form-group">
                                <label for="id">ID</label>
                                <input id="id" type="text" class="form-control" name="id" readonly>
                            </div>


                            <div class="form-group">
                                <label for="name">Name</label>
                                <input id="name" type="text" class="form-control" name="name" required autofocus>


                                <div class="form-group">
                                    <label for="price">Price</label>
                                    <input id="price" type="text" class="form-control" name="price" required
                                           autofocus>
                                </div>


                                <div class="form-group">
                                    <label for="amount">Amount</label>
                                    <input id="amount" type="text" class="form-control" name="amount" required
                                           autofocus>
                                </div>


                                <div class="form-group">
                                    <label for="color">Color</label>
                                    <input id="color" type="text" class="form-control" name="color" required autofocus>
                                </div>

                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <input id="description" type="text" class="form-control" name="description" required autofocus>
                                </div>

                                <div class="form-group">
                                    <label for="listCategory">Class</label>
                                    <select id="listCategory" name="idCategory" value="${category.id}" class="form-control">
                                        <c:forEach items="${listCategory}" var="category">
                                            <option value="${category.id}"> ${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>


                                <div class="form-group m-0">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        Create
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>