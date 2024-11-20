<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Anime Figure Store</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/stylesforshopping.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/autoscroll.js"></script>
        <script src="script/overplay.js"></script>


    </head>
    <body>

        <header class="text-white py-3 shadow">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3 d-flex justify-content-center justify-content-md-start align-items-center">
                        <a href="MainController?action=SearchProduct"><img  src="pic/logo/headerlogo.png" height="75" width="160" alt="Logo"></a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-center">
                        <div class="search-section w-100 d-flex align-items-center">
                            <form action="MainController" method="GET" class="d-flex w-100">
                                <input type="text" name="searchProduct" id="search-product" class="form-control mx-2" placeholder="Search...">
                                <button type="submit" name="action" value="SearchProduct" class="btn btn-light ml-2">
                                    <img src="pic/logo/search.png" height="19" width="18.5" alt="Search Icon"/>
                                </button>
                                <input type="hidden" name="siteUrl" value="shopping.jsp"/>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3 d-flex justify-content-center justify-content-md-end align-items-center">
                        <form action="MainController" method="POST" class="d-flex">
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
                        </form>
                    </div>
                </div>
            </div>
        </header>

        <div class="container py-5">
            <div class="row">

                <div class="col-md-6">
                    <section class="slider py-5">
                        <div id="mySlider" class="carousel slide" data-ride="carousel" data-interval="3200">
                            <ol class="carousel-indicators">
                                <li data-target="#mySlider" data-slide-to="0" class="active"></li>
                                <li data-target="#mySlider" data-slide-to="1"></li>
                                <li data-target="#mySlider" data-slide-to="2"></li>
                                <li data-target="#mySlider" data-slide-to="3"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="pic/art/art11.png" width="570" height="427.500" alt="art1">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="pic/art/art8.png"width="570" height="427.500" alt="art2">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="pic/art/art9.png"width="570" height="427.500" alt="art3">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="pic/art/art10.png"width="570" height="427.500" alt="art4">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#mySlider" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#mySlider" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </section>
                </div>

                <div class="col-md-6">
                    <section class="bg-dark fumo-description py-5">
                        <h2>What is Fumo?</h2>
                        <p>Fumo is a term used to describe adorable plush figures based on popular characters from anime and video games. These high-quality plush toys are highly collectible and beloved by fans worldwide.</p>
                        <h3>Why You Need to Buy It?</h3>
                        <ul>
                            <li><strong>Collectible Value:</strong> Fumos are often produced in limited quantities, making them highly sought after by collectors.</li>
                            <li><strong>Adorable Design:</strong> The cute and cuddly appearance of Fumos makes them perfect for display and cuddling.</li>
                            <li><strong>Perfect Gift:</strong> Fumos make great gifts for anime and video game fans.</li>
                        </ul>
                    </section>
                </div>
            </div>
        </div>

        <div class="container py-5">
            <div class="row">
                <div class="col-md-7">
                    <section class="text-center py-4" id="auto-scroll">
                        <h2>Our Products:</h2>
                    </section>
                    
                    <!--            success or not-->
                    <c:if test="${not empty requestScope.SUCCESS_MESSAGE}">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            ${requestScope.SUCCESS_MESSAGE}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    
                    <section class="products py-5">
                        <div class="row" id="productdiv">
                            <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                                <div class="col-sm-6 col-md-4 mb-3">
                                    <div class="card h-100">
                                        <img src="${product.srcImg}" class="card-img-top" alt="${product.name}">
                                        <div class="card-body text-center p-2">
                                            <h5 class="card-title h6">${product.name}</h5>
                                            <p class="card-text">${product.price}$</p>
                                            <form action="MainController" class="d-flex justify-content-center align-items-center">
                                                <input type="hidden" value="${product.productID}" name="productID"/>
                                                <input type="number" name="quantity" value="1" min="1" class="form-control form-control-sm w-50 mr-2">
                                                <button type="submit" name="action" value="AddToCart" class="btn btn-success btn-sm">
                                                    <img src="pic/logo/add-to-cart.png" height="19" width="18.5" alt="Add to Cart Icon"/>
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                </div>
                <div class="col-md-1 d-flex align-items-center">
                    <div class="separator w-100 border-left"></div>
                </div>
                <div class="col-md-4">
                    <section class="text-center py-4">
                        <h2>Coming Soon!!</h2>
                    </section>
                    <section class="new-arrivals py-5" id="new">
                        <div class="row">
                            <div class="col-sm-6 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img src="pic/new/KonpakuYoumu-MysteriousSwordMasterVersion.png" class="card-img-top" alt="Konpaku Youmu - Mysterious Sword Master Version">
                                    <div class="card-body text-center p-2">
                                        <h5 class="card-title">Konpaku Youmu<br>- Mysterious Sword Master Version</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img src="pic/new/Tiny Devil Mistress Version.png" class="card-img-top" alt="Remilia Scarlet - Tiny Devil Mistress Version">
                                    <div class="card-body text-center p-2">
                                        <h5 class="card-title">Remilia Scarlet<br>- Tiny Devil Mistress Version</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img src="pic/new/Witch of Scarlet Dreams Version.png" class="card-img-top" alt="Kirisame Marisa - Witch of Scarlet Dreams Version">
                                    <div class="card-body text-center p-2">
                                        <h5 class="card-title">Kirisame Marisa<br>- Witch of Scarlet Dreams Version</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img src="pic/new/MoriyaSuwako.png" class="card-img-top" alt="Kirisame Marisa - Witch of Scarlet Dreams Version">
                                    <div class="card-body text-center p-2">
                                        <h5 class="card-title">MoriyaSuwako</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>

            </div>
        </div>

        <div class="container py-5" >
            <section class="text-center py-4">
                <h2>Let customers speak for us<br>
                    ?????<br>
                </h2>
                <p>from 5 reviews</p>
            </section>
            <section class="customer-reviews py-5">
                <div id="reviewCarousel" class="carousel slide" data-ride="carousel" data-interval="3200">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="review">
                                <p><strong>Tuan Anh</strong> - ?????</p>
                                <p>"Great selection of figures and fast shipping. Will buy again!"</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="review">
                                <p><strong>Thien</strong> - ?????</p>
                                <p>"Absolutely love the figures! Quality is top-notch and service is excellent."</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="review">
                                <p><strong>Lam</strong> - ?????</p>
                                <p>"The figures are good, but the shipping took longer than expected."</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="review">
                                <p><strong>Son</strong> - ?????</p>
                                <p>"No Fumo No Life!"</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="review">
                                <p><strong>Trung</strong> - ?????</p>
                                <p>"UWOGHGHGHGHHGH HOSHINO SWIMSUIT FUMO"</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#reviewCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#reviewCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </section>
        </div>

        <footer class="text-dark py-3">
            <div class="container text-center">
                <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
                <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> <a href="mailto:huynhduclong122@gmail.com" class="text-dark">huynhduclong122@gmail.com</a></p>
                <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="phone Icon"/> <a href="tel:0934103416" class="text-dark">0934 103 416</a></p>
                <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 123 Anime Street, Otaku City, Japan</p>
            </div>
        </footer>


    </body>
</html>
