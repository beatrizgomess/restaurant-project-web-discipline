<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>



<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<div class="container">
    <h2 class="text-center text-white">Finalizar Pedido</h2>
    <div class="row justify-content-center">
        <div class="col-12 col-md-8 col-lg-6 pb-5">


            <!--Form with header-->

            <form action="/fazerPedido" method="post">
                <div class="card border-dark rounded-0">
                    <div class="card-header p-0">
                        <div class="bg-dark text-white text-center py-2">
                            <h3><i class="fa fa-envelope"></i> Pedido</h3>
                            <p class="m-0">Sistema Restaurante</p>
                        </div>
                    </div>
                    <div class="card-body p-3">

                        <!--Body-->
                        <div class="form-check form-check-inline">
                            <c:forEach items="${pagamento}" var="lista">
                                <input class="form-check-input" id="inlineRadio1" type="radio" name="id" value="${lista.id}">${lista.description}</input>
                            </c:forEach>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-envelope text-dark"></i></div>
                                </div>
                                <input type="text" class="form-control" id="id_prato" name="id_prato" placeholder="Id do prato" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="bi bi-fingerprint"></i></div>
                                </div>
                                <input type="text" class="form-control" id="cpf" name="cpf_cliente" placeholder="CPF" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-user text-dark"></i></div>
                                </div>
                                <input type="text" class="form-control" id="name" name="note" placeholder="Observação" required>
                            </div>
                        </div>

                        <div class="text-center">
                            <button class="btn btn-outline-secondary" onclick="window.location.href='/telaLogin'">Fazer Pedido</button>
                            <button class="btn btn-outline-secondary" onclick="location.href='/telaLogin'">Voltar</button>
                        </div>
                    </div>

                </div>
            </form>
            <!--Form with header-->


        </div>
    </div>
</div>

</body>
</html>
