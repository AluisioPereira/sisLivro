/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.valueobject.Grupo;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorGrupo {

    public boolean criarGrupo(Grupo grupo) {
        return DaoFactory.createFactory().criaGrupoDao().criarGrupo(grupo);
    }

    public Grupo montarGrupo(int id, String name, String description) {
        return DaoFactory.createFactory().criaGrupoDao().montarGrupo(id, name, description);
    }

    public List<Grupo> listAll(String email) {
        return DaoFactory.createFactory().criaGrupoDao().listarGrupo(email);
    }
    
    public Grupo returnGroupId (int id){
        return DaoFactory.createFactory().criaGrupoDao().returnGroupId(id);
    }
    
    public List<Grupo> returnGroupName (String name){
        return DaoFactory.createFactory().criaGrupoDao().returnGroupName(name);
    }
    
    public boolean addUser(int id, String email){
        return DaoFactory.createFactory().criaGrupoDao().adicionarUsuarioGrupo(id, email);
    }
    
    public boolean retornarUsuarioGrupo(int id, String email){
        return DaoFactory.createFactory().criaGrupoDao().verificarUser(id, email);
    }
    
    public List<Usuario> returUserGroup(int id, String email){
        return DaoFactory.createFactory().criaGrupoDao().listUser(id, email);
    }
    
    public boolean excluirUser(int id, String email){
        return DaoFactory.createFactory().criaGrupoDao().excluirUsuarioGrupo(id, email);
    }
}
