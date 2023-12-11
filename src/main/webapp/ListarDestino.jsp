<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Cadastros de Destino</title>
</head>
<body>
    <h2>Listar Cadastros de Destino</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach var="destino" items="${cadastrosDestino}">
                <tr>
                    <td>${destino.id}</td>
                    <td>${destino.nome}</td>
                   
                    <td><a href="<%= request.getContextPath() %>/cadastroDestino/editar?id=${destino.id}">Editar</a></td>
                    <td><a href="<%= request.getContextPath() %>/cadastroDestino/remover?id=${destino.id}">Remover</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
