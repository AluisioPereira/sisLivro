
package br.com.sislivros.factory;

import br.com.sislivros.interfaces.AmizadeDaoIf;
import br.com.sislivros.interfaces.ComentarioDaoIf;
import br.com.sislivros.interfaces.GrupoDaoIf;
import br.com.sislivros.interfaces.LivroDaoIf;
import br.com.sislivros.interfaces.SolicitacaoAmizadeDaoIf;
import br.com.sislivros.interfaces.UsuarioDaoIf;

/*@author Zilderlan*/
 
public interface DaoFactoryIF {
    
    public UsuarioDaoIf criaUsuarioDao () ;
    
    public LivroDaoIf criaLivroDao();
    
    public SolicitacaoAmizadeDaoIf criaSolicitacaoAmizadeDao();
    
    public AmizadeDaoIf criaAmizadeDao();
    
    public ComentarioDaoIf criaComentarioDao();
    
    public GrupoDaoIf criaGrupoDao();
    
}
