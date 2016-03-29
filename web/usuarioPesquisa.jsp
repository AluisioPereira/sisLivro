


<%@page import="java.util.List"%>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>

<%
    Usuario user = (Usuario) session.getAttribute("user");
    if (user == null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
				<a href="" ><h4>Notificações</h4></a>
				

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
                    <section>
                        <script>
                            function abrirPagina(pagina){
                            location.href = pagina;
                        }
                        </script>            

                    <h1>xxx: ${param.param}</h1>
                    <h1>${user.name}</h1>
                    <h1>${user.nick}</h1>
                    <h1>${user.email}</h1>

                    <h1>Hello World!</h1>

                


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

