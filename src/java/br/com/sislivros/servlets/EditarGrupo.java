/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import br.com.sislivros.manager.GerenciadorComentarioGrupo;
import br.com.sislivros.manager.GerenciadorGrupo;
import br.com.sislivros.valueobject.ComentarioGrupo;
import br.com.sislivros.valueobject.Grupo;
import br.com.sislivros.valueobject.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet("/editarGrupo")
public class EditarGrupo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("user");
        GerenciadorGrupo manager = new GerenciadorGrupo();
        String param = request.getParameter("param");
        String name = request.getParameter("nameGrupo");
        String description = request.getParameter("descricaoGrupo");
        String param2 = request.getParameter("descricaoGrupo");
        if (request.getParameter("param").equalsIgnoreCase("comment-add")) {
            response.getWriter().println("Comentar");
            response.getWriter().println("TextGroup:" + request.getAttribute("textGrupo"));
            response.getWriter().println(request.getAttribute("caminho"));
            response.getWriter().println(request.getParameter("id"));
            GerenciadorComentarioGrupo gComentGrupo = new GerenciadorComentarioGrupo();
            gComentGrupo.addComentGrupo(u.getEmail(), Integer.parseInt(request.getParameter("id")), request.getAttribute("textGrupo").toString(), request.getAttribute("caminho").toString(), u.getName());
            List<ComentarioGrupo> commentGroup = gComentGrupo.listComment(Integer.parseInt(request.getParameter("id")));
            session.setAttribute("commentGroup", commentGroup);
            response.sendRedirect(request.getParameter("p"));
        } 
        else if(request.getParameter("param").equalsIgnoreCase("add")){
            response.getWriter().println("Adicionar");
            response.getWriter().println(request.getParameter("nameGrupo"));
            response.getWriter().println(request.getParameter("descricaoGrupo"));
            Grupo grupo = manager.montarGrupo((int) new Date().getTime(), name, description);
            manager.criarGrupo(grupo);
            manager.addUser(grupo.getId(), u.getEmail());
            session.setAttribute("group", manager.listAll(u.getEmail()));
            response.sendRedirect(request.getParameter("p"));
        }else if(request.getParameter("param").equalsIgnoreCase("edit")){
            response.getWriter().println("Editar <br>");
            response.getWriter().println(request.getParameter("param"));
            response.getWriter().println("<br> "+request.getAttribute("caminho"));
            response.getWriter().println("<br> "+request.getAttribute("nameGrupo"));
            Grupo g =  manager.montarGrupo(Integer.parseInt(request.getParameter("id")), request.getAttribute("nameGrupo").toString(), request.getAttribute("descricaoGrupo").toString());
            manager.editGroup(g);
            session.setAttribute("group", manager.listAll(u.getEmail()));
            response.sendRedirect(request.getParameter("p"));           
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
