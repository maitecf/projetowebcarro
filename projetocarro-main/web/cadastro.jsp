<%-- 
    Document   : cadastro
    Created on : 4 de mai. de 2023, 10:26:21
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros</title>
    </head>
    <body class="cadastro">
        <h1>Cadastro</h1>
        <h2>Novo Veículo</h2>
        <form action="CarroController" method="post" class="formulario">
            
            <input type="text" name="modelo" placeholder="Modelo" required>
            <br><br>
            
            <input type="text" name="cor" placeholder="Cor" required>
            <br><br>
            
            <input type="text" name="placa" placeholder="Placa" required>
            <br><br>
            
            <input type="submit" value="Salvar">
            
            </form>
        <br><br>
        <button class="botao">
        <a href="index.jsp" title="Página inicial">Página inicial</a>
        
        </button>
    </body>
</html>
