<%-- 
    Document   : menu
    Created on : 09/04/2024, 19:24:44
    Author     : heube
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/estilo.css">

<div class="topnav" id="menu">
    <a href="index.jsp">Home</a>
    <a href="CCliente?acao=listar">Cliente</a>
    <a href="CProduto?acao=listar">Produto</a>
    <a href="">...</a>

</div>
