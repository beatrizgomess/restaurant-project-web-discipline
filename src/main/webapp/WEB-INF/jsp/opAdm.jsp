<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Cliente</title>
    <style>
        body{
            background-color: black;
        }
        #corCard{
            background-color: black;
        }
    </style>
</head>

<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<div class="container">
    <h2 class="text-center text-white">Formulario de Cadastro</h2>
    <div class="row justify-content-center">
        <div class="col-12 col-md-8 col-lg-6 pb-5">


            <!--Form with header-->
                <div class="card border-dark rounded-0">
                    <div class="card-header p-0">
                        <div class="bg-dark text-white text-center py-2">
                            <h3><i class="fa fa-envelope"></i> Cadastre um prato</h3>
                            <p class="m-0">Sistema Restaurante</p>
                        </div>
                    </div>
                    <div class="card-body p-3">

                        <!--Body-->
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"></div>
                                </div>
                                <button  class="btn btn-dark btn-block rounded-0 py-2"  onclick="window.location.href='/opAdm-model'">Cadastrar Prato</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"></div>
                                </div>
                                <button  class="btn btn-dark btn-block rounded-0 py-2"  onclick="window.location.href='/opAdm'">Visualizar Clientes</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"></div>
                                </div>
                                <button  class="btn btn-dark btn-block rounded-0 py-2"  onclick="window.location.href='/opAdm-modelPaymenth'">Cadastrar Forma de pagamento</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"></div>
                                </div>
                                <button type="button" class="btn btn-dark btn-block rounded-0 py-2"  onclick="location.href='../..'">Sair</button>
                                <br>
                                <br>
                                ${msg}
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>








</body>
</html>
