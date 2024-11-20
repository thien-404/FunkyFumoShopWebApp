<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleforviewcart.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js"></script>
    </head>
    <body class="d-flex flex-column min-vh-100">
        <div class="splash" id="overplay">
            <h1 class = "splash-header"><img src="pic/gif/fumo-cirno-fumo.gif"/><br>
                <img src="pic/gif/loading-bar-5652260-4718889.gif"/></h1>
        </div>
        <header class="py-3 shadow">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3 text-center text-md-left d-flex align-items-center">
                        <a href="MainController?action=SearchProduct"><img  src="pic/logo/headerlogo.png" height="75" width="160" alt="Logo"></a>
                        <h1 class="ml-3 mb-0">FunkyFumoFunny</h1>
                    </div>
                    <div class="col-md-9 d-flex justify-content-end">
                        <form action="MainController">

                            <button type="submit" name="action" value="UserProfile" class="btn btn-light ml-2">
                                <img src="pic/logo/user.png" height="19" width="18.5" alt="User Icon"/>
                            </button>
                            <button type="submit" name="action" value="viewUserOrder" class="btn btn-light ml-2">
                                <img src="pic/logo/booking.png" height="19" width="18.5" alt="View Order details Icon"/>
                            </button>
                            <button type="submit" name="action" value="ViewCart" class="btn btn-light ml-2">
                                <img src="pic/logo/viewcartlogo.png" height="19" width="18.5" alt="View Cart Icon"/>
                            </button>
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

        <main class="flex-fill">
            <div class="container py-5">
                <h2 class="text-center mb-4">Your Shopping Cart</h2>
                ${requestScope.MESSAGE}
                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Subtotal</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:set var="total" value="0.0" />
                        <c:set var="totalItem" value="0" />
                        <c:forEach items="${sessionScope.CART.getCart().values()}" var="item" varStatus="counter">
                        <form action="MainController">
                            <c:set var="total" value="${total + item.price * item.quantity}"></c:set>
                            <c:set var="totalItem" value="${totalItem + item.quantity}"></c:set>
                                <tr>

                                    <td>
                                        <input type="hidden" name="productID" value="${item.productID}"/>     
                                    <img src="${item.srcImg}" height="60" alt="Product Image"/>${item.name}
                                </td>
                                <td>${item.price}$</td>
                                <td>
                                    <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control form-control-sm">
                                </td>
                                <td>${item.price * item.quantity}$</td>
                                <td>                                    

                                    <button type="submit" name="action" value="RemoveCart" class="btn btn-danger btn-sm">Remove</button>
                                    <button type="submit" name="action" value="UpdateCart" class="btn btn-primary btn-sm ml-2">Update</button>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="d-flex justify-content-between align-items-center">
                    <h3>Total Items: <span id="cart-total">${totalItem}</span></h3>
                    <h3>Total: <span id="cart-total">${total}$</span></h3>
                    <button class="btn btn-success">Checkout</button>
                </div>
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
