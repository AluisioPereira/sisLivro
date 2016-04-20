/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.SolicitacaoAmizadeDaoIf;
import br.com.sislivros.valueobject.Amizade;
import br.com.sislivros.valueobject.SolicitacaoAmizade;
import br.com.sislivros.valueobject.Usuario;
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
public class SolicitacaoAmizadeDao implements SolicitacaoAmizadeDaoIf {
    
    private Usuario user;
    private SolicitacaoAmizade solicAmizade;
    private Connection conn = null;
    private PreparedStatement stm = null;
    private int qtde = 0;
    
    @Override
    public boolean add(String enviar, String receber) {
        String SQL = "INSERT INTO SolicitacaoAmizade(solicitacaoEnviada, solicitacaoRecebida) VALUES (?, ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(SQL);
            stm.setString(1, enviar);
            stm.setString(2, receber);
            stm.executeUpdate();
           return true;
        }catch(SQLException | ClassNotFoundException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return false;
    }
    
    @Override
    public List<SolicitacaoAmizade> mySolicitation(String email){
        List list = new ArrayList();
        String sql = "SELECT * FROM SolicitacaoAmizade WHERE solicitacaoEnviada = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                solicAmizade = new SolicitacaoAmizade();
                solicAmizade.setSolicitacaoEnviada(result.getString("solicitacaoEnviada"));
                solicAmizade.setSolicitacaoRecebiada(result.getString("solicitacaoRecebida"));
                list.add(solicAmizade);
            }
        }catch(SQLException | ClassNotFoundException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return list;
    }
    
    @Override
    public List<Usuario> listar(String email){
        List list = new ArrayList();
        String sql = "SELECT * FROM SolicitacaoAmizade s, Usuario u WHERE s.solicitacaoEnviada = u.email AND solicitacaoRecebida = ?";
        try{
            conn = Conexao.conexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                solicAmizade = new SolicitacaoAmizade();
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
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        
        return list;
    }
    
    

    @Override
    public boolean excluir(String solicEnviada, String solicRecebida) {
        String sql = "DELETE FROM SolicitacaoAmizade WHERE (solicitacaoEnviada = ? AND solicitacaoRecebida = ?) OR (solicitacaoRecebida = ? AND solicitacaoEnviada = ?)";
        try{
           conn = Conexao.conexao();
           stm = Conexao.openStatement(sql);
           stm.setString(1, solicEnviada);
           stm.setString(2, solicRecebida);
           stm.setString(3, solicEnviada);
           stm.setString(4, solicRecebida);
           stm.executeUpdate();
           return true;
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return false;
    }

    @Override
    public int qtde(String email) {
        qtde = 0;
        String sql = "SELECT * FROM SolicitacaoAmizade WHERE solicitacaoRecebida = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                System.out.println(result.getBoolean("visualizado"));
                if(!result.getBoolean("visualizado"))
                    qtde++;
            }
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return qtde;
    }
    
    @Override
    public boolean clicked(String email){
        String sql = "UPDATE SolicitacaoAmizade SET visualizado = TRUE WHERE solicitacaoRecebida = ?";
        try{
           conn = Conexao.conexao();
           stm = Conexao.openStatement(sql);
           stm.setString(1, email);
           stm.executeUpdate();
           return true;
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return false;
    }

}
