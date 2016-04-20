/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import static br.com.sislivros.conection.TestConection.convertDate;
import br.com.sislivros.dao.UsuarioDao;
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
@WebServlet("/cadastrouser")
public class CadastroUserServlet extends HttpServlet {

    
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
        response.setContentType("text/html;charset=UTF-8");
        String name = (String)request.getAttribute("name");
        String nick = (String) request.getAttribute("nick");
        String email = (String) request.getAttribute("email");
        String password = (String) request.getAttribute("password");
        String passwordrepeat = (String) request.getAttribute("passwordrepeat");
        String dateNasc = (String) request.getAttribute("datenasc");
        String city = (String) request.getAttribute("city");
        String state = (String) request.getAttribute("state");
        String image = (String) request.getAttribute("caminho");
        
        
        Usuario user = new Usuario();
        user.setName(name);
        user.setNick(nick);
        user.setEmail(email);
        user.setSenha(password);
        user.setDataNasc(convertDate(dateNasc));
        user.setCity(city);
        user.setState(state);
        user.setPhoto(image);


        GerenciadorUser managerUser = new GerenciadorUser();
        response.getWriter().println(user);
        response.getWriter().println(managerUser.userAdd(user));
        Usuario usuario = managerUser.userLogin(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", usuario);
//        response.getWriter().println(usuario);
//        response.getWriter().println(user);
//        response.sendRedirect("index.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
