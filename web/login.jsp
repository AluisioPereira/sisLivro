<%-- 
    Document   : login
    Created on : 11/02/2016, 11:37:07
    Author     : Zilderlan
--%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    if (user != null)
        response.sendRedirect("index.jsp");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  <!--  -->
<html lang="PT-BR">  <!--  -->
    <head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html">
		<meta http-equiv="refresh" content="200">
		<meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">
		<meta name="" content="">
		<meta name="" content="">
		<title>SisLIVROS</title>
	
		<link rel="stylesheet" href="css/login.css" type="text/css" >

		
		
    </head>
            <script type="text/javascript">
function Nova()
{
location.href=" index.jsp"
}
</script> 

            <script type="text/javascript">
function Cadastro()
{
location.href=" cadastroCliente.html"
}
</script> 
    <body>
        <header> <!--  -->
            <div class="content" >
                <nav class="menu-superior">
                    <ul >
                            
                        <li ><a class="inicio" href="index.jsp" title="" >Início</a></li>
                        <li ><a href="" title="">Quem Somos</a></li>
                        <li ><a href="" title="">Pilítica</a></li>
                        <li ><a href="" title="">Portfólio</a></li>
                        <li ><a href="" title="">Equipe</a></li>
                        <li ><a href="" title="">Contato</a></li>

                    </ul>
                </nav>
                    
                <div class="acessibilidade">

	                <div class="header-acessibilidade" id="fonte">
	                                
	                    <a href="#" class="padrao" accesskey="p">A</a>
	                    <a href="#" class="diminuir" accesskey="-">A-</a>
	                    <a href="#" class="aumentar" accesskey="+">A+</a>
	                </div>

	                <div class="header-acessibilidade" id="cor">
	                    <a href="#" id="css/fonts" class="contraste" accesskey="n" rel="css/style">Normal</a>
	                    <a href="#" class="contraste" rel="css/contraste" accesskey="c">Contraste</a>

	                </div>
            	</div> 

            </div >
                
        </header>  <!--  -->
            <article>
                <section class="left">
                    
                        <form action="LoginServlet" method="post">
                            <h2>Login</h2>
                            <hr>
                            <p>
                            <label for="useremail" class="i" data-icon="">Nome ou Email: </label>
                            <input type="text" name="login" placeholder="Ex: meuemail@email.com" value="">
                            </p>
                            <p>
                            <label for="userpassword" class="" data-icon="">Senha: </label>
                            <input type="password" name="password" placeholder="Ex: M1nhA53nha" value="">
                            </p>
                            <h6>Login ou senha inválidos</h6>
                            <input class="btn" name="" type="submit" value="Login" >
                            <input class="btn" name="" type="button" value="Cancelar" onClick="Nova()">
                            <!--<input class="btn" name="" type="button" value="Cancelar" onClick="Nova()"  >-->
                        </form>
                    
                    
                </section>

                <section>
                   
                    <div class="join">
                        <form action="cadastro.jsp" method="post">
                            <h2> Sou novo por aqui</h2>
                            <p>
                            <label for="join" class="emailjoin" data-icon="">Email: </label>
                            <input type="text" name="newemail" placeholder="Ex: meuemail@email.com" >
                             <%        
                            if(session.getAttribute("mensagem") != null){    
                            %>
                            <h5><%=session.getAttribute("mensagem")%></h5>
                            <%}%>
                            </p>
                            <input class="btn" name="" type="submit" value="Continuar >>"  >
<!--                            <input class="btn" name="" type="button" value="Continuar >>" onClick="Cadastro()" >-->
                        </form>
                    </div>
                            
                </section>
            </article>
        <footer >   
            <p>&copy Todos os direitos reservados</p>
	</footer >  <!--  -->
    </body>
</html>
