<%-- 
    Document   : Home
    Created on : Sep 14, 2022, 5:03:22 PM
    Author     : 84877
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const videos = document.querySelectorAll(".bannerVideo video");
                let currentVideoIndex = 0;

                function playVideo() {
                    for (let i = 0; i < videos.length; i++) {
                        if (i === currentVideoIndex) {
                            videos[i].classList.add("active");
                            videos[i].play();
                        } else {
                            videos[i].classList.remove("active");
                            videos[i].pause();
                        }
                    }

                    currentVideoIndex = (currentVideoIndex + 1) % videos.length;

                    setTimeout(playVideo, videos[currentVideoIndex].duration * 1000);
                }

                playVideo(); // Bắt đầu vòng lặp video
            });
        </script>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technology-Shop</title>
    </head>
    <link href="Views/css/styles.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="Views/css/bootstrap.min.css" rel="stylesheet">
    <link href="Views/css/bootstrap.css" rel="stylesheet">
    <!--<link rel="stylesheet" href="Views/css/stylehome.css">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <style>

        #fixNav{
            width: 100%;
            height: 45px;
            background-color: #0082bb;
            display: block;
            box-shadow: 0px 2px 2px rgba(0,0,0,0.5); /*Đổ bóng cho menu*/
            position: fixed; /*Cho menu cố định 1 vị trí với top và left*/
            top: 0; /*Nằm trên cùng*/
            left: 0; /*Nằm sát bên trái*/
            z-index: 100000; /*Hiển thị lớp trên cùng*/
        }
        #fixNav ul{
            margin: 0 50px;
            padding: 0;
        }
        #fixNav ul li{
            list-style:none inside;
            width: auto;
            float: left;
            line-height: 45px; /*Cho text canh giữa menu*/
            color: #fff;
            padding: 0;
            margin-right:10px;
            position: relative;
        }
        #fixNav ul li a{
            text-transform: uppercase;
            white-space: nowrap; /*Cho chữ trong menu không bị wrap*/
            padding: 0 10px;
            color: #fff;
            display: block;
            font-size: 0.8em;
            text-decoration: none;
        }
        /*CSS Style cho Submenu*/
        #fixNav ul li ul {
            position: absolute;
            width: auto;
            display: none;
            background-color: #252525;
            border-bottom: 3px solid #0082bb;
            padding-left: 5px;
        }

        #fixNav ul li ul li{
            display: block;
            padding:0;
            margin: 0;
            float: none; /*Bỏ float cho li cấp thứ 2*/
        }
        /* Hover cho submenu */
        #fixNav ul li:hover {
            /* Hover thì li sẽ đổi màu*/
            background-color: #252525;
        }
        #fixNav ul li:hover ul{
            /*Display ra submenu*/
            display: block;
        }

        .banner img{
            width: 100%;
            height: 400px;
            margin-top: 45px;

        }
        .container-fluid{
            /*border: 1px solid black;*/
        }
        .listproduct{
            height: 80%;
            width: 90%;
            margin-top: 20px;
            margin-left: 120px;
            /*border: 1px solid black;*/
        }
        .card-product{
            width: 255px;
            height: 400px;
            margin: 10px 30px;
            border: 1px;
            border-radius: 10px;
            box-shadow: 0px 0px 5px gray;
        }

        .card-product:hover{

            box-shadow: 0px 0px 10px #0082bb;

        }

        .card-product img{
            margin-left: -15px;
            width: 250px;
            height: 50%;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .product-info{
            width: 100%;
            margin-top: 30px;
        }
        .product-info a{
            text-decoration: none;
            color: black;
            font-size: 20px;
        }

        .product-info h5{
            text-align: center;
        }
        .product-info button{
            background-color: black;
            color: white;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            box-shadow: 0px 0px 5px gray;
        }

        .product-info button:hover{
            box-shadow: 0px 0px 10px #0082bb;

        }

        .cart {
            width: 100px;
            height: 30px;
            position: fixed;
            bottom: 100px;
            right: 20px;
            background-color: transparent;
            border: none;
            text-align: center;
            z-index: 100;
        }

        .cart i {
            font-size: 40px; /* Giữ nguyên kích thước biểu tượng */
            text-shadow: 0px 0px 8px gray;
            border: none;
        }

        .cart i:hover {
            text-shadow: 0px 0px 8px #0082bb;
        }





        .footer{
            background-color: black;
            color: white;
            width: 100%;
            height: 140px;
            text-align: center;
            padding: 20px;
            margin-top: 30px;
            clear: both;
        }
        .search-form{
            margin-top: 10px;
            margin-left: 1250px;
        }
        .page{
            margin-left: 0px;
        }
        .btnIndex{
            border-radius: 5px;
            background-color: black;
            color: white;
        }
        .btnIndex:hover{
            box-shadow: 0px 0px 5px #0082bb;
        }
        .name:hover{
            color: blue;
        }
    </style>

    <body>
        <div id="fixNav">
            <ul>
                <li><a href="/Technology_Shop/home">Home</a></li>
                    <c:if test="${acc.isAdmin}">               
                    <li><a href="/Technology_Shop/admin/Manager">Manager</a></li>
                    <li><a href="/Technology_Shop/admin/order">Order</a></li>
                    <li><a href="Views/ShowSalary.jsp">Salary</a></li>
                    <li><a href="/Technology_Shop/admin/CreateControl">Create admin</a></li>
                    </c:if>              
                    <c:if test="${acc==null}">                   
                    <li><a href="Views/login.jsp">Login</a></li>
                    </c:if>
                    <c:if test="${acc!=null}">
                    <li><a style="color: yellow;" href="/Technology_Shop/UpdateAccount?username=${acc.username}">${acc.fullname}</a></li>
                    <li><a href="/Technology_Shop/logout">Logout</a></li>

                </c:if>    
                <li>
                    <a href="#">Category</a>
                    <ul class="sub-menu">
                        <c:forEach items="${category}" var="c">                            
                            <li><a href="/Technology_Shop/search?categoryId=${c.categoryId}">${c.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </li>
            </ul>
            <div class="search-form">
                <form action="/Technology_Shop/search" method="post" style="margin:auto;max-width:300px">
                    <input type="text" placeholder="Search.." name="search" value="${contentSearch}">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>

        <div class="bannerVideo" id="slideshow">
            <video src="video/y2mate.com - Introducing Surface Laptop 5_1080p.mp4" autoplay muted loop class="active" width="100%" height="auto"></video>
        </div>

        <h2 style="text-align: center; color: #00c6ff; height: 100px; font-size: 80px" >List of Product</h2>
        <div class="container-fluid row">      
            <div class="listproduct col-md-10 row">
                <c:if test="${notFound!=null}">
                    <h2 style="color: red; margin-bottom: 100px; text-align: center;">${notFound}</h2>
                </c:if>      
                <c:if test="${cannotAdd!=null}">
                    <h2 style="color:red;">${cannotAdd}</h2>
                </c:if> 
                <c:forEach items="${product}" var="p">
                    <div class=" card-product col-md-3">
                        <img src="${p.image}"/>
                        <div class="product-info">                   
                            <h5><a class="name" href="/Technology_Shop/detail?pid=${p.id}">${p.name}</a></h5>
                            <h5>${p.price} $</h5>
                            <c:choose>
                                <c:when test="${empty acc}">
                                    <a href="Views/login.jsp">
                                        <button type="submit" style="width: 150px; margin-left: 30px;">Add to Cart</button>
                                    </a>
                                </c:when>
                                <c:when test="${!empty acc and acc.isAdmin}">
                                    <!-- If the user is logged in as an admin, you can add your admin-specific logic here -->
                                    <a href="/Technology_Shop/admin/Update?pid=${p.id}">
                                        <button type="submit" style="width: 150px; margin-left: 30px;">Edit</button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="addToCart?pid=${p.id}&username=${acc.username}">
                                        <button type="submit" style="width: 150px; margin-left: 30px;">Add to Cart</button>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                </c:forEach>
                <div class="page">
                    <form action="home" method="POST">
                        <c:if test="${config.pageIndex!=null}">
                            <c:if test="${config.pageIndex-2>1}">
                                <button class="btnIndex" type="submit" name="page" value="1">Home</button>
                            </c:if>  

                            <c:forEach begin="${config.pageStart}" end="${config.pageEnd}" var="i">
                                <button class="btnIndex" type="submit" name="page" style="background-color: ${i==config.pageIndex ? "blue" : ""}" value="${i}">${i}</button>
                            </c:forEach> 
                            <c:if test="${config.pageIndex-2<1}">
                                <button class="btnIndex" type="submit" name="page" value="${config.totalPage}">End</button>
                            </c:if> 
                        </c:if> 
                    </form>
                </div>     
            </div>
            <div class="cart col-md-2">
                <c:if test="${acc!=null}">
                    <c:if test="${!acc.isAdmin}">
                        <form action="addToCart" method="post" class="d-flex">
                            <input name="username" value="${acc.username}" hidden=""/>
                            <button class="btn" type="submit">
                                <i class="bi-cart-fill me-1"></i> 
                                <div calss="num">
                                    <span class="badge bg-dark text-white ms-1 rounded-pill">${num}</span>
                                </div>
                            </button>
                        </form>  
                    </c:if>
                </c:if>
            </div>
        </div>

        <div class="footer">
            <p>Phone: 0332526273</p>
            <p>Mail: leha104203@gmail.com</p>
        </div>
    </body>
</html>
