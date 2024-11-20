<%-- 
    Document   : orderDetail
    Created on : Aug 21, 2024, 10:22:53 AM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Order Detail</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleforviewcart.css">
        <link rel="stylesheet" href="css/StyleForOrderDetail.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js"></script>
    </head>
    <body class="d-flex flex-column min-vh-100">
        <div class="splash" id="overplay">
            <h1 class="splash-header">
                <img src="pic/gif/fumo-cirno-fumo.gif"/><br>
                <img src="pic/gif/loading-bar-5652260-4718889.gif"/>
            </h1>
        </div>
        <header class="py-3 shadow">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3 text-center text-md-left d-flex align-items-center">
                        <a href="MainController?action=SearchProduct"><img  src="pic/logo/headerlogo.png" height="75" width="160" alt="Logo"></a>
                        <h1 class="ml-3 mb-0">FunkyFumoFunny</h1>
                    </div>
                    <div class="col-md-9 d-flex justify-content-end">
                        <form action="MainController" method="POST">
                            <button type="submit" name="action" value="UserProfile" class="btn btn-light ml-2">
                                <img src="pic/logo/user.png" height="19" width="18.5" alt="User Icon"/>
                            </button>
                            <button type="submit" name="action" value="viewUserOrder" class="btn btn-light ml-2">
                                <img src="pic/logo/booking.png" height="19" width="18.5" alt="View Order details Icon"/>
                            </button>
                            <a href="MainController?action=ViewCart" class="btn btn-light ml-2">
                                <img src="pic/logo/viewcartlogo.png" height="19" width="18.5" alt="View Cart Icon"/>
                            </a>
                            <button type="submit" name="action" value="Logout" class="btn btn-light ml-2">
                                <img src="pic/logo/logout.png" height="19" width="18.5" alt="Logout Icon"/>
                            </button>
                            <button type="submit" name="action" value="SearchProduct" class="btn btn-light ml-2">
                                <img src="pic/logo/back-button.png" height="19" width="18.5" alt="Back Icon"/>
                            </button>
                        </form>                        
                    </div>
                </div>
            </div>
        </header>
        <c:if test="${requestScope.orderList != null}">
            <main class="flex-fill">
                <div class="container py-5">
                    <h2 class="text-center mb-4">Order Details</h2>

                    <c:forEach items="${requestScope.orderList}" var="orderList">
                        <div class="order-container mb-5 p-4 rounded shadow-sm">
                            <p><strong>Date:</strong> ${orderList.date}</p>
                            <p><strong>Order ID:</strong> ${orderList.orderId}</p>
                            <p><strong>Total:</strong> ${orderList.total}</p>

                            <table class="table table-bordered table-striped mt-3">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderList.list}" var="detailList">
                                        <tr>
                                            <td><img src="${detailList.srcImg}" height="60" alt="Product Image"/></td>
                                            <td>${detailList.productName}</td>
                                            <td>${detailList.price}</td>
                                            <td>${detailList.quantity}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                </div>
            </main>
        </c:if>



        <footer class="py-3">
            <div class="container text-center">
                <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
                <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> 
                    <a href="mailto:huynhduclong122@gmail.com" >huynhduclong122@gmail.com</a>
                </p>
                <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="Phone Icon"/> 
                    <a href="tel:0934103416" >0934 103 416</a>
                </p>
                <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 
                    123 Anime Street, Otaku City, Japan
                </p>
            </div>
        </footer>
    </body>
</html>
