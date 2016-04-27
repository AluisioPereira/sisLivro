
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.GrupoDaoIf;
import br.com.sislivros.valueobject.Grupo;
import br.com.sislivros.valueobject.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zilderlan, Aluísio Pereira
 */
public class GrupoDao implements GrupoDaoIf{
    
    private Usuario user;
    private Grupo grupo;
    private Connection conn = null;
    private PreparedStatement stm = null;
    
    @Override
    public boolean criarGrupo(Grupo grupo){
        String sql = "INSERT INTO Grupo (id, nome, descricao) VALUES (?, ?, ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, grupo.getId());
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
        String sql = "UPDATE Grupo SET nome = ?, descricao = ?, foto = ? WHERE id = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, grupo.getName());
            stm.setString(2, grupo.getDescription());
            stm.setString(3, grupo.getPhoto());
            stm.setInt(4, grupo.getId());
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
    public List<Grupo> listarGrupo(String idUsuario){
        List list = new ArrayList();
        String sql = "SELECT * FROM Grupo g, ParticipaGrupo pg WHERE g.id = pg.idGrupo AND idUsuario = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, idUsuario);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                grupo = new Grupo();
                grupo.setI(result.getInt("id"));
                grupo.setName(result.getString("nome"));
                grupo.setDescription(result.getString("descricao"));
                
                list.add(grupo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
             e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	}
        
        return list;
    }
    
    public List<Usuario> listUser(int id, String email){
        List list = new ArrayList();
        String sql = "select * from usuario u, participagrupo pg "
        + "where u.email = pg.idusuario and pg.idgrupo = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
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
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
             e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	} 
        return list;
    }
    
    public Grupo returnGroupId(int id){
        String sql = "SELECT * FROM Grupo WHERE id = ?";
        try{
           conn = Conexao.conexao();
           stm = Conexao.openStatement(sql);
           stm.setInt(1, id);
           ResultSet result = stm.executeQuery();
           while(result.next()){
               grupo = new Grupo();
               grupo.setI(result.getInt("id"));
               grupo.setName(result.getString("nome"));
               grupo.setDescription(result.getString("descricao"));
               grupo.setPhoto(result.getString("foto"));
           }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
             e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	}
        return grupo;
    }
    
    @Override
    public List<Grupo> returnGroupName(String name){
        String sql = "SELECT * FROM Grupo WHERE nome ilike ?";
        List list = new ArrayList();
        try{
           conn = Conexao.conexao();
           stm = Conexao.openStatement(sql);
           stm.setString(1, "%"+name+"%");
           ResultSet result = stm.executeQuery();
           while(result.next()){
               grupo = new Grupo();
               grupo.setI(result.getInt("id"));
               grupo.setName(result.getString("nome"));
               grupo.setDescription(result.getString("descricao"));
               list.add(grupo);           }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
             e.printStackTrace();
	} finally {
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);	
	}
        return list;
    }
    
    public boolean verificarUser(int id, String email){
        String sql = "SELECT * FROM Usuario u, ParticipaGrupo pg WHERE pg.idgrupo = ? AND pg.idUsuario = ? AND u.email = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, email);
            stm.setString(3, email);
            ResultSet result = stm.executeQuery();
            return result.next();
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
    public boolean adicionarUsuarioGrupo(int id, String email) {
        String sql = "INSERT INTO ParticipaGrupo (idGrupo, idUsuario) VALUES (?, ?)";
        try{
           conn = Conexao.conexao();
           stm = Conexao.openStatement(sql);
           stm.setInt(1, id);
           stm.setString(2, email);
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
    public boolean excluirUsuarioGrupo(int idgrupo, String email) {
        String sql = "DELETE FROM Participagrupo WHERE idUsuario = ? And idGrupo = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            stm.setInt(2, idgrupo);
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
    public boolean adicionarPhoto(String name){
        
        return false;
    }

    public Grupo montarGrupo(int id, String name, String descrition) {
        return new Grupo(id, name, descrition);
    }  
}
