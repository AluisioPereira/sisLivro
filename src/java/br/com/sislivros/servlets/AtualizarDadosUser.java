/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;
import static br.com.sislivros.conection.TestConection.convertDate;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AtualizarDadosUser", urlPatterns = {"/AtualizarDadosUser"})
public class AtualizarDadosUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String name = (String)request.getAttribute("name");
        String nick = (String) request.getAttribute("nick");
        String password = (String) request.getAttribute("password");
        String dateNas = (String) request.getAttribute("datenasc");
        String city = (String) request.getAttribute("city");
        String state = (String) request.getAttribute("state");
        String image = (String) request.getAttribute("caminho");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario)session.getAttribute("user");
        Usuario user = new Usuario();
        usuario.setName(name);
        usuario.setNick(nick);
        usuario.setSenha(password);
        usuario.setDataNasc(convertDate(dateNas));
        usuario.setCity(city);
        usuario.setState(state);
        usuario.setPhoto(image);
        
//        user.setEmail(user.getEmail());
        
        GerenciadorUser gUser = new GerenciadorUser();
        gUser.atualizar(usuario);
        response.sendRedirect("index.jsp");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtualizarDadosUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nome " + usuario.getEmail()+ "</h1>");
            out.println("<h1>Nome " + usuario.getName() + "</h1>");
            out.println("<h1>Apelido " + usuario.getNick() + "</h1>");
            out.println("<h1>Senha " + usuario.getSenha() + "</h1>");
            out.println("<h1>DataNasct " + usuario.getDataNasc()+ "</h1>");
            out.println("<h1>Cidade " + usuario.getCity()+ "</h1>");
            out.println("<h1>Estado " + usuario.getState()+ "</h1>");
            out.println("<h1>Foto " + usuario.getPhoto()+ "</h1>");
            out.println("<h1>Tipo " + usuario.getTipo()+ "</h1>");
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
