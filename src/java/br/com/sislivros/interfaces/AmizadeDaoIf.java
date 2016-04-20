/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.Amizade;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public interface AmizadeDaoIf{
    
    public boolean aceitarAmiizade(String solicEnviada, String SolicRecebida);
    
    
    public List<Usuario> lisFriends(String email);
    
    public List<Amizade> mySolicitation(String email);
    
    public boolean excluirAmizade(String enviado, String recebido);
    
}
