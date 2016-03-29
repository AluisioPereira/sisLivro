
package br.com.sislivros.factory;

import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.interfaces.LivroDaoIf;
import br.com.sislivros.interfaces.UsuarioDaoIf;

/*@author Zilderlan*/
 
public interface DaoFactoryIF {
    
    public UsuarioDaoIf criaUsuarioDao () ;
    
    public LivroDaoIf criaLivroDao();
    
}
