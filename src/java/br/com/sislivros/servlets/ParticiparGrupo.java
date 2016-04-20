/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorGrupo;
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
@WebServlet(name = "ParticiparGrupo", urlPatterns = {"/participarGrupo"})
public class ParticiparGrupo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        GerenciadorGrupo gGrupo = new GerenciadorGrupo();
        Usuario user = (Usuario) sessao.getAttribute("user");
        gGrupo.addUser(Integer.parseInt(request.getParameter("param")), user.getEmail());
        boolean b = gGrupo.retornarUsuarioGrupo(Integer.parseInt(request.getParameter("param")), user.getEmail());
        List<Usuario> listUserGrupo = gGrupo.returUserGroup(Integer.parseInt(request.getParameter("param")), user.getEmail());
        sessao.setAttribute("b", b);        
        sessao.setAttribute("listUserGrupo", listUserGrupo);
        response.sendRedirect(request.getParameter("p"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParticiparGrupo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParticiparGrupo at " + request.getParameter("param") + "</h1>");
            out.println("<h1>Servlet ParticiparGrupo at " + user.getEmail() + "</h1>");
            out.println("<h1>Servlet ParticiparGrupo at " + b + "</h1>");
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
