<%-- 
    Document   : cadastro
    Created on : 4 de mai. de 2023, 10:26:21
    Author     : QI
--%>
<%@page import="model.Carro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Carro carro = (Carro)request.getAttribute("carro");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros</title>
    </head>
    <body>
        <h1>Edição</h1>
        
        <form action="CarroController" method="post">
            <input type="text" name="cod" value="<%= carro.getIdCarro() %>" readonly>
            <br><br>
            
            <input type="text" name="modelo" value="<%= carro.getModelo() %>" placeholder="Nome do carro" required>
            <br><br>
            
            <input type="text" name="cor" value="<%= carro.getCor() %>" placeholder="Nome do carro" required>
            <br><br>
            
            <input type="text" name="placa" value="<%= carro.getPlaca() %>" placeholder="Nome do carro" required>
            <br><br>
            
            <input type="submit" value="Atualizar carro">
            <input type="reset" value="Restaurar">
        </form>
        <br><br>
        <a href="index.jsp" title="Página inicial">Página inicial</a>
    </body>
</html>
