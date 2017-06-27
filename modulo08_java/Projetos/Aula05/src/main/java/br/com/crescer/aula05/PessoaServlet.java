/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deordines.tomazi
 */
@WebServlet(name = "Pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    private List<String> nomes = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {

            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");

            out.append("<form action=\"/Aula05/pessoa\" method=\"POST\"><br>");
            out.append(" <input name=\"nome\" autofocus/>");
            out.append(" <input type=\"submit\" value=\"Enviar\" /><br>");
            out.append("</form>");

            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            nomes.forEach(nome -> out.append("<tr><td>").append(nome).append("</td></tr>"));
            out.append("</tbody></table>");

            out.append("</body>");
            out.append("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
            nomes.add(nome);
        }
        resp.sendRedirect("/Aula05/pessoa");
    }
}
