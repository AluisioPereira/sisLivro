/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.valueobject;

import java.util.Objects;

/**
 *
 * @author Zilderlan
 */
public class Livro {
    private int id;
    private String idUsuario;
    private String titulo;
    private int ano;
    private String editora;
    private String autores;
    private String foto;
    private String area;
    private String isbn;

    public Livro(String idUsuario, String titulo, int ano, String editora, String autores, String foto, String area, String isbn) {
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.autores = autores;
        this.foto = foto;
        this.area = area;
        this.isbn = isbn;
    }

    public Livro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutores() {
        return autores;
    }

    public String getFoto() {
        return foto;
    }

    public String getArea() {
        return area;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", idUsuario=" + idUsuario + ", titulo=" + titulo + ", ano=" + ano + ", editora=" + editora + ", autores=" + autores + ", foto=" + foto + ", area=" + area + ", isbn=" + isbn + '}';
    }
  
}
