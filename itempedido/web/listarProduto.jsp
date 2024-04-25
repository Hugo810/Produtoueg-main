<%-- 
    Document   : listarProduto
    Created on : 26/03/2024, 20:59:42
    Author     : hugos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="./estilo.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" >

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UEG - Produtos</title>
</head>
<body>
    <br/>
    <br/>
    <br/>
    <h4>Lista de Produtos</h4>

    <form name="listarProduto" action="CProduto" method="GET">
        <div class="table-responsive-sm mb-3">
            <table class="table table-bordered table-hover table-sm" style="width:70%">
                <thead class="thead-dark">
                    <tr>                            
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Data Cadastro</th>
                        <th>Status</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lstProdutos}" var="produto">
                        <tr>
                            <td><c:out value="${produto.codigo}" /></td>
                            <td><c:out value="${produto.nome}" /></td>
                            <td><c:out value="${produto.datacadastro}" /></td>
                            <td><c:out value="${produto.statusTexto}"/></td>
                            <td><a href="CProduto?acao=alterar&codigo=${produto.codigo}" class="btn btn-primary">Alterar</a></td>
                            <td><a href="CProduto?acao=excluir&codigo=${produto.codigo}" class="btn btn-danger" onclick="return confirm('Deseja realmente excluir o produto?')">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot class="table-primary">
                    <td align="center" colspan="5">
                        <a href="CProduto?acao=incluir" class="btn btn-success">Novo produto</a>
                    </td>
                </tfoot>
            </table>
        </div>
    </form>

</body>
</html>
