/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.manager;

import br.com.sislivros.factory.DaoFactory;
import br.com.sislivros.valueobject.Livro;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public class GerenciadorLivros {
    
    public boolean criaLivro(Livro livro){
        return DaoFactory.createFactory().criaLivroDao().livroAdd(livro);
    }
    
    public List<Livro> pesquisarporNome(String nome){
        return DaoFactory.createFactory().criaLivroDao().pesquisarPorNome(nome);
    }
    
}
