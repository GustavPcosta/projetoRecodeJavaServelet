<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cadastro de Destino</title>
</head>
<body>
    <h2>Editar Cadastro de Destino</h2>
    <form action="/ProjetoRecode/cadastroDestino/editar" method="post">
       
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" value="${destino.id}" readonly>
        <br>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${destino.nome}">
        <br>
        
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
