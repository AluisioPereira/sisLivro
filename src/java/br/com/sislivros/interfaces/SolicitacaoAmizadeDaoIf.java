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
public interface SolicitacaoAmizadeDaoIf {
    
    public boolean add(String enviar, String receber);
    
    public boolean excluir(String email);
    
    public List<Usuario> listar(String email);
    
    public int qtde(String email);
    
    public boolean clicked();
    
}
