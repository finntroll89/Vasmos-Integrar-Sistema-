/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Produto> listaDeProdutos = facade.findAll();
        String htmlResponse = buildHtmlResponse(listaDeProdutos);

        try (PrintWriter out = response.getWriter()) {
            out.println(htmlResponse);
        }
    }

    private String buildHtmlResponse(List<Produto> produtos) {
        StringBuilder htmlBuilder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        htmlBuilder.append("<!DOCTYPE html>")
            .append("<html>")
            .append("<head>")
            .append("<title>Lista de Produtos</title>")
            .append("</head>")
            .append("<body>")
            .append("<h1>Lista de Produtos</h1>")
            .append("<table >")
            .append("<tr><th>Nome do Produto</th><th>Preço</th></tr>");

        for (Produto produto : produtos) {
            htmlBuilder.append("<tr><td>")
                .append(produto.getNome())
                .append("</td><td>R$ ")
                .append(df.format(produto.getPrecoVenda()))
                .append("</td></tr>");
        }

        htmlBuilder.append("</table>")
            .append("</body>")
            .append("</html>");

        return htmlBuilder.toString();
    }

    @Override
    public String getServletInfo() {
        return "Servlet para listagem de produtos";
    }
}
