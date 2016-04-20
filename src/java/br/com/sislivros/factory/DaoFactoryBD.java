/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.factory;

import br.com.sislivros.dao.AmizadeDao;
import br.com.sislivros.dao.ComentarioDao;
import br.com.sislivros.dao.ComentarioGrupoDao;
import br.com.sislivros.dao.GrupoDao;
import br.com.sislivros.dao.LivroDao;
import br.com.sislivros.dao.SolicitacaoAmizadeDao;
import br.com.sislivros.dao.UsuarioDao;
import br.com.sislivros.interfaces.AmizadeDaoIf;
import br.com.sislivros.interfaces.ComentarioDaoIf;
import br.com.sislivros.interfaces.ComentarioGrupoDaoIf;
import br.com.sislivros.interfaces.GrupoDaoIf;
import br.com.sislivros.interfaces.LivroDaoIf;
import br.com.sislivros.interfaces.SolicitacaoAmizadeDaoIf;
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
    
    @Override
    public LivroDaoIf criaLivroDao(){
        return new LivroDao();
    }
    
    @Override
    public SolicitacaoAmizadeDaoIf criaSolicitacaoAmizadeDao(){
        return new SolicitacaoAmizadeDao();
    }

    @Override
    public AmizadeDaoIf criaAmizadeDao() {
        return new AmizadeDao();
    }
    
    public ComentarioDaoIf criaComentarioDao(){
        return new ComentarioDao();
    }
    
    public GrupoDaoIf criaGrupoDao(){
        return new GrupoDao();
    }
    
    public ComentarioGrupoDaoIf criaComentarioGrupoDao(){
        return new ComentarioGrupoDao();
    }
}
