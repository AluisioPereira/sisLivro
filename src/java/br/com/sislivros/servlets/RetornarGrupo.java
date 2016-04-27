/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorComentarioGrupo;
import br.com.sislivros.manager.GerenciadorGrupo;
import br.com.sislivros.valueobject.ComentarioGrupo;
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
@WebServlet(name = "RetornarGrupo", urlPatterns = {"/RetornarGrupo"})
public class RetornarGrupo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        GerenciadorGrupo gGroup = new GerenciadorGrupo();
        GerenciadorComentarioGrupo gComentGrupo = new GerenciadorComentarioGrupo();
        List<Usuario> listUserGrupo = gGroup.returUserGroup(Integer.parseInt(request.getParameter("id")), user.getEmail());
        boolean b = gGroup.retornarUsuarioGrupo(Integer.parseInt(request.getParameter("id")), user.getEmail());
        session.setAttribute("b", b);
        session.setAttribute("grupo", gGroup.returnGroupId(Integer.parseInt(request.getParameter("id"))));
        session.setAttribute("listUserGrupo", listUserGrupo);
        List<ComentarioGrupo> commentGroup = gComentGrupo.listComment(Integer.parseInt(request.getParameter("id")));
        session.setAttribute("commentGroup", commentGroup);
        response.sendRedirect("Grupo.jsp");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RetornarGrupo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RetornarGrupo at " + request.getContextPath() + "</h1>");
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
