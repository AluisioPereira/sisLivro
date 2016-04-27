/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.ComentarioGrupoDaoIf;
import br.com.sislivros.valueobject.ComentarioGrupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Zilderlan
 */
public class ComentarioGrupoDao implements ComentarioGrupoDaoIf{

    private ComentarioGrupo comment;
    private Connection conn = null;
    private PreparedStatement stm = null;
    
    @Override
    public boolean addComent(String email, int id, String comment, String img, String user) {
        String sql = "INSERT INTO ComentarioGrupo (email, idGrupo, comentario, dataComment, imagem, nameusuario)"+
                "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            stm.setInt(2, id);
            stm.setString(3, comment);
            stm.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            stm.setString(5, img);
            stm.setString(6, user);
            System.out.println("run");
            stm.executeUpdate();
            System.out.println("run");
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
    public boolean deleteComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ComentarioGrupo> listComment(int id){
        List list = new ArrayList();
        String sql = "SELECT * FROM ComentarioGrupo WHERE idGrupo = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                comment =  new ComentarioGrupo();
                comment.setId(result.getInt("idComentario"));
                comment.setIdGrupo(result.getInt("idGrupo"));
                comment.setComentario(result.getString("comentario"));
                comment.setEmail(result.getString("email"));
                comment.setDate(result.getDate("dataComment"));
                comment.setPhoto(result.getString("imagem"));
                comment.setUser(result.getString("nameusuario"));
                list.add(comment);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	
        return list;
        }
        }
    
}
