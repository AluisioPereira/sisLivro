/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorAmizade;
import br.com.sislivros.manager.GerenciadorGrupo;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Amizade;
import br.com.sislivros.valueobject.SolicitacaoAmizade;
import br.com.sislivros.valueobject.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        Usuario user = new Usuario();
        GerenciadorUser gUser = new GerenciadorUser();
        GerenciadorAmizade gAmizade = new GerenciadorAmizade();
        GerenciadorSolicitacaoAmizade gSolicitacaoAmizade = new GerenciadorSolicitacaoAmizade();
        GerenciadorGrupo gGrupo = new GerenciadorGrupo();
        
         try{
            String login = request.getParameter("login");
            String nick = request.getParameter("login");
            String senha = request.getParameter("password");


            user.setNick(login);
            user.setEmail(login);
            user.setSenha(senha);
            Usuario u = gUser.userLogin(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
    //        session.setMaxInactiveInterval(600);
    
            List<Usuario> listUser = gSolicitacaoAmizade.listarSolicitacoes(u.getEmail());
            List<SolicitacaoAmizade> mySolicitation = gSolicitacaoAmizade.mySolicitation(u.getEmail());
            List<Amizade> listFriends = gAmizade.listAmizade(u.getEmail());
            List<Usuario> listamizade = gAmizade.listFriends(u.getEmail());
            
            session.setAttribute("listamizade", listamizade);
            session.setAttribute("listFriend", listFriends);
            session.setAttribute("listUser", listUser);
            session.setAttribute("mySolicitation", mySolicitation);
            int qtde = gSolicitacaoAmizade.qtdeSolicitacoes(u.getEmail());
            session.setAttribute("qtde", qtde);
            session.setAttribute("group", gGrupo.listAll(u.getEmail()));
            response.sendRedirect("index.jsp");
        }finally{
        }
         
      
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
