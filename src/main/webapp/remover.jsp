<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Usuario</title>
</head>
<body>
    <h2>Edit Usuario</h2>
    <form action="/ProjetoRecode/usuario/editar" method="post">
        <input type="hidden" name="id" value="${usuario.id}">
        
        
        <button type="submit">remover</button>
    </form>
</body>
</html>
