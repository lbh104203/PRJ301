<%-- 
    Document   : login
    Created on : Sep 26, 2022, 7:28:50 AM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <!--<link rel="stylesheet" href="css/logins.css">-->
    <style>
        .login{
            width: 350px;
            height: 615px;
            background-color: white;
            box-shadow: 0px 0px 10px #0082bb;
            border-radius: 10px;
            padding: 50px;
            margin: 0 auto;
            margin-top: 15px;
            color: black;
        }

        .logo img{
            width: 70px;
            height: 70px;
            margin-left: 120px;
            margin-top: -10px;
        }

        .form-input{
            padding: 20px;
            border: 1px solid blue;
            margin: 10px 20px;
            border-radius: 20px;
            width: 300px;
            height: 50px;
            padding: 0 20px;
        }

        .form-input:focus{
            border-color: #0082bb;
            box-shadow: 0px 0px 5px #0082bb;
        }

        .form-field{
            position: relative;

        }
        .btn{
            position: relative;
            top: 0px;
            left: 73px;
            width: 100px;
            height: 40px;
            border-radius: 20px;
            background-color: #0082bb;
            color: white;
        }
        .btnHome{
            position: relative;
            right: 30px;
            padding: 10px 10px;
            border-radius: 20px;
            margin: 70px 30px;
            border: 2px solid black;
            background-color: #0082bb;
            color: white;
        }
        .btnHome:hover{
            box-shadow: 0px 0px 10px #0082bb;
        }
        .btnLoginwithGG{
            position: relative;
            right: -15px;
            margin: 10px 78px;
            border: 2px solid black;
        }
        .btnLoginwithGG:hover{
            box-shadow: 0px 0px 10px #0082bb;
        }
        .signup{
            margin-left: 80px;
            margin-top: 20px;
        }
        .forget{
            text-align: justify;
            margin: 10px 118px;
        }
        .action{
            margin-bottom: 30px;
        }

    </style>
    <body>
        <div class="login">
            <h1 style="text-align: center;">Login</h1>

            <form class="action" action="/Technology_Shop/login" method="post">
                <div class="form-field">
                    <h3>Username<h3>
                            <input type="text" class="form-input" name="username" placeholder="username"/>
                            </div>
                            <div class="form-field">
                                <h3>Password</h3>
                                <input type="password" class="form-input" name="password" placeholder="password"/>
                            </div>
                            <p style="color: black;"><input style=" display: inline-block" type="checkbox" name="remember" value="on" ${cookie.crem != null ?'checked':''} />Remember me</p>
                            <div>
                                <h3 class="text-danger">${mess}</h3>
                            </div>

                            <div style="background: green; text-decoration: none; text-align: center;" class="btnLoginwithGG">
                                <a href="https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?scope=email profile&redirect_uri=http%3A%2F%2Flocalhost%3A9999%2FTechnology_Shop%2Flogin&response_type=code&client_id=782277117461-lg10v0nkrua8sc4eucjk872de74b7de4.apps.googleusercontent.com&approval_prompt=force&service=lso&o2v=1&theme=glif&flowName=GeneralOAuthFlow" 
                                   ><i class="display-flex-center zmdi zmdi-google"></i><h2 
                                        style="color: white;">Login with Google</h2></a>
                            </div>

                            <p style="color: red;">${error}</p>
                            <a class="btnHome" href="/Technology_Shop/home" style="text-decoration: none; text-align: center;">Return to home</a>
                            <button class="btn" type="submit">Login</button> 
                            </form>

                            <a class="forget" href="/Technology_Shop/GetPassword">Forget password?</a>
                            <div class="signup">
                                Do you have an account? <a href="/Technology_Shop/signUp">Sign up</a>
                            </div>
                            </div>
                            </body>
                            </html>
