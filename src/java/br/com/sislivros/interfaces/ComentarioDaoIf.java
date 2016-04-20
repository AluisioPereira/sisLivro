/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.ComentarioLivro;
import br.com.sislivros.valueobject.ComentarioGrupo;

/**
 *
 * @author Zilderlan
 */
public interface ComentarioDaoIf {
    
    public boolean criarComentario(ComentarioLivro comment);
    
    public boolean excluirComentario(int id);
    
}
