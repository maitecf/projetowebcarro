<%-- 
    Document   : lista
    Created on : 4 de mai. de 2023, 10:26:28
    Author     : QI
--%>

<%@page import="model.CarroDAO" %>
<%@page import="model.Carro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game</title>
    </head>
    <body>
        <h1>Lista</h1>
            <table>
                <thead>
                    <th>COD</th>
                    <th>MODELO</th>
                    <th>COR</th>
                    <th>PLACA</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
            
        <%
                CarroDAO mapaDao = new CarroDAO();
                
                //Para cada elemento da lista (mapaDao.listCarro)
                //chame-o de "item"
                for(Carro item : mapaDao.listCarro()){
                    %>
                  <tr>
                    <td><%= item.getIdCarro() %></td>
                    <td><%= item.getModelo()%></td>
                    <td><%= item.getCor()%></td>
                    <td><%= item.getPlaca()%></td>
                    <td>
                        <a href="CarroUpdate?cod=<%= item.getIdCarro() %>"  >📝</a>
                    </td>
                    <td>
                        <a onclick="confirmaDelete(<%= item.getIdCarro() %>)">❌</a>
                    </td>
                  </tr>
               <%
                }
           %>
                </tbody>
           </table>
        <hr>
        <a href="index.jsp" title="Página inicial">Página inicial</a>
    
    <script>
        function confirmaDelete(id){
            if(confirm("Deseja realmente excliur?")){
                window.location.replace("CarroDelete?cod=" + id);
            } else {
                alert("Exclusão cancelada.");
            }
        }
      </script>
        
    </body>
</html>
