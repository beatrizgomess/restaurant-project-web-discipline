<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"></head>
    <style>

        h1{
            margin-top: 10px;
            text-align: center;
        }

    </style>

</head>


<body>
<div>
    <h1>Lista de Clientes!</h1>
</div>
<table  class="table table-hover border-dark rounded-0">
    <thead>
    <tr>
        <th scope="col">CPF</th>
        <th scope="col">NOME</th>
        <th scope="col">TELEFONE</th>
        <th scope="col">EMAIL</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${cliente}" var="cliente">
    <tr>
        <td>${cliente.cpf}</td>
        <td>${cliente.name}</td>
        <td>${cliente.phone_contact}</td>
        <td>${cliente.email}</td>

    </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
