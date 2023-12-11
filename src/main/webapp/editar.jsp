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
        
        <label for="email">Email:</label>
        <input type="text" id="text" name="text" value="${usuario.nome}">
        <br>
        
        <label for="senha">Senha:</label>
        <input type="email" id="email" name="email" value="${usuario.email}">
        <br>
        
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${usuario.senha}">
        <br>
        
        <button type="submit">Update</button>
    </form>
</body>
</html>
