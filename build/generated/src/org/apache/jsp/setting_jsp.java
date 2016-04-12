package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Usuario;

public final class setting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Usuario user = (Usuario) session.getAttribute("user");
    if (user == null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
    String s = user.getName();
    String name[] = s.split(" ");
    
        GerenciadorSolicitacaoAmizade gerenciador = new GerenciadorSolicitacaoAmizade();
        



        


      out.write("\n");
      out.write("<!DOCTYPE html>  <!--  -->\n");
      out.write("<html lang=\"PT-BR\">  <!--  -->\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html\">\n");
      out.write("\t\t<meta http-equiv=\"refresh\" content=\"200\">\n");
      out.write("\t\t<meta name=\"author\" content=\"Zilderlan Leite, Ferreira, Aluisio Pereira\">\n");
      out.write("\t\t<meta name=\"\" content=\"\">\n");
      out.write("\t\t<meta name=\"\" content=\"\">\n");
      out.write("\t\t<title>SisLIVROS</title>\n");
      out.write("\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/setting.css\" type=\"text/css\" >\t\n");
      out.write("\t\t\n");
      out.write("                <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("        <header> <!--  -->\n");
      out.write("\t\t\t<div class=\"\" id=\"\">\n");
      out.write("\t\t\t\t<form action=\"Pesquisa?param=usuario\" method=\"post\" name=\"\" class=\"\" id=\"\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"nome\" class=\"\" id=\"search\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"\" class=\"\" id=\"btn-search\">\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"\" id=\"menu\">\n");
      out.write("\n");
      out.write("\t\t\t\t<a href=\"\" id=\"perfil\" alt=\"\"><img src=\"img/conf.png\" title=\"\"></a>\n");
      out.write("\t\t\t</div> \n");
      out.write("\n");
      out.write("\t\t\t<div class=\"\" id=\"perf\">\n");
      out.write("\t\t\t\t<a href=\"\" id=\"perfil\" alt=\"\"><img src=\"");
      out.print(user.getPhoto());
      out.write("\" title=\"\"></a>\n");
      out.write("\t\t\t\t<a href=\"\" ><h3> Olá, ");
      out.print( name[0]);
      out.write("!</h3></a>\n");
      out.write("                                <a href=\"EnviarSolicitacao?acao=clicked\" onClick=\"document.getElementById('notifications').style.display='block';\">\n");
      out.write("                                    <h4>Notificações");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${qtde}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("                                </a>\n");
      out.write("\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t</div> \n");
      out.write("\t\t</header>  <!--  -->\n");
      out.write("\t\t\n");
      out.write("\t\t<article>\n");
      out.write("\t\t<div class=\"left\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<nav class=\"nav-left\" id=\"\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><h3>Menu</h3></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\" >Inicio</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >Perfil</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"excluir\" >Excluir conta</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"Logout\" >Sair</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<nav class=\"nav-left\" id=\"nav1\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><h3>Meus alguma coisa</h3></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<nav class=\"nav-left\" id=\"nav2\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><h3>Meus alguma coisa</h3></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\" >alguma coisa</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t</div>\n");
      out.write("            <section class=\"\">\n");
      out.write("                \n");
      out.write("                ");

                  GerenciadorUser gUser = new GerenciadorUser();
                  String emailjoin = request.getParameter("newemail");
                  if (emailjoin == ""){
                      RequestDispatcher re = request.getRequestDispatcher("login.jsp"); 
                      re.forward(request, response);
                  }
                  if(gUser.verificaEmail(emailjoin)){
                      String retorno = "Email existente";
                      request.setAttribute("mensagem", retorno);
                      request.getRequestDispatcher("login.jsp").forward(request, response);
                  }
                
      out.write("\n");
      out.write("                \n");
      out.write("                <form action=\"atualizaruser\" class=\"form\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <div class=\"style\">\t\n");
      out.write("\n");
      out.write("                            <label for=\"username\" id=\"name\" data-icon=\"u\">Nome Completo: </label>\n");
      out.write("                            <input type=\"text\" name=\"name\" placeholder=\"Ex: Zilderlan Leite da SIlva\" class=\"name\">\n");
      out.write("                            <h6 id=\"errname\">Entrada inválida</h6>\n");
      out.write("\n");
      out.write("                            <label for=\"userapelido\" id=\"nickname\" data-icon=\"\">Apelido: </label>\n");
      out.write("                            <input type=\"text\" name=\"nick\" placeholder=\"Ex: Antimoniato\" class=\"nickname\">\n");
      out.write("                            <h6 id=\"errnick\">Entrada inválida</h6>\n");
      out.write("                            \n");
      out.write("                            <label for=\"password\" id=\"password\" data-icon=\"\">Senha: </label>\n");
      out.write("                            <input type=\"text\" name=\"password\" placeholder=\"Ex: M1nhA53nha\" class=\"password\">\n");
      out.write("                            <h6 id=\"errpassword\">Senhas Incompatíveis</h6>\n");
      out.write("\n");
      out.write("                            <label for=\"password\" id=\"passwordrepeat\" data-icon=\"\">Repetir Senha: </label>\n");
      out.write("                            <input type=\"text\" name=\"passwordrepeat\" placeholder=\"Ex: M1nhA53nha\" class=\"passwordrepeat\">\n");
      out.write("                            <h6 id=\"errpasswordrepeat\">Senhas Incompatíveis</h6>\n");
      out.write("\n");
      out.write("                            <label for=\"usernasc\" id=\"usernasc\" data-icon=\"\">Data de Nascimento: </label>\n");
      out.write("                            <input type=\"text\" name=\"datenasc\" placeholder=\"Ex: 01/01/1900\" class=\"usernasc\">\n");
      out.write("                            <h6 id=\"errnasc\">Entrada inválida</h6>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <label for=\"city\" id=\"city\" data-icon=\"\">Cidade: </label>\n");
      out.write("                            <input type=\"text\" name=\"city\" placeholder=\"Ex: Cajazeiras\" class=\"city\">\n");
      out.write("                            <h6 id=\"errcity\">Entrada inválida</h6>\n");
      out.write("                            \n");
      out.write("                            <label for=\"state\" id=\"state\" data-icon=\"\"> Estado: </label>\n");
      out.write("                           \n");
      out.write("                            <select name=\"state\" class=\"state\">\n");
      out.write("                                <option value=\"\">Selecione</option>\n");
      out.write("                                <option value=\"Acre\">AC</option>\n");
      out.write("                                <option value=\"Alagoas\">AL</option>\n");
      out.write("                                <option value=\"Amapá\">AP</option>\n");
      out.write("                                <option value=\"Amazonas\">AM</option>\n");
      out.write("                                <option value=\"Bahia\">BA</option>\n");
      out.write("                                <option value=\"Ceará\">CE</option>\n");
      out.write("                                <option value=\"Distrito Federal\">DF</option>\n");
      out.write("                                <option value=\"Espírito Santos\">ES</option>\n");
      out.write("                                <option value=\"Goiás\">GO</option>\n");
      out.write("                                <option value=\"Maranão\">MA</option>\n");
      out.write("                                <option value=\"Mato Grosso\">MT</option>\n");
      out.write("                                <option value=\"MAto Grosso do Sul\">MS</option>\n");
      out.write("                                <option value=\"Minas Gerais\">MG</option>\n");
      out.write("                                <option value=\"Pará\">PA</option>\n");
      out.write("                                <option value=\"Paraíba\">PB</option>\n");
      out.write("                                <option value=\"Paraná\">PR</option>\n");
      out.write("                                <option value=\"Pernambuco\">PE</option>\n");
      out.write("                                <option value=\"Piauí\">PI</option>\n");
      out.write("                                <option value=\"Rio de Janeiro\">RJ</option>\n");
      out.write("                                <option value=\"Rio Grande do Norte\">RN</option>\n");
      out.write("                                <option value=\"Rio Grande do Sul\">RS</option>\n");
      out.write("                                <option value=\"Rondônia\">RO</option>\n");
      out.write("                                <option value=\"Roraima\">RR</option>\n");
      out.write("                                <option value=\"Santa Catarina\">SC</option>\n");
      out.write("                                <option value=\"São paulo\">SP</option>\n");
      out.write("                                <option value=\"Sergipe\">SE</option>\n");
      out.write("                                <option value=\"Tocantins\">TO</option>\n");
      out.write("                            </select>\n");
      out.write("                            <h6 id=\"errstate\">Selecione</h6>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"photo\" id=\"images\">\n");
      out.write("                            <img src=\"img/usuario.jpg\" title=\"\" id=\"img\">\n");
      out.write("                            <input type=\"button\" value=\"Imagem\" name=\"\" class=\"\" id=\"file-false\">\n");
      out.write("                            <input type=\"file\" value=\"\" name=\"file\" class=\"btn-photo\" id=\"image\">\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("\t\t\t<div class=\"\" id=\"image-to-uploader\"></div>\n");
      out.write("\n");
      out.write("                            <input class=\"btn-submit\" name=\"submit\" type=\"submit\" value=\"Cadastrar\" > \n");
      out.write("                            <input class=\"btn-reset\" name=\"\" type=\"reset\" value=\"Limpar\" >    \n");
      out.write("                            \n");
      out.write("                                                 \n");
      out.write("                        </form>\n");
      out.write("                \t<script>\n");
      out.write("\n");
      out.write("\t\t$('#images').on('change', function(e){\n");
      out.write("\n");
      out.write("\t\t\tvar files = e.target.files;\n");
      out.write("\t\t\t$.each(files, function(i, file){\n");
      out.write("\t\t\t\tvar reader = new FileReader();\n");
      out.write("\t\t\t\treader.readAsDataURL(file);\n");
      out.write("\t\t\t\treader.onload = function(e){\n");
      out.write("\t\t\t\t\tvar template = \t'<div\"\">'+\n");
      out.write("\t\t\t\t'<img src=\"'+e.target.result+'\">'+\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t'</div>';\n");
      out.write("\t\t\t$('#image-to-uploader').append(template);\n");
      out.write("\t\t\t\t};\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t</script>\n");
      out.write("                    \n");
      out.write("            </section>\n");
      out.write("                \n");
      out.write("          \n");
      out.write("            <section class=\"notifications style\" style=\"display: \" id=\"notifications\">\n");
      out.write("\n");
      out.write("                ");
 
                    request.setAttribute("setting", "setting.jsp");
                
      out.write("\n");
      out.write("                \n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            \n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t</article>\n");
      out.write("\t\t\n");
      out.write("\t\t</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("users");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listSolic}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                  \n");
          out.write("                <div class=\"friend\" >                   \n");
          out.write("                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.photo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"img-not\">\n");
          out.write("                    <a href=\"#\"><strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${users.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</strong></a>\n");
          out.write("                    <input type=\"button\" class=\"cancel-not\" value=\"Cancelar Solicitação\">\n");
          out.write("                    <input type=\"button\" class=\"accept-not\" value=\"Aceitar Solicitação\">\n");
          out.write("                    <hr>\n");
          out.write("                </div>  \n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
