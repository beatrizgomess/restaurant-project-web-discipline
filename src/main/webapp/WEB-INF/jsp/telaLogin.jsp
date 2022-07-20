<%--
  Created by IntelliJ IDEA.
  User: bea
  Date: 18/07/2022
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Title</title>
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .main-head{
            height: 150px;
            background: #FFF;

        }

        .sidenav {
            height: 100%;
            background-color: #000;
            overflow-x: hidden;
            padding-top: 20px;
        }


        .main {
            padding: 0px 10px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
        }

        @media screen and (max-width: 450px) {
            .login-form{
                margin-top: 10%;
            }

            .register-form{
                margin-top: 10%;
            }
        }

        @media screen and (min-width: 768px) {
            .main {
                margin-left: 40%;
            }

            .sidenav {
                width: 40%;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
            }

            .login-form {
                margin-top: 80%;
            }

            .register-form {
                margin-top: 20%;
            }
        }


        .login-main-text{
            margin-top: 20%;
            padding: 60px;
            color: #fff;
        }

        .login-main-text h2{
            font-weight: 300;
        }

        .btn-black{
            background-color: #000 !important;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="sidenav">
    <div class="login-main-text">
        <h2>Application<br> Spring MVC</h2>
        <p>Sistema de Restaurante</p>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form action="/telaLogin" method="post">
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" name="email" class="form-control" placeholder="User Name">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <button onclick="window.location.href='/menu-modelPratos'" type="submit" class="btn btn-black">Login</button>
                <button type="button" name="button" class="btn login_btn" onclick="window.location.href='/telaCadastro'">Cadastre-se</button>
            </form>

            <br>
            <br>
            ${msg1}
            <br>
            ${msg2}

            ${msg}
            ${msg3}
        </div>
    </div>
</div>
<form action="/telaLogin" method="post">

    <label>Email:</label>
    <input type="text" name="email" />
    <br>
    <label>Senha:</label>
    <input type="password" name="password" />
    <br>

    <button onclick="window.location.href='/menu-modelPratos'">Login</button>
    <br>

</form>
</body>
</html>
