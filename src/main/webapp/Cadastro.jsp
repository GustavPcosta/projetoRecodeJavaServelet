<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usuário</title>
</head>
<body>
    <h2>Cadastrar Usuário</h2>
    <form action="/ProjetoRecode/usuario/cadastrar" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
