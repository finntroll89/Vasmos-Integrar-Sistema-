<%@ page import="java.text.DecimalFormat" %>
<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            background-color: #f4f4f4;
            font-family: 'Arial', sans-serif;
        }
        .header-section {
            background-color: #007bff;
            color: white;
            padding: 20px 0;
            margin-bottom: 30px;
        }
        .header-section h1 {
            margin: 0;
            font-size: 2.5rem;
        }
        .card {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .table thead {
            background-color: #007bff;
            color: white;
        }
        .table-striped tbody tr:nth-of-type(odd) {
            background-color: rgba(0,123,255,.1);
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-sm {
            padding: .25rem .5rem;
            font-size: .875rem;
            line-height: 1.5;
            border-radius: .2rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header-section text-center">
            <h1>Listagem de Produtos</h1>
        </div>

        <div class="card">
            <div class="card-body">
                

                <table class="table table-striped table-bordered table-responsive">
                    <thead>
                        <tr class="table-dark">
                            <th>ID</th>
                            <th>Produto</th>
                            <th>Quantidade</th>
                            <th>Preço</th>
                            <th>Ações</th>
                        </tr>
                    </thead>

                    <%
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");

                        if (produtos != null && !produtos.isEmpty()) {
                            for (Produto produto : produtos) {
                    %>
                    <tr>
                        <td class="text-center"><%=produto.getIdProduto()%></td>
                        <td class="text-center"><%=produto.getNome()%></td>
                        <td class="text-center"><%=produto.getQuantidade()%></td>
                        <td class="text-center">R$ <%=df.format(produto.getPrecoVenda())%></td>
                        <td class="text-end">
                            <a class="btn btn-primary btn-sm" href="ServletProdutoFC?acao=formAlterar&id=<%=produto.getIdProduto()%>">Alterar</a>
                            <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&id=<%=produto.getIdProduto()%>">Excluir</a>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">Nenhum produto encontrado.</td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                
                <div class="text-end mb-3">
                    <a class="btn btn-primary" href="ServletProdutoFC?acao=formIncluir">Cadastrar Produto</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>