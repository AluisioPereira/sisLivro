/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorAmizade;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.valueobject.Amizade;
import br.com.sislivros.valueobject.SolicitacaoAmizade;
import br.com.sislivros.valueobject.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "TornarAmigo", urlPatterns = {"/tornarAmigo"})
public class TornarAmigo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario)session.getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        
        GerenciadorAmizade gAmizade = new GerenciadorAmizade();
        GerenciadorSolicitacaoAmizade gSolicitacaoAmizade = new GerenciadorSolicitacaoAmizade();
        
        gAmizade.addFriend(request.getParameter("param1"), request.getParameter("param2"));
        gSolicitacaoAmizade.excluirSolicitacao(request.getParameter("param1"), request.getParameter("param2"));
        
        
        
        List<Usuario> listUser = gSolicitacaoAmizade.listarSolicitacoes(user.getEmail());
        List<SolicitacaoAmizade> mySolicitation = gSolicitacaoAmizade.mySolicitation(request.getParameter("param2"));
        List<Amizade> listFriends = gAmizade.listAmizade(request.getParameter("param2"));
        List<Usuario> listamizade = gAmizade.listFriends(user.getEmail());
        
        session.setAttribute("listamizade", listamizade);
        session.setAttribute("listUser", listUser);
        session.setAttribute("listFriend", listFriends);
        session.setAttribute("mySolicitation", mySolicitation);
        int qtde = gSolicitacaoAmizade.qtdeSolicitacoes(user.getEmail());
        session.setAttribute("qtde", qtde);
        response.sendRedirect(request.getParameter("p"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TornarAmigo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Parâmetro enviado: " + request.getParameter("param1") + "</h1>");
            out.println("<h1>Parâmetro enviado: " + request.getParameter("param2") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
