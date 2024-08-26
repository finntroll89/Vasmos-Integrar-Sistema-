<%@page import="java.text.DecimalFormat"%>
<%@page import="cadastroee.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
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
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
            color: #333;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-secondary {
            margin-bottom: 15px;
        }
    </style>
</head>
<body class="container">
    <%
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Produto produto = (Produto) request.getAttribute("produto");
        String acao = produto != null ? "alterar" : "incluir";
    %>
    <div class="header-section text-center">
        <h1><%=acao == "alterar" ? "Alteração" : "Cadastro"%> de Produto</h1>
    </div>
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div>
                <a class="btn btn-secondary" href="ServletProdutoFC?acao=listar">Voltar</a>
            </div>
            <form class="form-container" action="ServletProdutoFC" method="post">
                <input type="hidden" name="acao" value="<%=acao%>">
                <% if (produto != null) { %>
                    <input type="hidden" name="id" value="<%=produto.getIdProduto()%>">
                <% } %>
                <div class="mb-3">
                    <label class="form-label" for="nome">Nome</label>
                    <input class="form-control" type="text" name="nome" value="<%=produto != null ? produto.getNome() : ""%>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="quantidade">Quantidade</label>
                    <input class="form-control" type="text" name="quantidade" value="<%=produto != null ? produto.getQuantidade() : ""%>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="precoVenda">Preço de Venda</label>
                    <input class="form-control" type="text" name="precoVenda" value="<%=produto != null ? produto.getPrecoVenda() : ""%>" required>
                </div>
                <div>
                    <input class="btn btn-primary" type="submit" value="<%=acao == "incluir" ? "Cadastrar" : "Alterar"%>">
                </div>
            </form>
        </div>
    </div>
</body>
</html>