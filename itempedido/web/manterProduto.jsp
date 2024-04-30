<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UEG - Manter Produto</title>
    <link rel="stylesheet" href="./estilo.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        /* Estilos CSS personalizados podem ser adicionados aqui */
        body {
            padding: 20px;
        }
        .bloqueado {
            /* Adicione estilos personalizados para campos bloqueados */
            background-color: #f5f5f5;
            color: #333;
        }
        /* Estilo para alinhar o botão "Voltar" */
        .btn-voltar {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <br/>
    <br/>
    <br/>
    <h4>Manter dados do Produto</h4>

    <form method="POST" action="CProduto" name="manterProduto">
        <table>
            <tr>
                <td>Código</td>
                <td>
                    <!-- Input readonly para exibir o código do produto -->
                    <input type="text" readonly="readonly" name="codigo"
                           size="10" maxlength="10"
                           class="form-control bloqueado" value="${produto.codigo}"/>
                </td>
            </tr>
            <tr>
                <td>Nome</td>
                <td>
                    <!-- Input para inserir ou editar o nome do produto -->
                    <input type="text" name="nome" size="50" maxlength="50" class="form-control" value="${produto.nome}"/>
                </td>
            </tr>
            <tr>
                <td>Nome da Compra</td>
                <td>
                    <!-- Input para inserir ou editar o nome da compra do produto -->
                    <input type="text" name="nomecompra" size="50" maxlength="50" class="form-control" value="${produto.nomecompra}"/>
                </td>
            </tr>
            <tr>
                <td>Unidade de Venda</td>
                <td>
                    <!-- Input para inserir ou editar a unidade de venda do produto -->
                    <input type="text" name="unidadevenda" size="20" maxlength="20" class="form-control" value="${produto.unidadevenda}"/>
                </td>
            </tr>
            <tr>
                <td>Múltiplo de Venda</td>
                <td>
                    <!-- Input para inserir ou editar o múltiplo de venda do produto -->
                    <input type="number" name="multiplovenda" step="0.01" class="form-control" value="${produto.multiplovenda}"/>
                </td>
            </tr>
            <tr>
                <td>Data Cadastro</td>
                <td>
                    <!-- Input para inserir ou editar a data de cadastro do produto -->
                    <input type="date" name="datacadastro" class="form-control" value="${produto.datacadastro}"/>
                </td>
            </tr>
            <tr>
                <td>Status</td>
                <td>
                    <input type="checkbox" name="status"
                           <c:if test="${produto.status == true}">checked="true"</c:if>/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <!-- Botões para salvar as alterações ou voltar para a página anterior -->
                    <input type="submit" class="btn btn-primary" value="Salvar"/>
                    <input type="button" class="btn btn-secondary btn-voltar" value="Voltar" onclick="history.go(-1)"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
