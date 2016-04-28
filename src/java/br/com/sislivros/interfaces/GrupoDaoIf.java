/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.Grupo;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public interface GrupoDaoIf {
    
    public boolean criarGrupo(Grupo grupo);
    
    public boolean excluirGrupo(int id);
    
    public boolean editarGrupo(Grupo grupo);
    
    public List<Grupo> listarGrupo(String idUsuario);
    
    public Grupo returnGroupId(int id);
    
    public List<Grupo> returnGroupName(String name);
    
    public boolean verificarUser(int id, String email);
    
    public boolean adicionarUsuarioGrupo(int id, String email);
    
    public boolean excluirUsuarioGrupo(int id, String email);
    
    public boolean adicionarPhoto(String name);

    public Grupo montarGrupo(int id, String name, String description, String f);
    
    List<Usuario> listUser(int id, String email);
    
}
