<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Anime Figure Store</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleforlogin.css"> <!-- Add your custom styles here -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js" async defer></script>

    </head>
    <body>
        <div class="splash" id="overplay">    
            <h1 class = "splash-header"><img src="pic/gif/fumo-cirno-fumo.gif"/><br>
        </div>
        <header class="text-white py-3 shadow">
            <div class="container text-center">
                <img src="pic/logo/headerlogo.png" height="160" width="340" alt="Logo">
            </div>
        </header>


        <div class="container d-flex flex-column justify-content-center align-items-center min-vh-100">
            <div class="row justify-content-center w-100">
                <div class="col-md-6">
                    <div class="card p-4 shadow-sm">
                        <h2 class="text-center mb-4">Login</h2>
                        <form action="MainController" method="POST" id="login">
                            <div class="form-group">
                                <label for="email">User ID / Email</label>
                                <input type="text" class="form-control" id="email" placeholder="Enter User ID / Email" name="userID" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                            </div>
                            <div class="form-group">
                                <div class="g-recaptcha" data-sitekey="6LdlxgkqAAAAAIINRqAf3kZhbsJ58UbJN5bcA4Y_"></div> 
                            </div>
                            <div id="error" class="text-danger mb-2"></div>
                            <button type="button" class="btn btn-primary btn-block" onclick="checkReCAPTCHA()">Login</button>
                            <input type="hidden" name="action" value="Login"/>
                            <div class="text-center mt-3">
                                <button type="button" class="btn btn-light">
                                    <a  href="https://accounts.google.com/o/oauth2/auth?scope=openid%20profile%20email&redirect_uri=http://localhost:8084/Assignment_Block3W/GoogleLoginController&response_type=code&client_id=201948420053-6olu5k7oc8omtnf6mvl1vhjm3a1v9d4m.apps.googleusercontent.com&approval_prompt=force">
                                                                   <img src="pic/logo/icons8-google-48.png" height="20" width="20" alt="Google Icon"/> Sign in with Google         
                                    </a>

                                </button>
                                <p class="mt-3">New to this page? <a href="MainController?action=RegisterPage">Register</a></p>
                                ${requestScope.MESSAGE}
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <footer class="text-white py-3 text-center">
            <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
            <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> <a href="mailto:huynhduclong122@gmail.com" class="text-white">huynhduclong122@gmail.com</a></p>
            <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="phone Icon"/> <a href="tel:0934103416" class="text-white">0934 103 416</a></p>
            <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 123 Anime Street, Otaku City, Japan</p>
        </footer>

        
                <script type="text/javascript">
                function checkReCAPTCHA() {
                    var form = document.getElementById("login");
                    const response = grecaptcha.getResponse();
                    var error = document.getElementById("error");
                    if (response) {
                        form.submit();
                    } else {
                        error.textContent = "Why you don't do reCAPTCHA? Me very sad. Please do it ?????";
                    }
                }
        </script>
                <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </body>
</html>
