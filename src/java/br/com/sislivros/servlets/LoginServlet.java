/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zilderlan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         try{
            String login = request.getParameter("login");
            String nick = request.getParameter("login");
            String senha = request.getParameter("password");

            Usuario user = new Usuario();
            user.setNick(login);
            user.setEmail(login);
            user.setSenha(senha);
            GerenciadorUser gUser = new GerenciadorUser();
            Usuario u = gUser.userLogin(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
    //        session.setMaxInactiveInterval(600);
            GerenciadorSolicitacaoAmizade gerenciador = new GerenciadorSolicitacaoAmizade();
            List<Usuario> list = gerenciador.listarSolicitacoes(u.getEmail());
            session.setAttribute("listSolic", list);
            int qtde = gerenciador.qtdeSolicitacoes(u.getEmail());
            session.setAttribute("qtde", qtde);

            response.sendRedirect("index.jsp");
        }finally{
        }
         
      
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
