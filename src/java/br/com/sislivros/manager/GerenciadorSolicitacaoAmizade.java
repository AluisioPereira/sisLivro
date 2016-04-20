/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.valueobject.SolicitacaoAmizade;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorSolicitacaoAmizade {
    
    public boolean enviarSolicitacao(String email1, String email2){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().add(email1, email2);
    }
    
    public List<Usuario> listarSolicitacoes(String email){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().listar(email);
    }
    
    public List<SolicitacaoAmizade> mySolicitation(String email){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().mySolicitation(email);
    }
    
    public boolean excluirSolicitacao(String solicEnviada, String SolicRecebida){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().excluir(solicEnviada, SolicRecebida);
    }
    
    public int qtdeSolicitacoes(String email){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().qtde(email);
    }
    
    public boolean clicked(String email){
        return DaoFactory.createFactory().criaSolicitacaoAmizadeDao().clicked(email);
    }
    
}
