
package br.com.sislivros.factory;

import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.interfaces.UsuarioDaoIf;

/*@author Zilderlan*/
 
public interface DaoFactoryInterface {
    
    public UsuarioDaoIf criaUsuarioDao () ;
    
}
