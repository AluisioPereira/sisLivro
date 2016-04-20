/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.dao;

import br.com.sislivros.conection.Conexao;
import br.com.sislivros.interfaces.AmizadeDaoIf;
import br.com.sislivros.manager.GerenciadorSolicitacaoAmizade;
import br.com.sislivros.valueobject.Amizade;
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
public class AmizadeDao implements AmizadeDaoIf{
    
    private GerenciadorSolicitacaoAmizade gso;
    private Usuario user;
    private Connection conn = null;
    private PreparedStatement stm = null;
    private Amizade amizade;
    @Override
    public boolean aceitarAmiizade(String solicEnviada, String SolicRecebida) {
        String sql = "INSERT INTO Amizade (solicitacaoEnviada, SolicitacaoRecebida) VALUES (?, ?)";
        gso = new GerenciadorSolicitacaoAmizade();
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, solicEnviada);
            stm.setString(2, SolicRecebida);
            stm.executeUpdate();
            gso.excluirSolicitacao(solicEnviada, SolicRecebida);
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
    public boolean excluirAmizade(String solicEnviada, String solicRecebida) {
        String sql = "DELETE FROM Amizade WHERE  (solicitacaoEnviada = ? AND solicitacaoRecebida = ?) OR (solicitacaoRecebida = ? AND solicitacaoEnviada = ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, solicEnviada);
            stm.setString(2, solicRecebida);
            stm.setString(3, solicEnviada);
            stm.setString(4, solicRecebida);
            stm.executeUpdate();
            System.out.println("run");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return false;
    }

    @Override
    public List<Usuario> lisFriends(String email) {
        List list = new ArrayList();
        String sql = "SELECT * FROM Amizade a, Usuario u WHERE (a.solicitacaoEnviada = u.email OR a.solicitacaoRecebida = u.email) AND (a.solicitacaoEnviada = ? OR a.solicitacaorecebida = ?)";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            stm.setString(2, email);
            System.out.println("executando");
            ResultSet result = stm.executeQuery();
            System.out.println();
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
        }catch(ClassNotFoundException | SQLException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return list;
    }
    
    @Override
    public List<Amizade> mySolicitation(String email){
        List list = new ArrayList();
        String sql = "SELECT * FROM Amizade WHERE solicitacaoRecebida = ? OR solicitacaoEnviada = ?";
        try{
            conn = Conexao.conexao();
            stm = Conexao.openStatement(sql);
            stm.setString(1, email);
            stm.setString(2, email);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                amizade = new Amizade();
                amizade.setSolicEnviada(result.getString("solicitacaoEnviada"));
                amizade.setSolicRecebida(result.getString("solicitacaoRecebida"));
                list.add(amizade);
            }
        }catch(SQLException | ClassNotFoundException ex){
            
        }finally{
            Conexao.closeConnection(conn);
            Conexao.closeStatement(stm);
        }
        return list;
    }

}
