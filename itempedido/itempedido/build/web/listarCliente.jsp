<%-- 
    Document   : listarCliente
    Created on : 26/03/2024, 19:59:42
    Author     : heube
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="./estilo.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" >

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UEG - Clientes</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <br/>
        <br/>
        <br/>
        <h4>Lista de Clientes</h4>

        <form name="listarCliente" action="CCliente" method="GET">
            <div class="table-responsive-sm mb-3">
                <table class=" table table-bordered table-hover table-sm" style="width:70%">
                    <thead class="thead-dark">
                        <tr>                            
                            <th>Código</th>
                            <th>Nome</th>
                            <th>Data Nascimento</th>
                            <th>Status</th>
                            <th colspan="2" align="center">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lstClientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.codigo}" /></td>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><c:out value="${cliente.dataFormatada}" /></td>
                                <td><c:out value="${cliente.statusTexto}" /></td>
                                <td><a href="CCliente?acao=alterar&codigo=<c:out value="${cliente.codigo}" />"> Alterar</a></td>
                                <td><a href="CCliente?acao=excluir&codigo=<c:out value="${cliente.codigo}" />" 
                                       onClick="return confirm('Deseja realmente excluir o cliente?')"> Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot class="table-primary">
                        <td align="center" colspan="6">
                            <a href="CCliente?acao=incluir" >Novo Cliente</a>
                        </td>
                    </tfoot>
                </table>
            </div>
        </form>

    </body>
</html>
