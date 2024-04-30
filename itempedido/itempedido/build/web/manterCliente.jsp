<%-- 
    Document   : manterCliente
    Created on : 26/03/2024, 20:00:09
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
        <title>UEG - Manter Cliente</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <br/>
        <br/>
        <br/>
        <h4>Manter dados do Cliente</h4>

        <form method="POST" action="CCliente" name="manterCliente">

            <table>

                <tr>
                    <td>Código</td>
                    <td>
                        <input type="text" readonly="readonly" name="codigo"
                               size="10" maxlength="10"
                               class="bloqueado" value="<c:out value="${cliente.codigo}"/>"/>
                    </td>
                </tr>

                <tr>
                    <td>Nome</td>
                    <td>
                        <input type="text"  name="nome"
                               size="50" maxlength="50"
                               value="<c:out value="${cliente.nome}"/>"/>
                    </td>
                </tr>

                <tr>
                    <td>Data Nascimento</td>
                    <td>
                        <input type="date"  name="datanascimento"
                               value="<c:out value="${cliente.datanascimento}"/>"/>
                    </td>
                </tr>

                <tr>
                    <td>Situação</td>
                    <td><input type="checkbox" name="status"
                               <c:if test="${cliente.status == true}">checked="true"</c:if>/>
                    </td>
                </tr>


                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar"/>
                        <input type="button" value="Voltar" onclick="history.go(-1)"/>
                    </td>
                </tr>


            </table>

        </form>
    </body>
</html>
