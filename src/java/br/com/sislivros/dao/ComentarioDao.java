/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.ComentarioDaoIf;
import br.com.sislivros.valueobject.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Zilderlan
 */
public class ComentarioDao implements ComentarioDaoIf{

    private Comentario coment;
    private Connection conn;
    private PreparedStatement stm;
    
    @Override
    public boolean criarComentario(Comentario coment) {
        String sql = "INSERT INTO ComentarioLivro (usuario, comentario, comData) VALUES (?, ?, ?)";
        try{
        conn = Conexao.conexao();
        stm = Conexao.openStatement(sql);
        stm.setString(1, coment.getEmail());
        stm.setString(2, coment.getComentario());
        stm.setDate(3, new java.sql.Date(coment.getDate().getTime()));
        stm.executeUpdate();
        return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	}
        return false;
    }

    @Override
    public boolean excluirComentario(int id) {
        String sql = "DELETE FROM ComentarioLivro WHERE id = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	}
        return false;
    }
    
    public boolean montarComentario(String usuario, String comentario, Date data){
        coment = new Comentario(usuario, comentario, data);
        
        return criarComentario(coment);
    }
    
}
