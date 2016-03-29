
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.factory.DaoFactoryIF;
import br.com.sislivros.interfaces.UsuarioDaoIf;
import br.com.sislivros.valueobject.Usuario;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorUser {
    
    public GerenciadorUser(){
        
    }
    
    public boolean userAdd(Usuario user){
//        DaoFactoryIF factory = DaoFactory.createFactory();
//        UsuarioDaoIf userDao = factory.criaUsuarioDao();
//        userDao.adicionar(user);
    return DaoFactory.createFactory().criaUsuarioDao().adicionar(user);
    }
    
  public List<Usuario> returnAll(){
      return DaoFactory.createFactory().criaUsuarioDao().listAll();
  }
  
  public Usuario userLogin(String login, String password){
    return DaoFactory.createFactory().criaUsuarioDao().login(login, password);
  }
  
  public Usuario userLogin(Usuario user){
      return DaoFactory.createFactory().criaUsuarioDao().login(user);
  }
    
  public boolean removerUsuario(String email){
      return DaoFactory.createFactory().criaUsuarioDao().deletar(email);
  }

  public boolean verificaEmail(String email){
      return DaoFactory.createFactory().criaUsuarioDao().verificaEmail(email);
  }
  
  public boolean atualizar(Usuario user){
      return DaoFactory.createFactory().criaUsuarioDao().atualizar(user);
  }
  
  public List<Usuario> listarPorNome(String nome){
      return DaoFactory.createFactory().criaUsuarioDao().list(nome);
  }
  
  
  
}
