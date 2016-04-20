

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>

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
                <a href="#" onClick="document.getElementById('notifications').style.display = 'block';">
                    <h4>Notificações  </h4><h4 class="notif">
                        <c:if test="${qtde > 0}">
                            ${qtde}
                        </c:if></h4>
                </a>
            </div> 
        </header>  <!--  -->

        <article>
            <div class="left">

                <nav class="nav-left" id="">
                    <ul>
                        <li><h3>Menu</h3></li>
                        <li><a href="index.jsp" >Inicio</a></li>
                        <li><a href="setting.jsp" >Perfil</a></li>
                        <li><a href="excluir" >Excluir conta</a></li>
                        <li><a href="Logout" >Sair</a></li>
                    </ul>
                </nav>

                <nav class="nav-left" id="nav1">
                    <ul>
                        <li><h3>Meus grupos</h3></li>
                            <c:forEach var="groups" items="${group}">
                            <li><a href="Grupo.jsp?id=${groups.id}" >${groups.name}</a></li>
                            </c:forEach>
                        <li><a href="" >alguma coisa</a></li>
                        <li><a href="#" onclick="document.getElementById('editarGrupo').style.display = 'block';">Editar grupo</a></li>
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
            <section>
                <script>
                    function abrirPagina(pagina) {
                        location.href = pagina;
                    }
                </script>            
                <c:forEach var="usuarios" items="${list}">
                    <%
                        String msg = "Adicionar ao amigos";
                        String pag = "EnviarSolicitacao";
                    %>
                    <c:forEach var="solicitation" items="${mySolicitation}">
                        <c:if test="${usuarios.email eq solicitation.solicitacaoRecebiada && user.getEmail() eq solicitation.solicitacaoEnviada}">
                            <%
                                msg = "Cancelar Solicitação";
                                pag = "cancelaSolicitacao";
                            %>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="solicitation" items="${mySolicitation}" >
                        <c:if test="${usuarios.email eq solicitation.solicitacaoEnviada && user.getEmail() eq solicitation.solicitacaoRecebiada}">
                            <%
                                msg = "Aceitar Solicitação";
                                pag = "cancelaSolicitacao";
                            %>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="listFriends" items="${listFriend}">
                        <c:if test="${(usuarios.email eq listFriends.solicRecebida || usuarios.email eq listFriends.solicEnviada) && (user.getEmail() eq listFriends.solicEnviada || user.getEmail() eq listFriends.solicRecebida)}">
                            <% msg = "Desfazer Amizade";
                                pag = "cancelarAmizade";
                            %>
                        </c:if>
                    </c:forEach>
                    <div class="userSearch">
                        <img src="${usuarios.photo}" id="img-perfil">
                        <a href="retornarUser?param=${usuarios.email}"><h1>${usuarios.name}</h1></a>
                        <h4>${usuarios.nick}</h4>
                        <c:if test="${usuarios.email ne user.getEmail()}">
                            <input type="button" value="<%=msg%>" class="friend-add" onClick="abrirPagina('<%=pag%>?param1=${usuarios.email}&p=Pesquisa.jsp')">
                        </c:if>
                        <br>
                    </div>  
                </c:forEach>
                <c:forEach var="groups" items="${listGroup}">
                    <div class="userSearch">
                        <img src="${groups.photo}" id="img-perfil">
                        <a href="RetornarGrupo?id=${groups.id}"><h1>${groups.name}</h1></a>
                        <h4>${"Grupo"}</h4>
                        <input type="button" value="Adicionar ao amigos" class="friend-add" onClick="abrirPagina('EnviarSolicitacao?param=${usuarios.email}')">
                        <br>
                    </div>   
                </c:forEach>

                <script>

                    $('#images').on('change', function (e) {

                        var files = e.target.files;
                        $.each(files, function (i, file) {
                            var reader = new FileReader();
                            reader.readAsDataURL(file);
                            reader.onload = function (e) {
                                var template = '<div"">' +
                                        '<img src="' + e.target.result + '">' +
                                        '</div>';
                                $('#image-to-uploader').append(template);
                            };
                        });
                    });

                </script>

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
                <a href="cancelaSolicitacao?p=Pesquisa.jsp" id="close">Fechar</a>
                <%
                    request.setAttribute("setting", "setting.jsp");
                %>
                <c:forEach var="users" items="${listUser}">
                    <div class="friend" >                   
                        <img src="${users.photo}" class="img-not">
                        <a href="#"><strong>${users.name}</strong></a>
                        <input type="button" class="cancel-not" onclick="abrirPagina('cancelaSolicitacao?param1=${users.email}&p=setting.jsp')" value="Cancelar Solicitação">
                        <input type="button" class="accept-not" onclick="abrirPagina('tornarAmigo?param1=${users.email}&param2=${user.getEmail()}&p=Pesquisa.jsp')" value="Aceitar Solicitação">
                        <hr>
                    </div>  
                </c:forEach>
            </section>
        </article>

    </body>
</html>