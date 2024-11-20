<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Product</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/addproduct.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js"></script>
    </head>
    <body class="d-flex flex-column min-vh-100">
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="Login.jsp"></c:redirect>
        </c:if>
        <header class="py-3 shadow">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-6 text-center text-md-left d-flex align-items-center">
                        <h1 class="ml-3 mb-0">Admin Dashboard</h1>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end align-items-center">
                        <span class="mr-3">Welcome, <strong>${sessionScope.LOGIN_USER.fullName}</strong></span>
                        <button class="btn btn-light"><img src="pic/logo/logout.png" height="19" width="18.5" alt="Logout Icon"/></button>
                    </div>
                </div>
            </div>
        </header>
        <main class="flex-fill">
            <div class="container py-5">
                <h2 class="text-center mb-4">Add New Product</h2>
                <form action="MainController" method="POST">

                    <div class="form-group">
                        <label for="productID">Product ID</label>
                        <input type="text" class="form-control" id="productID" name="productID" required>
                        <small class="text-danger">${requestScope.PRODUCT_ERROR.productID}</small>
                    </div>

                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input type="text" class="form-control" id="productName" name="name" required>
                        <small class="text-danger">${requestScope.PRODUCT_ERROR.name}</small>
                    </div>

                    <div class="form-group">
                        <label for="productPrice">Price ($)</label>
                        <input type="number" class="form-control" id="productPrice" name="price" min="0" required>
                        <small class="text-danger">${requestScope.PRODUCT_ERROR.price}</small>
                    </div>

                    <div class="form-group">
                        <label for="productQuantity">In Stock</label>
                        <input type="number" class="form-control" id="productQuantity" name="quantity" min="0" required>
                        <small class="text-danger">${requestScope.PRODUCT_ERROR.quantity}</small>
                    </div>

                    <div class="form-group">
                        <label for="productImage">Product Image URL</label>
                        <input type="text" class="form-control" id="productImage" name="srcImg" required>
                        <small class="text-danger">${requestScope.PRODUCT_ERROR.srcImg}</small>
                    </div>

                    <button type="submit" name="action" value="AddProduct" class="btn btn-success btn-block">Add Product</button>
                    <small class="text-danger">${requestScope.PRODUCT_ERROR.error}</small>
                </form>
            </div>
        </main>

        <footer class="py-3">
            <div class="container text-center">
                <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
                <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> 
                    <a href="mailto:huynhduclong122@gmail.com" class="text-white">huynhduclong122@gmail.com</a>
                </p>
                <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="Phone Icon"/> 
                    <a href="tel:0934103416" class="text-white">0934 103 416</a>
                </p>
                <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 
                    123 Anime Street, Otaku City, Japan
                </p>
            </div>
        </footer>
    </body>
</html>
