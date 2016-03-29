<%-- 
    Document   : home
    Created on : 27/01/2016, 16:59:14
    Author     : Zilderlan
--%>

<%@page import="br.com.sislivros.valueobject.Usuario"%>
<%
  Usuario user = (Usuario) session.getAttribute("user");
  String s = user.getName();
  String name[] = s.split(" ");
  if (user == null)
    request.getRequestDispatcher("index.jsp").include(request, response);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="PT-BR">  <!--  -->
    <head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html">
		<meta http-equiv="refresh" content="200">
		<meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">
		<meta name="" content="">
		<meta name="" content="">
		<title>Home</title>
		
		<link rel="stylesheet" href="css/loginStyle.css" type="text/css" >
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<script src="ajax.js"></script>
	<script src="tabela.js"></script>
	<script src="jquery.js"></script>
	<script  src="jquery.dataTables.min.js"></script>
		
		
    </head>
    <body>
        <header> <!--  -->
            <div class="content" >
                <nav class="menu-superior">
                    <ul >
                            
                        <li ><a class="inicio" href="index.jsp" title="" >Início</a></li>
                        <li ><a href="home.jsp" title="">Administração</a></li>
                        <li ><a href="" title="">Meu Espaço</a></li>
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
        	<div class="content-top">
        		<div class="content-left">
<!--        			<h2> Nome do Sistema</h2>-->
        			<img src="img/footer2.png" title="">
        			<h3> Logado como Administrador</h3>

        		</div>

        		<div class="content-right">
        			<h3> <%= name[0] %></h3>
        			<img src="<%=user.getPhoto()%>" title="Foto do usuário">
                                <input type ="file" id="photo-edit" value="editar">        			
                                <ul>
        				<li><a href="" class="perfil">Editar Perfil</a></li>
        				<li><a href="Logout" class="exit">Sair</a></li>
        			</ul>

        		</div>

        	</div>
        </header>

        <article class="sec">
        
	           	
        <!-- -->
        <section >
        <div class="function-user">
        <h3>Gerência de Usuários</h3>
        <ul>
            
            <li><a href="administraruser.jsp"> Gerenciamento de Usuários</a></li>
            <li><a href="">Funcionalidade2</a></li>
            <li><a href="">Funcionalidade3</a></li>
        </ul>
        </div>
       <div class="function-date">
        <h3>Organizar Livros</h3>
        <ul>
            
            <li><a href=""> Gerenciamento de Feriados</a></li>
            <li><a href="">Funcionalidade2</a></li>
            <li><a href="">Funcionalidade3</a></li>
        </ul>
        </div>
        </section>        


        	
        </article>
    </body>
</html>
