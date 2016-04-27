


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
                            <li><a href="RetornarGrupo?id=${groups.id}" >${groups.name}</a></li>
                            </c:forEach>
                        <li><a href="#" onclick="document.getElementById('editarGrupo').style.display = 'block';">Editar grupo</a></li>
                        <li><a href="#" onclick="document.getElementById('criarGrupo').style.display = 'block';">Novo grupo</a></li>
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
            <section id="sections1">
                <script>
                    function abrirPagina(pagina) {
                        location.href = pagina;
                    }
                </script>
                <%
                    String msg = "Participar do Grupo";
                    String pag = "participarGrupo";
                %>
                <div id="img-grupo">
                    <img src="${grupo.photo}" alt="Imagem do grupo" title="Imagem do grupo">
                    <h2 id="group-name">${grupo.name}</h2>
                    <c:if test="${b eq true}">
                        <%
                            msg = "Sair do Grupo";
                            pag = "sairGrupo";
                        %>
                    </c:if>
                    <input type="button" value="<%=msg%>" id="entrou" onclick="abrirPagina('<%=pag%>?param=${grupo.id}&p=Grupo.jsp')">

                </div>                
            </section>            
            <!--Envia comentário-->
            <section id="sections">

                <div id="form-grupo">
                    <form action="RecDadosCometGroup?param=comment-add&id=${grupo.id}&p=Grupo.jsp" method="post" enctype="multipart/form-data">
                        <hr>
                        <img src="${user.photo}">
                        <textarea value="" name="textGrupo" id="textGrupo" placeholder="Escreva algo" rows="" cols="60"></textarea>
                        <hr>
                        <input type="file" id="select-img"  name="img-comment">
                        <input type="submit" value="Publicar" id="publicar-grupo">
                    </form>
                </div>                
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
                <div id="editarGrupo">
                    <form action="RecDadosCometGroup?param=edit" method="post" enctype="multipart/form-data">
                        <img src="${grupo.photo}"> 
                        <input type="file" name="img-group" id="img-group-add">
                        <div id="nameGrupo">
                            <input  type="text" class="nameGrupo" name="nameGrupo1" placeholder="Nome do Grupo">
                        </div>
                        <div id="descricaoGrupo" name="descricaoGrupo">
                            <textarea type="text" class="descricaoGrupo" name="descricaoGrupo"  placeholder="Descrição do grupo"></textarea>
                        </div>
                        <input type="submit" id="enviarDescricao" value="Concluir">
                        <input type="button" id="cancelarDescricao" value="Cancelar" onclick="document.getElementById('editarGrupo').style.display = 'none';">
                    </form>
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
                <a href="cancelaSolicitacao?p=Grupo.jsp" id="close">Fechar</a>
                <%
                    request.setAttribute("setting", "setting.jsp");
                %>
                <c:forEach var="users" items="${listUser}">
                    <div class="friend" >                   
                        <img src="${users.photo}" class="img-not">
                        <a href="#"><strong>${users.name}</strong></a>
                        <input type="button" class="cancel-not" onclick="abrirPagina('cancelaSolicitacao?param1=${users.email}&p=setting.jsp')" value="Cancelar Solicitação">
                        <input type="button" class="accept-not" onclick="abrirPagina('tornarAmigo?param1=${users.email}&param2=${user.getEmail()}&p=setting.jsp')" value="Aceitar Solicitação">
                        <hr>
                    </div>  
                </c:forEach>
            </section>  
            <section >
                <div id="member">
                    <h4> Membros</h4>
                    <c:forEach var="listUser" items="${listUserGrupo}">
                        <a href="retornarUser?param=${listUser.email}"><img src="${listUser.photo} " title="${listUser.name}"></a>
                        </c:forEach>
                </div>
            </section>
            <c:forEach var="commentsGroup" items="${commentGroup}">          
                <section id="comments">
                    <div id="user">
                        <a href=""><h3> ${commentsGroup.user}</h3></a>
                    </div>
                    <div id="date">
                        <h5> ${commentsGroup.date}</h5>
                    </div>
                    <div id="img-comment">
                        <c:if test="${commentsGroup.photo ne ''}">
                            <img src="${commentsGroup.photo}" alt="Imagem comentario" >
                            ${"img\\usuario.jpg"}
                            ${commentsGroup.photo}
                        </c:if>
                    </div>
                    <div id="msg-comment">
                        <p id="comment">${commentsGroup.comentario}</p>
                    </div>
                </section>     
            </c:forEach>

        </article>

    </body>

</html>