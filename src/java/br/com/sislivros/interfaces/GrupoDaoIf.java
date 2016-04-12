/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.Grupo;

/**
 *
 * @author Zilderlan
 */
public interface GrupoDaoIf {
    
    public boolean criarGrupo(Grupo grupo);
    
    public boolean excluirGrupo(int id);
    
    public boolean editarGrupo(Grupo grupo);
    
    public boolean adicionarUsuarioGrupo();
    
    public boolean excluirUsuarioGrupo();
    
    public boolean adicionarPhoto(String name);
    
}
