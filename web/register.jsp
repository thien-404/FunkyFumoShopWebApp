<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register - Anime Figure Store</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleforlogin.css"> 
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js" async defer></script>
        <script src="script/recapcha.js" async defer></script>
    </head>
    <body>
        <div class="splash" id="overplay">    
            <h1 class="splash-header"><img src="pic/gif/fumo-cirno-fumo.gif"/><br>
        </div>
        <header class="py-3 shadow">
            <div class="container text-center">
                <img src="pic/logo/headerlogo.png" height="160" width="340" alt="Logo">
            </div>
        </header>

        <div class="container d-flex flex-column justify-content-center align-items-center min-vh-100">
            <div class="row justify-content-center w-100">
                <div class="col-md-6">
                    <div class="card p-4 shadow-sm">
                        <h2 class="text-center mb-4">Register</h2>
                        <form action="MainController" method="POST">
                            <div class="form-group">
                                <label for="name">User ID</label>${requestScope.USER_ERROR.userIDError}${requestScope.USER_ERROR.iDExistedError}
                                <input type="text" class="form-control" name="userID" placeholder="Enter your userID" value="${requestScope.NEW_USER_GOOGLE.userID}" required
                                                   <c:if test="${not empty requestScope.NEW_USER_GOOGLE.userID}">readonly</c:if> 
                                                   >
                            </div>

                            <div class="form-group">
                                <label for="name">Full Name</label>${requestScope.USER_ERROR.fullNameError}
                                <input type="text" class="form-control" name="fullName" placeholder="Enter your full name" value="${requestScope.NEW_USER_GOOGLE.fullName}" required
                                             <c:if test="${not empty requestScope.NEW_USER_GOOGLE.fullName}">readonly</c:if> 
                                       >
                            </div>
                                
                            <div class="form-group">
                                <label for="email">Email address</label>${requestScope.USER_ERROR.emailError}
                                <input type="email" class="form-control" name="email" placeholder="Enter your email" value="${requestScope.NEW_USER_GOOGLE.email}" required
                                             <c:if test="${not empty requestScope.NEW_USER_GOOGLE.email}">readonly</c:if> 
                                       >
                            </div>
                                
                            <div class="form-group">
                                <label for="password">Password</label>${requestScope.USER_ERROR.passwordError}
                                <input type="password" class="form-control" name="password" placeholder="Password" required>
                            </div>
                                
                            <div class="form-group">
                                <label for="confirm-password">Confirm Password</label>${requestScope.USER_ERROR.confirmError}
                                <input type="password" class="form-control" name="confirm" placeholder="Confirm your password" required>
                            </div>
                              
                            <div id="error" class="text-danger mb-2"> ${requestScope.USER_ERROR.userErrorCreate}</div> 
                            <button type="submit" class="btn btn-primary btn-block" name="action" value="Register">Register</button>
                            <div class="text-center mt-3">
                                <p>Already have an account? <a href="MainController?action=LoginPage">Login</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <footer class="py-3 text-center">
            <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
            <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> <a href="mailto:huynhduclong122@gmail.com" class="text-white">huynhduclong122@gmail.com</a></p>
            <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="phone Icon"/> <a href="tel:0934103416" class="text-white">0934 103 416</a></p>
            <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 123 Anime Street, Otaku City, Japan</p>
        </footer>
    </body>
</html>
