/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.conection;

import br.com.sislivros.dao.AmizadeDao;
import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.manager.GerenciadorAmizade;
import br.com.sislivros.manager.GerenciadorComentarioGrupo;
import br.com.sislivros.manager.GerenciadorGrupo;
import br.com.sislivros.manager.GerenciadorLivros;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.manager.GerenciadorUser;
import br.com.sislivros.valueobject.Grupo;
import br.com.sislivros.valueobject.Livro;
import br.com.sislivros.valueobject.Usuario;
import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class TestConection {
    
    public static void main(String args[]){
//        GerenciadorSolicitacaoAmizade g = new GerenciadorSolicitacaoAmizade();
//        System.out.println(g.qtdeSolicitacoes("aluisio11@hotmail.com"));
//        System.out.println(g.qtdeSolicitacoes("email@gmail"));

        
    Usuario user = new Usuario();
//    GerenciadorUser g1 = new GerenciadorUser();
//    user.setCity("cidade");
//    user.setDataNasc(convertDate("2010/10/10"));
//    user.setEmail("aluisio.montehorebe@gmail.com.br");
//    user.setName("Zilderlan leite da Silva");
//    user.setNick("Zilderlan");
//    user.setPhoto("foto");
//    user.setSenha("s");
//    user.setState("pb");
//        System.out.println(g1.userAdd(user));
    
//        System.out.println(g1.buscarUsuario("fulado@gmail.com"));
        GerenciadorSolicitacaoAmizade ga = new GerenciadorSolicitacaoAmizade();
//        System.out.println(ga.listarSolicitacoes("aluisio.montehorebe@gmail.com"));
        GerenciadorAmizade gAmi = new GerenciadorAmizade();
//        System.out.println(gAmi.excluirSolicitacao("zilderlan.leite@gmail.com", "aluisio.montehorebe@gmail.com"));
//        System.out.println(gAmi.excluirSolicitacao("zilderlan.leite@gmail.com", "fulado@gmail.com"));
//        gAmi.addFriend("zilderlan.leite@gmail.com", "aluisio.montehorebe@gmail.com");
//        System.out.println(ga.excluirSolicitacao("zilderlan.leite@gmail.com", "fulado@gmail.com"));
//        System.out.println(gAmi.listAmizade("aluisio.montehorebe@gmail.com"));
        
//        System.out.println(new AmizadeDao().lisFriends("zilderlan.leite@gmail.com"));
//        System.out.println(new AmizadeDao().lisFriends("fulado@gmail.com"));
                
//        List<Usuario> l = ga.listarSolicitacoes("aluisio.montehorebe@gmail.com");
        

//        System.out.println(g1.tornarAdmin("aluisio11@hotmail.com"));
        GerenciadorGrupo gp = new GerenciadorGrupo();
//        System.out.println(gp.excluirUser(694054256, "zilderlan.leite@gmail.com"));
//        System.out.println(gp.retornarUsuarioGrupo(694054256, "aluisio.montehorebe@gmail.com"));
//        System.out.println(new java.util.Date().getTime());
//        System.out.println(new java.util.Date());
        GerenciadorComentarioGrupo gCoG = new GerenciadorComentarioGrupo();
//        System.out.println(gCoG.addComentGrupo("aluisio.montehorebe@gmail.com",694054256 , "xxxxxxxxx", "ccc", "name"));
//        System.out.println(gCoG.listComment());
        GerenciadorLivros gl = new GerenciadorLivros();
        System.out.println(gl.pesquisarporNome("o"));
        
//        Livro l = new Livro("aluisio.montehorebe@gmail.com", "xxx", 2015, "xxxx", "xxxx", "foto", "exatas", "123456");
//        System.out.println(l);
//        System.out.println(gl.criaLivro(l));
//        System.out.println("lista de livros: "+gl.retornarLivro(10));
    }
//    
    
    
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
