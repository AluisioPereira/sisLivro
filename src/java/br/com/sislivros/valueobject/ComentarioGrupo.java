/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.valueobject;

import java.util.Date;

/**
 *
 * @author Zilderlan
 */
public class Comentario {
    
    private int id;
    private String email;
    private String comentario;
    private Date date;

    public Comentario() {}
    
    public Comentario(String email, String comentario, Date date) {
        this.email = email;
        this.comentario = comentario;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", email=" + email + ", comentario=" + comentario + ", date=" + date + '}';
    }
    
    
    
}
