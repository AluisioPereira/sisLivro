/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.interfaces;

import br.com.sislivros.valueobject.Livro;
import java.util.List;

/**
 *
 * @author Zilderlan
 */
public interface LivroDaoIf {
    
    public boolean livroAdd(Livro livro);
    
    public List<Livro> listarTodos();
    
    public List<Livro> pesquisarPorNome(String nome);
    
    public Livro pesquisar(int isbn);
    
    public boolean remover(int cod);
    
    public boolean remover(String nome);
    
    public Livro retornatLivro(int cod);
    
    public Livro montarLivro(String idUsuario, String titulo, int ano, String editora, String autores, String foto, String area, String isbn);
    
}
