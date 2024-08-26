/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;
import java.io.IOException;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = handleGetAction(acao, request);
        dispatchRequest(request, response, destino);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        acao = acao == null || acao.isEmpty() ? " " : acao;
        String destino = handlePostAction(acao, request);
        dispatchRequest(request, response, destino);
    }

    private String handleGetAction(String acao, HttpServletRequest request) {
        switch (acao) {
            case "formIncluir":
                return "ProdutoDados.jsp";
            case "excluir":
                return handleExcluir(request);
            case "formAlterar":
                return handleFormAlterar(request);
            default:
                return handleListarProdutos(request);
        }
    }

    private String handlePostAction(String acao, HttpServletRequest request) {
        switch (acao) {
            case "incluir":
                return handleIncluir(request);
            case "alterar":
                return handleAlterar(request);
            default:
                return handleListarProdutos(request);
        }
    }

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String destino)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    // Métodos auxiliares para lidar com cada ação
    private String handleExcluir(HttpServletRequest request) {
        int idDel = Integer.parseInt(request.getParameter("id"));
        facade.remove(facade.find(idDel));
        return handleListarProdutos(request);
    }

    private String handleFormAlterar(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = facade.find(id);
        request.setAttribute("produto", produto);
        return "ProdutoDados.jsp";
    }

    private String handleListarProdutos(HttpServletRequest request) {
        List<Produto> produtos = facade.findAll();
        request.setAttribute("produtos", produtos);
        return "DbLista.jsp";
    }

    private String handleIncluir(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        Float precoVenda = Float.valueOf(request.getParameter("precoVenda"));

        Produto newProduto = new Produto();
        newProduto.setNome(nome);
        newProduto.setQuantidade(quantidade);
        newProduto.setPrecoVenda(precoVenda);

        facade.create(newProduto);
        return handleListarProdutos(request);
    }

    private String handleAlterar(HttpServletRequest request) {
        Produto alterarProduto = facade.find(Integer.valueOf(request.getParameter("id")));

        String alterarNome = request.getParameter("nome");
        int alterarQuantidade = Integer.parseInt(request.getParameter("quantidade"));
        Float alterarPrecoVenda = Float.valueOf(request.getParameter("precoVenda"));

        alterarProduto.setNome(alterarNome);
        alterarProduto.setQuantidade(alterarQuantidade);
        alterarProduto.setPrecoVenda(alterarPrecoVenda);

        facade.edit(alterarProduto);
        return handleListarProdutos(request);
    }
}
