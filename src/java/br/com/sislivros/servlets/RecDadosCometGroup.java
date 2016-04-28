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

@WebServlet(name = "RecDadosCometGroup", urlPatterns = {"/RecDadosCometGroup"})
public class RecDadosCometGroup extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        String caminho;
        if (isMultipart) {
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = (List<FileItem>) upload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        req.setAttribute(item.getFieldName(), item.getString());
//						resp.getWriter().println("Não é campo file"+ this.getServletContext().getRealPath("/img"));
						resp.getWriter().println("Name campo: "+item.getFieldName());
						resp.getWriter().println("Value campo: "+item.getString());
                        
                    } else {
                        //caso seja um campo do tipo file

//						resp.getWriter().println("Valor do Campo: ");
//						resp.getWriter().println("Campo file");
//						resp.getWriter().println("Name:"+item.getFieldName());
//						resp.getWriter().println("nome arquivo: "+item.getName());
//						resp.getWriter().println("Size:"+item.getSize());
//						resp.getWriter().println("ContentType:"+item.getContentType());
                        if (item.getName() == "" || item.getName() == null) {
                            caminho = "";
                        } else {
                            caminho = "img" + File.separator + new Date().getTime() + "_" + item.getName();
                            resp.getWriter().println("Caminho: " + caminho);
//                          File uploadedFile = new File("C:\\TomCat\\apache-tomcat-8.0.21\\webapps\\sislivros\\" + caminho);
                            File uploadedFile = new File("E:\\Documentos\\NetBeansProjects\\sislivrosgit\\sisLivro\\build\\web\\" + caminho);
                            item.write(uploadedFile);
                        }
                        

                        req.setAttribute("caminho", caminho);
//                        req.setAttribute("param", req.getParameter("comment-add"));
                        req.getRequestDispatcher("editarGrupo").forward(req, resp);
                    }

                }
                
                
            } catch (Exception e) {
                resp.getWriter().println("ocorreu um problema ao fazer o upload: " + e.getMessage());
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
