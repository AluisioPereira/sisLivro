/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public interface UsuarioDaoIf {
    
    public boolean adicionar(Usuario user);
    
    public boolean atualizar(Usuario user);
    
    public Usuario consultar(String name);
    
    public boolean deletar(String email);
    
    public List<Usuario> list(String nome);
    
    public List<Usuario> listAll();
    
    public boolean tornarAdmin(String email);
    
    public Usuario login(String login, String password);
    
    public Usuario login(Usuario user);
    
    public boolean verificaEmail(String email);
    
    public Usuario buscarUser(String email);
    
    
}
