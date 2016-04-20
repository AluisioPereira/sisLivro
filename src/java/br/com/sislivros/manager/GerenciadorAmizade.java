/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.valueobject.Amizade;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorAmizade {
    
    public boolean addFriend(String email1, String email2){
        return DaoFactory.createFactory().criaAmizadeDao().aceitarAmiizade(email1, email2);
    }
    
    public boolean deleteFriend(String email1, String email2){
        return DaoFactory.createFactory().criaAmizadeDao().excluirAmizade(email2, email2);
    }
    
    public List<Usuario> listFriends(String email){
        return DaoFactory.createFactory().criaAmizadeDao().lisFriends(email);
    }
    
    public List<Amizade> listAmizade(String email){
        return DaoFactory.createFactory().criaAmizadeDao().mySolicitation(email);
    }
    
    public boolean excluirSolicitacao(String email1, String email2){
        return DaoFactory.createFactory().criaAmizadeDao().excluirAmizade(email1, email2);
    }
    
}
