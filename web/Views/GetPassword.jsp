<%-- 
    Document   : GetPassword
    Created on : Oct 19, 2022, 2:43:57 PM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .form{
            width: 530px;
            height: 750px;
            box-shadow: 0px 0px 5px #0082bb;
            border-radius: 10px;
            margin: 100px 400px;
            padding: 10px 10px;
        }
        .form-field{
            /*border: 1px solid black;*/
            margin: 25px 70px;
        }
        .btn{
            background-color: black;
            color: white;
            border-radius: 5px;
            width: 70px;
            height: 30px;
            margin: -5px 30px;
        }
        .btn:hover{
            box-shadow: 0px 0px 5px #0082bb;
        }
        .form-input{
            border: 1px solid blue;
            margin: 10px 20px;
            width: 300px;
            height: 40px;
            padding: 0 20px;
        }

        .form-input:focus{
            border-color: #0082bb;
            box-shadow: 0px 0px 5px #0082bb;
        }
        a{
            position: absolute;
            left: 830px;
            top: 805px;
        }
        .btnlogin{
            right: 30px;
            padding: 10px 10px;
            border-radius: 20px;
            margin: 70px 30px;
            border: 2px solid black;
            background-color: #0082bb;
            color: white;
        }
    </style>
    <body>
        <div class="form">
            <h1 style="text-align: center;">Forget Password</h1>
            <form action="/Technology_Shop/GetPassword" method="post">
                <div class="form-field">
                    <h3>UserName<h3>
                            <input type="text" class="form-input" name="username" required="" placeholder="username"/>
                            </div>
                            <div class="form-field"> <h3>Question</h3>
                                <select class="form-input" id="question" name="question" style="width: 300px;">
                                    <c:forEach items="${question}" var="q">
                                        <option value="${q.questionId}">${q.content}</option>                        
                                    </c:forEach>                
                                </select>
                            </div>
                            <div class="form-field">
                                <h3>Answer:</h3>
                                <input class="form-input" required="" name="answer" type="password" value="" placeholder="answer.."/>
                            </div>
                            <div class="form-field">
                                <h3>New Password</h3>
                                <input type="password" class="form-input" name="newpassword" minlength="6" maxlength="31" required="" placeholder="password"/>
                            </div>
                            <div class="form-field">
                                <h3>Re-NewPassword</h3>
                                <input type="password" class="form-input" name="renewpassword" value="" placeholder="re-password"/>
                            </div>
                            <p style="color: red; margin: 0px 50px;">${mess}</p>
                            <button class="btn" type="submit" >Submit</button> 
                            </form>
                            <a class="btn" style="text-decoration: none;text-align: center;margin-top: 20px;" href="Views/login.jsp" type="submit" value="Login">Log in</a>
                            </div>
                            </body>
                            </html>
