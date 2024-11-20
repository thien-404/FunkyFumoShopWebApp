<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleforadminpage.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js"></script>
        <script src="script/activetab.js"></script>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="Login.jsp"></c:redirect>
        </c:if>
        <header class="bg-pink text-white py-3 shadow-sm">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-6 text-center text-md-left d-flex align-items-center">
                        <h1 class="mb-0">Admin Dashboard</h1>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end align-items-center">
                        <span class="mr-3">Welcome, <strong>${sessionScope.LOGIN_USER.fullName}</strong></span>
                        <form action="MainController" class="mb-0">
                            <button type="submit" name="action" value="Logout" class="btn btn-light"><img src="pic/logo/logout.png" height="19" width="18.5" alt="Logout Icon"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </header>

        <main class="container my-4">
            <ul class="nav nav-tabs mb-4" id="adminTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="users-tab" data-toggle="tab" href="#users" role="tab">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="products-tab" data-toggle="tab" href="#products" role="tab">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="order-details-tab" data-toggle="tab" href="#order-details" role="tab">Order Details</a>
                </li>
            </ul>
            <div class="tab-content" id="adminTabContent">
                <div class="tab-pane fade show active" id="users" role="tabpanel">
                    <h2 class="mt-4">Manage Users</h2>
                    <div>${requestScope.MESSAGE}</div>
                    <form action="MainController" class="mb-4">
                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="search" class="form-control" placeholder="Search Users" value="${param.search}"/>
                            </div>
                            <div class="col-auto">
                                <input type="submit" name="action" value="Search" class="btn btn-primary"/>
                            </div>
                        </div>
                    </form>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>User ID</th>
                                <th>Username</th>
                                <th>Email</th>
                                <th>Role</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${requestScope.LIST_USER}">
                                <tr>
                            <form action="MainController" method="POST">
                                <td>${user.userID}
                                    <input type="hidden" name="userID" value="${user.userID}"/>
                                </td>
                                <td>
                                    <input type="text" name="fullName" class="form-control form-control-sm" value="${user.fullName}"/>
                                </td>
                                <td>${user.email}</td>
                                <td>
                                    <select name="roleID" class="form-control form-control-sm">
                                        <option value="AD" ${user.roleID == 'AD' ? 'selected' : ''}>Admin</option>
                                        <option value="US" ${user.roleID == 'US' ? 'selected' : ''}>User</option>
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" name="action" value="Delete" class="btn btn-danger btn-sm">Delete</button>
                                    <button type="submit" name="action" value="Update" class="btn btn-primary btn-sm ml-2">Update</button>
                                    <input type="hidden" name="search" value="${param.search}"/>
                                </td>
                            </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    ${requestScope.ERROR}
                </div>
                <div class="tab-pane fade" id="products" role="tabpanel">
                    <h2 class="mt-4">Manage Products</h2>
                    <form action="MainController" class="mb-4">
                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="searchProduct" class="form-control" placeholder="Search Products" value="${param.searchProduct}"/>
                            </div>
                            <div class="col-auto">
                                <input type="submit" name="action" value="SearchProduct" class="btn btn-primary"/>
                                <input type="hidden" name="siteUrl" value="admin.jsp"/>
                            </div>
                        </div>
                    </form>

                    <form action="MainController">
                        <button type="submit" name="action" value="AddProductPage" class="btn btn-primary my-3">Add Product</button>
                    </form>
                    ${requestScope.MESSAGE}

                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Product ID</th>
                                <th>Product Image</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>In Stock</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${requestScope.LIST_PRODUCT}">
                                <tr>
                            <form action="MainController">
                                <td>${product.productID}
                                    <input type="hidden" name="productID" value="${product.productID}"/>
                                </td>
                                <td>
                                    <img src="${product.srcImg}" height="60" alt="Product Image"/>
                                    <input name="srcImg" value="${product.srcImg}" type="text" class="form-control form-control-sm"/>
                                </td>
                                <td>
                                    <input type="text" name="name" value="${product.name}" class="form-control form-control-sm"/>
                                </td>
                                <td>
                                    <input name="price" value="${product.price}" type="number" class="form-control form-control-sm"/>($)
                                </td>
                                <td>
                                    <input type="number" name="quantity" value="${product.quantity}" min="1" class="form-control form-control-sm"/>
                                </td>
                                <td>
                                    <button type="submit" name="action" value="UpdateProduct" class="btn btn-primary btn-sm">Update</button>
                                    <button type="submit" name="action" value="DeleteProduct" class="btn btn-danger btn-sm">Delete</button>
                                    <input type="hidden" name="search" value="${param.searchProduct}"/>
                                </td>
                            </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="order-details" role="tabpanel">
                    <h2 class="mt-4">Manage Order Details</h2>
                    <form action="MainController" class="mb-4">
                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="searchOrder" class="form-control" placeholder="Search Orders" value="${param.searchOrder}"/>
                            </div>
                            <div class="col-auto">
                                <input type="submit" name="action" value="SearchOrder" class="btn btn-primary"/>
                            </div>
                        </div>
                    </form>
                    <c:if test="${requestScope.orderList != null}">
                        <main class="flex-fill">
                            <div class="container py-5">                
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
                </div>
            </div>
        </main>

        <footer class="text-white py-3 text-center">
            <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
            <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> <a href="mailto:huynhduclong122@gmail.com" class="text-white">thayhieudeptrai@gmail.com</a></p>
            <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="phone Icon"/> <a href="tel:0934103416" class="text-white">0934 103 416</a></p>
            <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 123 Anime Street, Otaku City, Japan</p>
        </footer>
    </body>
</html>
