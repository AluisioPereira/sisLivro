/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Zilderlan
 */
@WebServlet(name = "RecuperarDadosLivro", urlPatterns = {"/recuperardadoslivro"})
public class RecuperarDadosLivro extends HttpServlet {

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
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String caminho;
        if (isMultipart) {
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        response.getWriter().println("Name campo:" + item.getFieldName());
                        response.getWriter().println("Value campo:" + item.getString());
                        request.setAttribute(item.getFieldName(), item.getString());
                    } else {
                        //caso seja um campo do tipo file
                        response.getWriter().println("NOT Form field");
                        response.getWriter().println("Name:" + item.getFieldName());
                        response.getWriter().println("FileNam:" + item.getName());
                        response.getWriter().println("Size:" + item.getSize());
                        response.getWriter().println("ContentType:" + item.getContentType());
                        response.getWriter().println("C:\\uploads" + File.separator + new Date().getTime() + "_" + item.getName());
                        if (item.getName() == "" || item.getName() == null) {
                            caminho = "img"+File.separator+"sis1.jpg";
                        } else {
                            caminho = ("img"+File.separator + new Date().getTime() + "_" + item.getName());
                        }
                        response.getWriter().println("Caminho: " + caminho);
                        request.setAttribute("caminho", caminho);
//                        File uploadedFile = new File("C:\\TomCat\\apache-tomcat-8.0.21\\webapps\\sislivros\\img" + caminho);
                        File uploadedFile = new File("E:\\Documentos\\NetBeansProjects\\sislivrosgit\\sisLivro\\web\\" + caminho);
                        item.write(uploadedFile);
                        request.setAttribute("caminho", caminho);
                      request.getRequestDispatcher("CadastroLivroServlet").forward(request, response);
                    }
                }
            } catch (Exception e) {
                response.getWriter().println("ocorreu um problema ao fazer o upload: " + e.getMessage());
            }
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
