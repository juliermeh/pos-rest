package br.edu.ifpb.web;

import br.edu.ifpb.domain.cliente.Cliente;
import br.edu.ifpb.domain.produto.Produto;
import br.edu.ifpb.domain.produto.ServiceProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDeProdutos",urlPatterns = {"/produtos"})
public class ControladorDeProdutos extends HttpServlet {

    @Inject
    private ServiceProdutos service;

    // Listar todos os clientes
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> </h1>");
            listarClientes(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

// Criar um novo Cliente
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        String descricao = request.getParameter("descricao");
        Produto produto = new Produto(descricao);
        this.service.novo(produto);
        response.sendRedirect("produtos");
    }

    private void listarClientes(final PrintWriter out) {
        this.service
            .todos()
            .forEach(produto
                -> out.println("<p>" + produto.getDescricao() + "</p>")
            );
    }

}
