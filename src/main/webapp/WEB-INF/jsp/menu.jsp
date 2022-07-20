<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style>

    h1{
        margin-top: 10px;
        text-align: center;
    }

    </style>


</head>
<body>


<div>
    <h1>Lista de Pratos!</h1>
</div>

<table  class="table table-hover border-dark rounded-0">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NOME</th>
        <th scope="col">DESCRIÇÃO</th>
        <th scope="col">PREÇO</th>
        <th scope="col">SELECIONAR</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${prato}" var="prato">
    <tr>
        <td>${prato.id}</td>
        <td>${prato.name}</td>
        <td>${prato.description}</td>
        <td>${prato.price}</td>
        <td><button class="btn btn-outline-secondary" onclick="window.location.href='/menu-modelPedido'">Fazer Pedido</button></td>
        ${msg}
    </tr>
    </c:forEach>
    </tbody>
    <br>


</table>
<a href="/historicoPedidosCliente"><input type="button" class="btn btn-outline-secondary" value="Meus Pedidos"></a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
