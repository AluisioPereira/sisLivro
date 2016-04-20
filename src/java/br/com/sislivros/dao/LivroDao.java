
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.LivroDaoIf;
import br.com.sislivros.valueobject.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao implements LivroDaoIf{
    private Livro livro;
    private Connection conn;
    private PreparedStatement stm;
    @Override
    public boolean livroAdd(Livro livro) {
        String sql = "INSERT INTO Livro (idUsuario, titulo, ano, editora, fotocapac, autores, tema, isbn) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, livro.getIdUsuario());
            stm.setString(2, livro.getTitulo());
            stm.setInt(3, livro.getAno());
            stm.setString(4, livro.getEditora());
            stm.setString(5, livro.getFoto());
            stm.setString(6, livro.getAutores());
            stm.setString(7, livro.getArea());
            stm.setString(8, livro.getIsbn());
            System.out.println("xxxxxxxxxxx");

            stm.executeUpdate();
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            
        }
        return false;
    }
    
        public Livro retornatLivro(int cod){
            String sql = "select * from livro where id = ?";
            try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setInt(1, cod);
            ResultSet result = stm.executeQuery();
            if (result.next()){
                livro = new Livro();
                livro.setAno(result.getInt("ano"));
                livro.setArea(result.getString("tema"));
                livro.setAutores(result.getString("autores"));
                livro.setEditora(result.getString("editora"));
                livro.setFoto(result.getString("fotocapac"));
                livro.setId(result.getInt("id"));
                livro.setIdUsuario(result.getString("idUsuario"));
                livro.setIsbn(result.getString("isbn"));
                livro.setTitulo(result.getString("titulo"));
            }
            }catch(ClassNotFoundException | SQLException ex){
                ex.getMessage();
            }
            return livro;
        }



    @Override
    public List<Livro> listarTodos() {
        List list = new ArrayList();
        String sql = "select * from livro ";
        try{
           conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                livro = new Livro();
                livro.setAno(result.getInt("ano"));
                livro.setArea(result.getString("tema"));
                livro.setAutores(result.getString("autores"));
                livro.setEditora(result.getString("editora"));
                livro.setFoto(result.getString("fotocapac"));
                livro.setId(result.getInt("id"));
                livro.setIdUsuario(result.getString("idUsuario"));
                livro.setIsbn(result.getString("isbn"));
                livro.setTitulo(result.getString("titulo"));
                list.add(livro);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            
        }finally{
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);
        }
        
        return list;
    }

    @Override
    public Livro pesquisar(int isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> pesquisarPorNome(String nome) {
        List list = new ArrayList();
        String sql = "select * from livro where titulo ilike ?";
        try{
           conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, "%" + nome + "%");
            ResultSet result = stm.executeQuery();
            System.out.println("xxxxxx");
            while(result.next()){
                livro = new Livro();
                livro.setAno(result.getInt("ano"));
                livro.setArea(result.getString("tema"));
                livro.setAutores(result.getString("autores"));
                livro.setEditora(result.getString("editora"));
                livro.setFoto(result.getString("fotocapac"));
                livro.setId(result.getInt("id"));
                livro.setIdUsuario(result.getString("idUsuario"));
                livro.setIsbn(result.getString("isbn"));
                livro.setTitulo(result.getString("titulo"));
                list.add(livro);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            
        }finally{
            Conexao.closeStatement(stm);
            Conexao.closeConnection(conn);
        }
        
        return list;
    }

    @Override
    public boolean remover(int id) {
            String sql = "DELETE FROM Livro WHERE id = ?";
        try{
        conn = Conexao.conexao();
        stm = Conexao.openStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex){
            ex.getMessage();
        }
        return false;
    }

    @Override
    public boolean remover(String nome) {
          String sql = "DELETE FROM Livro WHERE nome = ?";
        try{
        conn = Conexao.conexao();
        stm = Conexao.openStatement(sql);
        stm.setString(1, nome);
        stm.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex){
            ex.getMessage();
        }
        return false;
    }
    
    public Livro montarLivro(String idUsuario, String titulo, int ano, String editora, String autores, String foto, String area, String isbn){
        return new Livro(idUsuario, titulo, ano, editora, autores, foto, area, isbn);
    }
    
}
