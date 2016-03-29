/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Zilderlan
 */
public class LivroDao implements LivroDaoIf{
    private Livro livro;
    private Connection conn;
    private PreparedStatement stm;
    @Override
    public boolean livroAdd(Livro livro) {
        String sql = "INSERT INTO Livro (titulo, ano, editora, autores, foto, area, isbn) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try{
            
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, livro.getTitulo());
            stm.setInt(2, livro.getAno());
            stm.setString(3, livro.getEditora());
            stm.setString(4, livro.getAutores());
            stm.setString(5, livro.getFoto());
            stm.setString(6, livro.getArea());
            stm.setString(7, livro.getIsbn());
                        System.out.println("xxxxxxxxxxx");

            stm.executeUpdate();
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            
        }
        return false;
    }


    @Override
    public List<Livro> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro pesquisar(int isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> pesquisarPorNome(String nome) {
        List list = new ArrayList();
        String sql = "Select * from Livro where nome ilike ?";
        PreparedStatement pre;
        try {
            conn = Conexao.conexao();
            pre  = conn.prepareStatement(sql);
            pre.setString(1, "%" + nome + "%");
            ResultSet  result = pre.executeQuery();
            
            while(result.next()){
                livro = new Livro();
                livro.setTitulo(result.getString("titulo"));
                livro.setAno(result.getInt("ano"));
                livro.setEditora(result.getString("editora"));
                livro.setAutores(result.getString("autores"));
                livro.setFoto(result.getString("foto"));
                livro.setArea(result.getString("area"));
                livro.setIsbn(result.getString("isbn"));
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
    public boolean remover(int isbn) {
            String sql = "DELETE FROM Livro WHERE isbn = ?";
        try{
        conn = Conexao.conexao();
        stm = Conexao.openStatement(sql);
        stm.setInt(1, isbn);
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
    
}
