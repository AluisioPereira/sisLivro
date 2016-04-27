/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.ComentarioGrupo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public interface ComentarioGrupoDaoIf {
    
    public boolean addComent(String email, int id, String comment, String img, String user);
    
    public boolean deleteComment(int id);
    
    public List<ComentarioGrupo> listComment(int id);
    
}
