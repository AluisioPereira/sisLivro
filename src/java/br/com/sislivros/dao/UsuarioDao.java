/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.UsuarioDaoIf;
import br.com.sislivros.valueobject.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UsuarioDao implements UsuarioDaoIf{
  
    private Usuario user;
    Connection conn = null;
    PreparedStatement stm = null;
    
    public UsuarioDao() {
    }
    
    

    public boolean verificaEmail(String email){
        String sql = "SELECT * FROM Usuario WHERE email ~* ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            return result.next();
        }catch(ClassNotFoundException | SQLException ex){
            ex.getMessage();
        }
        return false;
    }
    
    public static String validarEmail(String email){
        String msg = "email inválido";
        String regex = "[^0-9^\\W_][a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{3}(\\.[a-zA-Z]{2})*";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(email); 
        if (matcher.find() && matcher.group().equals(email)){ 		    
            msg = "";	
        }
        return msg;
        
    }
    public static String validarName(String name){
        String msg = "Nome inválido";
        String regex = "[^0-9^\\W_][a-z\\sA-Z]*[^\\W_0-9]";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(name); 
        if (matcher.find() && matcher.group().equals(name)){ 		    
            msg = "";	
        }
        
        return msg;
        
    }
    
    
    
    @Override
    public boolean adicionar(Usuario user) {
        String sql = "INSERT INTO USUARIO(nome, apelido, email, datanascimento, cidade, estado, senha, imagem)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

 	try {
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, user.getName());
            stm.setString(2, user.getNick());
            stm.setString(3, user.getEmail());
            stm.setDate(4, new java.sql.Date(user.getDataNasc().getTime()));
            stm.setString(5, user.getCity());
            stm.setString(6, user.getState());
            stm.setString(7, user.getSenha());
            stm.setString(8, user.getPhoto());
            stm.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
                    Conexao.closeStatement(stm);
                    Conexao.closeConnection(conn);
                    
                    
			
		}
        return true;
    
    }
    
        @Override
	public boolean atualizar(Usuario usuario) {
		Connection conn = null;

		try {
			conn = Conexao.conexao();
			String sql = "UPDATE Usuario SET nome = ?, senha = ?, apelido = ?, cidade = ?, estado = ?, datanascimento = ?, imagem = ? WHERE email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getName());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNick());
			pst.setString(4, usuario.getCity());
			pst.setString(5, usuario.getState());
			pst.setDate(6, (Date) usuario.getDataNasc());
			pst.setString(7, usuario.getPhoto());
			pst.setString(8, usuario.getEmail());
			pst.executeUpdate();
                        System.out.println("executou");
                        System.out.println(usuario.getEmail());
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.printStackTrace();

		} finally {
			Conexao.closeConnection(conn);
		}
		return false;
	}
    
    public Usuario login(String login, String password) {
        Usuario userLogin = null;
        String sql = "Select * from Usuario where apelido = ? AND password = ?";
        String s;
        try {
            conn = Conexao.conexao();
            stm = conn.prepareStatement(sql);
             stm.setString(1, login);
             stm.setString(2, password);
//        stm.setString(2, password);
//        stm.setString(3, user.getSenha());
        ResultSet result = stm.executeQuery();
           if (result.next()){
            userLogin = new Usuario();
            userLogin.setNick(result.getString("nome"));
            userLogin.setNick(result.getString("apelido"));
            userLogin.setNick(result.getString("email"));
            userLogin.setNick(result.getString("cidade"));
            userLogin.setTipo(result.getString("tipo"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
     
        return userLogin;
    }
    @Override
    public Usuario login(Usuario user) {
        Usuario userLogin = null;
        String sql = "Select * from Usuario where (apelido = ? or email = ?) and senha = ?";
        String s;
        try {
            conn = Conexao.conexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getNick());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getSenha());
//        stm.setString(2, password);
//        stm.setString(3, user.getSenha());
        ResultSet result = stm.executeQuery();
           if (result.next()){
            userLogin = new Usuario();
            userLogin.setNick(result.getString("apelido"));
            userLogin.setName(result.getString("nome"));
            userLogin.setCity(result.getString("cidade"));
            userLogin.setSenha(result.getString("senha"));
            userLogin.setEmail(result.getString("email"));
            userLogin.setPhoto(result.getString("imagem"));
            userLogin.setTipo(result.getString("tipo"));
            
        }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
     
        return userLogin;
    }

    @Override
    public Usuario consultar(String name) {
        String sql = "SELECT * FROM Usuario Where nome = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(0, sql);
        }catch(SQLException | ClassNotFoundException ex){
            
        }
        
        return user;
    }

    @Override
    public boolean deletar(String email) {
        String sql = "DELETE FROM Usuario WHERE email = ?";
        try{
        conn = Conexao.conexao();
        stm = Conexao.openStatement(sql);
        stm.setString(1, email);
        stm.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex){
            ex.getMessage();
        }
        return false;
    }
    
    public List<Usuario> list(String nome){
        List list = new ArrayList();
        String sql = "Select * from Usuario where nome ilike ?";
        PreparedStatement pre;
        try {
            conn = Conexao.conexao();
            pre  = conn.prepareStatement(sql);
            pre.setString(1, "%" + nome + "%");
            ResultSet  result = pre.executeQuery();
            
            while(result.next()){
                user = new Usuario();
                user.setEmail(result.getString("email"));
                user.setSenha(result.getString("senha"));
                user.setCity(result.getString("cidade"));
                user.setState(result.getString("estado"));
                user.setDataNasc(new java.util.Date(result.getDate("datanascimento").getTime()));
                user.setNick(result.getString("apelido"));
                user.setPhoto(result.getString("imagem"));
                user.setName(result.getString("nome"));
                user.setTipo(result.getString("tipo"));
                list.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            
        }finally{
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);
        
    }
        
        return list;
    }
    


    @Override
    public List<Usuario> listAll() {
        List list = new ArrayList();
        String sql = "Select * from Usuario ";
        
        try {
            conn = Conexao.conexao();
            stm = conn.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            System.out.println("xxxxxxxxxxxx");
            
            while(result.next()){
                user = new Usuario();
                user.setEmail(result.getString("email"));
                user.setCity(result.getString("cidade"));
                user.setDataNasc(result.getDate("datanascimento"));
                user.setNick(result.getString("apelido"));
//                user.setPhoto(result.getString("photo"));
                user.setName(result.getString("nome"));
                user.setTipo(result.getString("tipo"));
                list.add(user);
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }

    @Override
    public boolean tornarAdmin(String email) {
        return true;
    }
    
}
