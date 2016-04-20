/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.valueobject.ComentarioGrupo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorComentarioGrupo {
    
    public boolean addComentGrupo(String email, int id, String comment, String img, String user){
        return DaoFactory.createFactory().criaComentarioGrupoDao().addComent(email, id, comment, img, user);
    }
    
    public List<ComentarioGrupo> listComment(){
        return DaoFactory.createFactory().criaComentarioGrupoDao().listComment();
    }
    
}
