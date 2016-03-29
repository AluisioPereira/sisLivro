


<%@page import="br.com.sislivros.dao.UsuarioDao"%>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>  <!--  -->
<html lang="PT-BR">  <!--  -->
    <head>
		<meta charset="UTF-8">

		<meta http-equiv="refresh" content="200">
		<meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">

		<title>SisLIVROS</title>
		
		<link rel="stylesheet" href="css/loginStyle.css" type="text/css" >
                <script type="" src="" ></script>
		<script type="text/javascript" src="js/jquery.js"></script>
	
		
		
    </head>
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
            <section class="">
                
                <%
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
                %>
                
                <form action="recuperardados" method="post" enctype="multipart/form-data">
                    <h2>Cadastre-se em nosso sistema, é simples e fácil! :)</h2>
                    <div class="style">	
                    <p >
                        <label  id="user" data-icon="u"> Email: </label>
                        <input type="" value="" name="email" placeholder="Ex: meuemail@email.com" class="user">
                        <h6 id="erremail"></h6>
                    </p>
                        <p>
                            <label for="username" id="name" data-icon="u">Nome Completo: </label>
                            <input type="text" name="name" value="" placeholder="Ex: Zilderlan Leite da SIlva" class="name">
                       
                        <h6 id="errname"></h6>
                       
                        </p>

                        <p > 
                            <label for="userapelido" id="nickname" data-icon="">Apelido: </label>
                            <input type="text" name="nick" placeholder="Ex: Antimoniato" class="nickname">
                            <h6 id="errnick"></h6>
                        </p>
                        <p>
                            <label for="usernasc" id="usernasc" data-icon="">Data de Nascimento: </label>
                            <input type="text" name="datenasc" placeholder="Ex: 01/01/1900" class="usernasc">
                            <h6 id="errnasc"></h6>
                        </p>
                        <p>
                            <label for="password" id="password" data-icon="">Senha: </label>
                            <input type="password" name="password" placeholder="Ex: M1nhA53nha" class="password">
                            <h6 id="errpassword"></h6>
                        </p>
                        <p>
                            <label for="password" id="passwordrepeat" data-icon="">Repetir Senha: </label>
                            <input type="password" name="passwordrepeat" placeholder="Ex: M1nhA53nha" class="passwordrepeat">
                            <h6 id="errpasswordrepeat"></h6>
                        </p>
                        <p>
                            <label for="city" id="city" data-icon="">Cidade: </label>
                            <input type="text" name="city" placeholder="Ex: Cajazeiras" class="city">
                            <h6 id="errcity"></h6>
                        </p>
                        <p>
                            <label for="state" id="state" data-icon=""> Estado: </label>
                            <input type="text" name="state" placeholder="Ex: Paraíba" class="state">
                            <h6 id="errstate"></h6>
                       </p> 
                        </div>
                        <div class="photo" id="images">
                            <img src="img/usuario.jpg" title="" id="img">
                            <input type="button" value="Inserir Foto" name="" class="btn-photo" id="file-false">
                            <input type="file" value="" name="file" class="btn-photo" id="image">
                            
                        </div>
			<div class="" id="image-to-uploader"></div>

                            <input class="btn-submit" name="submit" type="submit" value="Cadastrar" > 
                            <input class="btn-reset" name="" type="reset" value="Limpar" >    
                            
                                                 
                        </form>
                	<script>

		$('#images').on('change', function(e){

			var files = e.target.files;
			$.each(files, function(i, file){
				var reader = new FileReader();
				reader.readAsDataURL(file);
				reader.onload = function(e){
					var template = 	'<div"">'+
				'<img src="'+e.target.result+'">'+
				
			'</div>';
			$('#image-to-uploader').append(template);
				};
			});
		});

	</script>
                    
            </section>


        </article>


    </body>
</html>
                                                                               
