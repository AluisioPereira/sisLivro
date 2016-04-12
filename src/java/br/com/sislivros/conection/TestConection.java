/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.conection;

import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.manager.GerenciadorLivros;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Livro;
import br.com.sislivros.valueobject.Usuario;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class TestConection {
    
    public static void main(String args[]){
        GerenciadorSolicitacaoAmizade g = new GerenciadorSolicitacaoAmizade();
//        System.out.println(g.qtdeSolicitacoes("aluisio11@hotmail.com"));
        System.out.println(g.qtdeSolicitacoes("email@gmail"));
        
//    Usuario user = new Usuario();
//    GerenciadorUser gu = new GerenciadorUser();
//    
//    UsuarioDao u = new UsuarioDao();
//    
//    user.setName("xxxxx");
//    user.setNick("Zil12xxxx34");
//    user.setEmail("zilderlan123@gmail.com");
//    user.setSenha("12345");
//    user.setDataNasc(convertDate("10/10/1010"));
//    user.setCity("Cajazeiras");
//    user.setState("paraíba");
//    user.setPhoto("foto");
//    gu.atualizar(user);
//    u.atualizar(user);
//        System.out.println("Executando...");
//    GerenciadorUser managerUser = new GerenciadorUser();
//    //managerUser.userAdd(user);
//    user.setNick("a");
//    user.setSenha("a");
//    
//    Usuario s = managerUser.userLogin(user);
//        System.out.println("Inicio Login User");
//        System.out.println("Apelido: "+s.getNick());
//        System.out.println("Nome: "+s.getEmail());
//        System.out.println("Fim Login User");
//    
//    
//    List<Usuario> list = managerUser.returnAll();
//    for (Usuario u: list){
//        System.out.println(u.getName());
//    }
//testUpdate();

    
//    user.setNick("");
//    GerenciadorLivros gLivros = new GerenciadorLivros();
//    Livro l = new Livro();
//    l.setTitulo("titulo");
//    l.setAno(1900);
//    l.setEditora("editora");
//    l.setAutores("autores");
//    l.setArea("area");
//    l.setIsbn("00000000");
//    l.setFoto("foto");
        //System.out.println(gLivros.criaLivro(l));
    
    }
    
    
    
    public static Date convertDate (String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        if (date == null || date == "") return  null;
        Date data = null;
        try{
            data = new Date(sdf.parse(date).getTime());
            
        }catch(ParseException e){
            e.getMessage();
        }
        return data;
            
    }
    
    
    private static void testUpdate()  {
		Usuario u = new Usuario();
		GerenciadorUser gu = new GerenciadorUser();
		u.setName("iiiiiiiiiiiii");
		u.setNick("iiiiiiiiii");
		u.setEmail("iiiiiiii");
		u.setCity("Cachoeira dos Índios");
		u.setState("Paraíba");
		
		gu.atualizar(u);
		System.out.println("Alterado com sucesso!!");
	
		
	}
}
