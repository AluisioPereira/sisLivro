/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletContext;
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
@WebServlet("/recuperardados")
public class RecuperarDados extends HttpServlet {

    private static final long serialVersionUID = -3313174925443786914L;
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
                String caminho;
		if(isMultipart) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = (List<FileItem>) upload.parseRequest(req);
				for(FileItem item : items) {
					if(item.isFormField()) {
                                         
                                              req.setAttribute(item.getFieldName(), item.getString());
						resp.getWriter().println("Não é campo file"+ this.getServletContext().getRealPath("/img"));
						resp.getWriter().println("Name campo: "+item.getFieldName());
						resp.getWriter().println("Value campo: "+item.getString());
                                               
                                                req.setAttribute(item.getFieldName(), item.getString());
					} else {
						//caso seja um campo do tipo file
						
						resp.getWriter().println("Campo file");
						resp.getWriter().println("Name:"+item.getFieldName());
						resp.getWriter().println("nome arquivo :"+item.getName());
						resp.getWriter().println("Size:"+item.getSize());
						resp.getWriter().println("ContentType:"+item.getContentType());
                                                 if (item.getName() == "" || item.getName() == null){
                                                     caminho = "img\\usuario.jpg";
                                                }else
                                                 {
                                                    caminho = "img"+ File.separator + new Date().getTime() + "_" + item.getName();
                                                    resp.getWriter().println("Caminho: " + caminho);
                                                    File uploadedFile = new File("C:\\apache-softwere\\apache-tomcat-8.0.21\\webapps\\sislivros\\"+caminho);
                                                    item.write(uploadedFile);

                                                 }

                                                    req.setAttribute("caminho", caminho);
                                                    req.getRequestDispatcher("cadastrouser").forward(req, resp);
					}
                                        
				}
			} catch (Exception e) {
//				resp.getWriter().println("ocorreu um problema ao fazer o upload: " + e.getMessage());
			}
		}
                
	}
}
