<%@page import="java.util.List"%>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    if (user == null) {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    String s = user.getName();
    String name[] = s.split(" ");
%>
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
                <form action="Pesquisa" method="post" name="" class="" id="">
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
                <a href="#" onClick="document.getElementById('notifications').style.display = 'block';"><h4>Notificações</h4></a>
            </div> 

        </header>  <!--  -->
        <article>
            <div id="user-visited">
                <img src="${userPesquisa.photo}" alt="" title="">
                <h3>${userPesquisa.name}</h3>
            </div>
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
                        <li><h3>Meus grupos</h3></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >Novo grupo</a></li>
                    </ul>
                </nav>
                <nav class="nav-left" id="nav2">
                    <ul>
                        <li><h3>Meus alguma coisa</h3></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="" >alguma coisa</a></li>
                    </ul>
                </nav>
            </div>

            <section >
                <div id="friends">
                    <h4>Amigos</h4>
                    <c:forEach var="listamizades" items="${listAmigodoVisitado}">
                        <c:if test="${listamizades.email ne userPesquisa.email}">

                            <a href="retornarUser?param=${listamizades.email}" title="${listamizades.name}">
                                <img style="width: 30px; height: 30px" src="${listamizades.photo}">
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </section>
            <section>
                <div id="criarGrupo">
                    <form action="editarGrupo?param=add&p=setting.jsp" method="post">
                        <div id="nameGrupo">
                            <input type="text" class="nameGrupo" name="nameGrupo" placeholder="Nome do Grupo">
                        </div>
                        <div id="descricaoGrupo" name="descricaoGrupo">
                            <textarea type="text" class="descricaoGrupo" name="descricaoGrupo" rows="10" cols="60" maxlength="200" placeholder="Descrição do grupo"></textarea>
                        </div>
                        <input type="submit" id="enviarDescricao" value="Concluir">
                        <input type="button" id="cancelarDescricao" value="Cancelar" onclick="document.getElementById('criarGrupo').style.display = 'none';">
                    </form>
                </div>
            </section>
            <section class="notifications style" style="display: " id="notifications">
                <a href="cancelaSolicitacao?p=usuarioPesquisa.jsp" id="close">Fechar</a>
                <%
                    request.setAttribute("setting", "setting.jsp");
                %>
                <c:forEach var="users" items="${listUser}">
                    <div class="friend" >                   
                        <img src="${users.photo}" class="img-not">
                        <a href="#"><strong>${users.name}</strong></a>
                        <input type="button" class="cancel-not" onclick="abrirPagina('cancelaSolicitacao?param1=${users.email}&p=usuarioPesquisa.jsp')" value="Cancelar Solicitação">
                        <input type="button" class="accept-not" onclick="abrirPagina('tornarAmigo?param1=${users.email}&param2=${user.getEmail()}&p=usuarioPesquisa.jsp')" value="Aceitar Solicitação">
                        <hr>
                    </div>  
                </c:forEach>
            </section>   
        </article>
    </body>
</html>