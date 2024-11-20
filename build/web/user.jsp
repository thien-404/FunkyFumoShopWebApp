<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Profile</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/stylesforshopping.css"> <!-- Reusing shopping page styles -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="script/overplay.js"></script>
    </head>
    <body>

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

        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">

                    <div class="profile-card">
                        <div class="card-header">
                            <h4 class="mb-0">Your Information</h4>
                        </div>
                        <div class="card-body">
                            <p><strong>UserID:</strong> <span id="username">${sessionScope.LOGIN_USER.userID}</span></p>
                            <p><strong>Full Name:</strong> <span id="username">${sessionScope.LOGIN_USER.fullName}</span></p>
                            <p><strong>Email:</strong> <span id="email">${sessionScope.LOGIN_USER.email}</span></p>
                            <p><strong>Role:</strong> <span id="role">${sessionScope.LOGIN_USER.roleID}</span></p>
                        </div>
                    </div>

                    <div class="profile-card">
                        <div class="card-header">
                            <h4 class="mb-0">Update Information</h4>
                            ${requestScope.MESSAGE}
                        </div>
                        <div class="card-body">
                            <form action="MainController" method="POST" id="update-form">
                                <div class="form-group">
                                    <label for="username">Full Name</label>
                                    <input type="text" id="username" name="fullName" class="form-control" value="${sessionScope.LOGIN_USER.fullName}">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" id="email" name="email" class="form-control" value="${sessionScope.LOGIN_USER.email}">
                                </div>
                                <div class="form-group">
                                    <label for="password">Current Password</label>
                                    <input type="password" id="password" name="currentPassword" class="form-control">
                                    <small class="form-text text-muted">Enter password to update profile.</small>
                                </div>
                                <div class="form-group">
                                    <label for="password">New Password</label>
                                    <input type="password" id="password" name="password" class="form-control">
                                    <small class="form-text text-muted">Leave blank if you do not want to change the password.</small>
                                </div>
                                <div class="form-group">
                                    <label for="password">Confirm Password</label>
                                    <input type="password" id="password" name="confirm" class="form-control">
                                </div>
                                <button type="submit" name="action" value="UpdateUserInfo" class="btn btn-primary">Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer class="py-3">
            <div class="container text-center">
                <p class="mb-0">&copy; 2024 Anime Figure Store. All rights reserved.</p>
                <p><img src="pic/logo/email.png" height="19" width="18.5" alt="Email Icon"/> <a href="mailto:huynhduclong122@gmail.com" class="text-white">huynhduclong122@gmail.com</a></p>
                <p><img src="pic/logo/viber.png" height="19" width="18.5" alt="phone Icon"/> <a href="tel:0934103416" class="text-white">0934 103 416</a></p>
                <p><img src="pic/logo/gps.png" height="19" width="18.5" alt="GPS Icon"/> 123 Anime Street, Otaku City, Japan</p>
            </div>
        </footer>
    </body>
</html>
