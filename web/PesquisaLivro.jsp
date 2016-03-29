<%-- 
    Document   : index
    Created on : 16/02/2016, 21:15:20
    Author     : Zilderlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>

<!DOCTYPE html>  <!--  -->
<html lang="PT-BR">  <!--  -->
	<head>
            <meta charset="UTF-8">
            <meta http-equiv="Content-Type" content="text/html">
		<meta http-equiv="refresh" content="1000">
		<meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">
		<meta name="keywords" content="java, css, html">
		<meta name="" content="">
		<title>SisLIVROS</title>
		<link rel="stylesheet" href="css/style1.css" type="text/css" >
		         <script src="js/ajax.js"></script>
<link rel="stylesheet" href="">

	
		
		
	</head>

	<script >
$('.vote label i.fa').on('click mouseover',function(){
    // remove classe ativa de todas as estrelas
    $('.vote label i.fa').removeClass('active');
    // pegar o valor do input da estrela clicada
    var val = $(this).prev('input').val();
    //percorrer todas as estrelas
    $('.vote label i.fa').each(function(){
        /* checar de o valor clicado é menor ou igual do input atual
        *  se sim, adicionar classe active
        */
        var $input = $(this).prev('input');
        if($input.val() <= val){
            $(this).addClass('active');
        }
    });
    $("#voto").html(val); // somente para teste
});
//Ao sair da div vote
$('.vote').mouseleave(function(){
    //pegar o valor clicado
    var val = $(this).find('input:checked').val();
    //se nenhum foi clicado remover classe de todos
    if(val == undefined ){
        $('.vote label i.fa').removeClass('active');
    } else { 
        //percorrer todas as estrelas
        $('.vote label i.fa').each(function(){
            /* Testar o input atual do laço com o valor clicado
            *  se maior, remover classe, senão adicionar classe
            */
            var $input = $(this).prev('input');
            if($input.val() > val){
                $(this).removeClass('active');
            } else {
                $(this).addClass('active');
            }
        });
    }
    $("#voto").html(val); // somente para teste
});
	</script>
	<body>
            <%
               Usuario user = (Usuario) session.getAttribute("user");     
            %>
        <header> <!--  -->
            <div class="content" >
                <nav class="menu-superior">
                    <ul >
                            
                        <li ><a class="inicio" href="index.jsp" title="" >Início</a></li>
                        <%
                           
                            String pagina = "setting.jsp";
                            if (user != null && user.getTipo().equalsIgnoreCase("Administrador")){
                                pagina = "home.jsp";
                            }
                        %>
                       
                        
                        <li ><a href="<%=pagina%>" title="">Meu Espaço</a></li>
                       
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

            <div class="logo">
                <a href=""><img src="img/sis3.jpg" title="Logo da rede social SisLIVROS"></a>
            </div>
           
            <div class="header-bottom">
                 
           <%

            String message = "";
//            

           if (user != null){
           String s = (String) user.getName();
           String name[] = s.split(" ");
           %>
                
                <div class="login" >
                    <p>Olá, <a href="<%=pagina%>"><%= name[0] %></a>!</p>
                    <a href="Logout" >Sair</a>
                </div>
            <%}else {%>
                <div class="login" >
                    <p>Olá, Visitante!</p>
                    <a href="login.jsp" ><p> Entre ou cadastre-se</p></a>
                </div>
            <%}%>
           

                <div class="pesquisa">           
                    <form action="" method="post" class="form">
                        <input type="text"  name=""  placeholder="Pesquisar" class="entrada"/>
                        <input type="submit" class="btn-search"  value="Buscar" name="" />
                    </form>
                </div>
            </div>

		</header>  <!--  -->

        <aside class="search">
            <h4>Pesquisa</h4>
            <ul>
                <li><a href="serv"><img src="img/star-one.jpg" id="star-one"></a><h5>(00)</h5></li>
                <li><a href=""><img src="img/star-two.jpg" id="star-two"></a><h5>(00)</h5></li>
                <li><a href=""><img src="img/star-three.jpg" id="star-three"></a><h5>(00)</h5></li>
                <li><a href=""><img src="img/star-four.jpg" id="star-four"></a><h5>(00)</h5></li>
                <li><a href=""><img src="img/star -five.jpg" id="star-five"></a><h5>(00)</h5></li>
            </ul>

                
        </aside>
                 

            <aside class="see-most">
                <h4>Mais vistos</h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
                
            <aside class="see-coments">
                <h4>Mais comentados</h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
                 

            <aside class="aside4">
                <h4>Mais recentes</h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
                
            <aside class="aside5">
                <h4>Mais </h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
                 

            <aside class="aside6">
                <h4>Mais </h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
            <aside class="aside7">
                <h4>Mais </h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>
                 

            <aside class="aside8">
                <h4>Mais </h4>
                <ul>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                    <li><a href="" title="" >Visto</a></li>
                </ul>
            </aside>

                                
                
                <article >  <!--  -->
                    <section class="section1">  <!--  -->
                        <a href="" title=""><h3> titulo aqui</h3></a> 
                            <img src="img/livro5.jpg" title="" class="tam">
                        
                            <div class="informations">
                                <h5> Infomações</h5>
                                <h6>Título: </h6>
                                <h6> ano: </h6>
                                <h6>Editora: </h6>
                                <h6>Autores: </h6>
                                <h6>Tema/Área: </h6>
                                <h6> ISBN: </h6>
                                <h6> Resumo: </h6>
                            </div>
                    </section >  <!--  -->
                    
                   <!--  -->
		</article >  <!--  -->
                

                    
        <footer >
            <div class="container">
                <div class="content-left">
                    <img src="img/footer1.png" title="">
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam suscipit, leo a sollicitudin egestas, nisl eros hendrerit diam, in sollicitudin magna ipsum ac velit. Aliquam in porta nunc. Ut eu tellus dolor. Curabitur quis augue a ipsum tristique convallis sit amet nec arcu. Pellentesque.</p>
                    
                        		
                </div>

                <div class="content-center">
                    <img src="img/footer2.png" title="">
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam suscipit, leo a sollicitudin egestas, nisl eros hendrerit diam, in sollicitudin magna ipsum ac velit. Aliquam in porta nunc. Ut eu tellus dolor. Curabitur quis augue a ipsum tristique convallis sit amet nec arcu. Pellentesque.</p>
                    

                </div>

                <div class="content-right">
                    <img src="img/footer3.jpg" title="">
			<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam suscipit, leo a sollicitudin egestas, nisl eros hendrerit diam, in sollicitudin magna ipsum ac velit. Aliquam in porta nunc. Ut eu tellus dolor. Curabitur quis augue a ipsum tristique convallis sit amet nec arcu. Pellentesque.</p><br>

                </div>


            </div>
            <div class="rodape">
                <p>&copy Todos os direitos reservados </p>
            </div>
                    
		</footer >  <!--  -->
	</body>  <!--  -->
</html>  <!--  -->
