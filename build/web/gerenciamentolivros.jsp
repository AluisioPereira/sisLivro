
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sislivros.valueobject.Usuario"%>
<%@page import="br.com.sislivros.manager.GerenciadorUser"%>
<%@page import="br.com.sislivros.servlets.ListALL"%>"
<html lang="PT-BR">  <!--  -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <meta http-equiv="refresh" content="200">
        <meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">
        <meta name="" content="">
        <meta name="" content="">
        <title>Gerenciamento de Usuários</title>
        
        
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style type="text/css">
            @import "css/jquery.dataTables.css";
        </style>
        <script src="js/ajax.js"></script>
    <script src="js/tabela.js"></script>
    <script src="js/jquery.js"></script>
    <script  src="js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function(){
            $('#tb').dataTable();
        });
                
                function redireciona('.remove'){
                    location.href='ServletExcluirUsuario';
                    alert('inok');
                }
    </script>
        
        
    </head>

    


        <header> <!--  -->

                <div class="content-top">
                <div class="content-left">
                    <h2> Nome do Sistema</h2>
                    <img src="img/footer2.png" title="">
                    <h3> Logado como <code>Codigo</code></h3>

                </div>

                <div class="content-right">
                    <h3> Nome Usuário</h3>
                    <img src="img/user.jpg" title="Foto do usuário">
                    <ul >
                        <li><a href="" class="perfil">Editar Perfil</a></li>
                        <li><a href="" class="exit">Sair</a></li>
                    </ul>

                </div>

            </div>

            


        </header>

        <article >
            <section>
                <div class="content-bottom" >
            <button type="button" class="edit" id="" onclick="document.getElementById('user-add').style.display='block';">
                    <img src="img/add.jpg" title="">
            </button>
            <button type="button" class="edit" id="" onclick="document.getElementById('user-update').style.display='block';">                       
                    <img src="img/edit.jpg" title>
            </button>
                <form action="ServletExcluirUsuario" method="post" class="delete-user">
                    <input class='formContato' type='text' name='delete' id='delete' value='Assunto' onchange="alteraDiv()">

                <button class="remove" type="submit"  >
                <img src="img/remove.png" title="">
            </button>
                    
                </form>

            </div>
            </section>
        
                
        <!-- -->
        <section id="user-add">


            <form action="Servlet" method="post" id="form"class="form-add">
                
                <fieldset> <legend>Dados</legend>
                    <label id="titulo">Titulo do livro</label>
                    <input type="text" class="titulo" name="titulo" value="" id="">
                    <label id="ano">Ano de publicação</label>
                    <input type="text" class="ano" name="ano" value="" id="">
                     <label id="editora">Editora</label>
                    <input type="text" class="editora" name="editora" value="" id="">
                    <label id="area">Area</label>
                    <input type="" class="area" name="area" value="" id="">
                    <label id="autorer">Autores</label>
                    <input type="text" class="autores" name="utores" value="" id="">

                    <label id="isbn">ISBN</label>
                    <input type="text" class="isbn" name="isbn" value="" id="">
                    <img href="" class="" id="">
                    <input type="file" class="file" name="file" value="" id="">
                    <input type="submit" class="" name="" value="" id="">
                    <input type="button" class="" name="" value="" id="">
                </fieldset>
            </form >

        </section>

        <section id="user-update">
            <form action="Servlet" method="post" id=""class="form-update">
                <img src="user.jpg" title="" class="photo">
                <h4>Carregar Foto</h4>
                <input type="file" name="file"  class="btn-file" id="btn-file" onchange="document.getElementById('file-falso').value = this.value;">
                <label class="name-u">Nome de Usuário</label>
                <input for=" " type="text" name="name" placeholder="Ex:Antonio Marques" class="" id="name-u">  

                <label class="senha-u" >Senha</label>
                <input for=" " type="password" name="" placeholder="Ex: Anderc4ma5" class="" id="senha-u"> 

                <label class="email-u" >Email</label>
                <input for=" " type="email" placeholder="Ex: zilderlan@meuemail.com" name="" class="" id="email-u"> 

                <label class="tipo-u" >Tipo</label>
                <select for=" " type="select" name="select" class="" id="tipo-u" > 
                    <option value="">Selecione</option>
                    <option value="Administrador">Administrador</option>
                    <option value="Aluno">Aluno</option>
                </select>

                
                <input for=" " type="button" name="" value="Cancelar" class="cancel-u" id="" onclick="document.getElementById('user-update').style.display='none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit-u" id="">              
            </form >
        </section>

        <section clas="user-table">
            
            
      
         <div class="table">
    
            <table id="tb">
             <thead>
                <tr class="tr">
                    <th>Nome</th>
                    <th>E-Mail</th>
                    <th>Papel</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <% 
            GerenciadorUser ge = new GerenciadorUser();
            List<Usuario> list = ge.returnAll();
            for (Usuario user: list){
                %>
      
                   
                <tr>
                    <td class="td"><%= user.getName()%></td>
                    <td id=""><%= user.getEmail()%></td>
                    <td id=""><%= user.getCity()%> </td>
                    <td id=""><%= user.getNick()%></td>
                </tr>
              <%}%>
                        
                                        
                                       
                 
       
                </tbody>

            </table>
            </div>

        </section>
        </article>
    </body>
</html>