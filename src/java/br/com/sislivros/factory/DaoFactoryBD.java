/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.factory;

import br.com.sislivros.dao.LivroDao;
import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.interfaces.LivroDaoIf;
import br.com.sislivros.interfaces.UsuarioDaoIf;

/**
 *
 * @author Zilderlan
 */
public class DaoFactoryBD implements DaoFactoryIF{

    @Override
    public UsuarioDaoIf criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    public LivroDaoIf criaLivroDao(){
        return new LivroDao();
    }
    
}
