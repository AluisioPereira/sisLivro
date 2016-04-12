<%-- 
    Document   : setting
    Created on : 27/02/2016, 14:54:59
    Author     : Zilderlan
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.sislivros.manager.GerenciadorSolicitacaoAmizade"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    if (user == null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
    String s = user.getName();
    String name[] = s.split(" ");
    
        GerenciadorSolicitacaoAmizade gerenciador = new GerenciadorSolicitacaoAmizade();
        



        

%>
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

		<link rel="stylesheet" href="css/setting.css" type="text/css" >	
		
                <script type="text/javascript" src="js/jquery.js"></script>
	</head>

	<body>
        <header> <!--  -->
			<div class="" id="">
				<form action="Pesquisa?param=usuario" method="post" name="" class="" id="">
					<input type="text" name="nome" class="" id="search">
					<input type="submit" name="" class="" id="btn-search">
				</form>
			</div>

			<div class="" id="menu">

				<a href="" id="perfil" alt=""><img src="img/conf.png" title=""></a>
			</div> 

			<div class="" id="perf">
				<a href="" id="perfil" alt=""><img src="<%=user.getPhoto()%>" title=""></a>
				<a href="" ><h3> Olá, <%= name[0]%>!</h3></a>
                                <a href="EnviarSolicitacao?acao=clicked" onClick="document.getElementById('notifications').style.display='block';">
                                    <h4>Notificações${qtde}</h4>
                                </a>
				

			</div> 
		</header>  <!--  -->
		
		<article>
		<div class="left">
		
			<nav class="nav-left" id="">
				<ul>
					<li><h3>Menu</h3></li>
					<li><a href="index.jsp" >Inicio</a></li>
					<li><a href="" >Perfil</a></li>
					<li><a href="excluir" >Excluir conta</a></li>
					<li><a href="Logout" >Sair</a></li>
				</ul>
			
			</nav>
			
			<nav class="nav-left" id="nav1">
				<ul>
					<li><h3>Meus Grupos</h3></li>
					<li><a href="" >alguma coisa</a></li>
					<li><a href="" >alguma coisa</a></li>
					<li><a href="" >alguma coisa</a></li>
					<li><a href="#" onclick="document.getElementById('criarGrupo').style.display='block';">Novo Grupo</a></li>
				</ul>
			
			</nav>
			
			<nav class="nav-left" id="nav2">
				<ul>
					<li><h3>Notificações</h3></li>
					<li><a href="#" >Pedidos de amizade</a></li>
					<li><a href="#" >Recomendações</a></li>
					<li><a href="#" >alguma coisa</a></li>
					<li><a href="#" >alguma coisa</a></li>
				</ul>
			
			</nav>
			</div>
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
                
                <form action="atualizaruser" class="form" method="post" enctype="multipart/form-data">
                    <div class="style">	

                            <label for="username" id="name" data-icon="u">Nome Completo: </label>
                            <input type="text" name="name" placeholder="Ex: Zilderlan Leite da SIlva" class="name">
                            <h6 id="errname">Entrada inválida</h6>

                            <label for="userapelido" id="nickname" data-icon="">Apelido: </label>
                            <input type="text" name="nick" placeholder="Ex: Antimoniato" class="nickname">
                            <h6 id="errnick">Entrada inválida</h6>
                            
                            <label for="password" id="password" data-icon="">Senha: </label>
                            <input type="text" name="password" placeholder="Ex: M1nhA53nha" class="password">
                            <h6 id="errpassword">Senhas Incompatíveis</h6>

                            <label for="password" id="passwordrepeat" data-icon="">Repetir Senha: </label>
                            <input type="text" name="passwordrepeat" placeholder="Ex: M1nhA53nha" class="passwordrepeat">
                            <h6 id="errpasswordrepeat">Senhas Incompatíveis</h6>

                            <label for="usernasc" id="usernasc" data-icon="">Data de Nascimento: </label>
                            <input type="text" name="datenasc" placeholder="Ex: 01/01/1900" class="usernasc">
                            <h6 id="errnasc">Entrada inválida</h6>



                            <label for="city" id="city" data-icon="">Cidade: </label>
                            <input type="text" name="city" placeholder="Ex: Cajazeiras" class="city">
                            <h6 id="errcity">Entrada inválida</h6>
                            
                            <label for="state" id="state" data-icon=""> Estado: </label>
                           
                            <select name="state" class="state">
                                <option value="">Selecione</option>
                                <option value="Acre">AC</option>
                                <option value="Alagoas">AL</option>
                                <option value="Amapá">AP</option>
                                <option value="Amazonas">AM</option>
                                <option value="Bahia">BA</option>
                                <option value="Ceará">CE</option>
                                <option value="Distrito Federal">DF</option>
                                <option value="Espírito Santos">ES</option>
                                <option value="Goiás">GO</option>
                                <option value="Maranão">MA</option>
                                <option value="Mato Grosso">MT</option>
                                <option value="MAto Grosso do Sul">MS</option>
                                <option value="Minas Gerais">MG</option>
                                <option value="Pará">PA</option>
                                <option value="Paraíba">PB</option>
                                <option value="Paraná">PR</option>
                                <option value="Pernambuco">PE</option>
                                <option value="Piauí">PI</option>
                                <option value="Rio de Janeiro">RJ</option>
                                <option value="Rio Grande do Norte">RN</option>
                                <option value="Rio Grande do Sul">RS</option>
                                <option value="Rondônia">RO</option>
                                <option value="Roraima">RR</option>
                                <option value="Santa Catarina">SC</option>
                                <option value="São paulo">SP</option>
                                <option value="Sergipe">SE</option>
                                <option value="Tocantins">TO</option>
                            </select>
                            <h6 id="errstate">Selecione</h6>

                        </div>
                        <div class="photo" id="images">
                            <img src="img/usuario.jpg" title="" id="img">
                            <input type="button" value="Imagem" name="" class="" id="file-false">
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
                
                <section>
                    <div id="criarGrupo">
                        <form action="" method="">
                            <div id="nameGrupo">
                                <input type="text" class="nameGrupo" name="nameGrupo" placeholder="Nome do Grupo">
                            </div>
                            <div id="descricaoGrupo" name="descricaoGrupo">
                                <textarea type="text" class="descricaoGrupo" name="descricaoGrupo" rows="10" cols="60" maxlength="200" placeholder="Descrição do grupo"></textarea>
                            </div>
                            <input type="submit" id="enviarDescricao" value="Concluir">
                        </form>
                    </div>
                </section>
                
          
            <section class="notifications style" style="display: " id="notifications">

                <% 
                    request.setAttribute("setting", "setting.jsp");
                %>
                
                <c:forEach var="users" items="${listSolic}">
                  
                <div class="friend" >                   
                    <img src="${users.photo}" class="img-not">
                    <a href="#"><strong>${users.name}</strong></a>
                    <input type="button" class="cancel-not" value="Cancelar Solicitação">
                    <input type="button" class="accept-not" value="Aceitar Solicitação">
                    <hr>
                </div>  
                </c:forEach>
                            
            </section>

		
	</article>
		
		</body>