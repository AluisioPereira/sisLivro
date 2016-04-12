
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.GrupoDaoIf;
import br.com.sislivros.valueobject.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Zilderlan, Aluísio Pereira
 */
public class GrupoDao implements GrupoDaoIf{
    
    private Connection conn = null;
    private PreparedStatement stm = null;
    
    @Override
    public boolean criarGrupo(Grupo grupo){
        String sql = "INSER INTO Grupo (idUsuario, nome, descricao) VALUES (?, ?, ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, grupo.getEmailUsuario());
            stm.setString(2, grupo.getName());
            stm.setString(3, grupo.getDescription());
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
    public boolean excluirGrupo(int id){
        String sql = "DELETE FROM Grupo WHERE id = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
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
    public boolean editarGrupo(Grupo grupo){
        String sql = "UPDATE Grupo SET nome = ?, descricao = ? WHERE id = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, grupo.getName());
            stm.setString(2, grupo.getDescription());
            stm.setInt(3, grupo.getId());
            stm.executeUpdate();
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
    public boolean adicionarUsuarioGrupo() {
        
        return false;
    }

    @Override
    public boolean excluirUsuarioGrupo() {
        
        return false;
    }
    
    @Override
    public boolean adicionarPhoto(String name){
        
        return false;
    }
    
    
    
}
