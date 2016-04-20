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
public class ComentarioGrupo
{
    
    private int id;
    private int idGrupo;
    private String user;
    private String email;
    private String comentario;
    private String photo;
    private Date date;

    public ComentarioGrupo() {}

    public ComentarioGrupo(int id, int idGrupo, String user, String email, String comentario, String photo, Date date) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.user = user;
        this.email = email;
        this.comentario = comentario;
        this.photo = photo;
        this.date = date;
    }
    


    public int getId() {
        return id;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ComentarioGrupo{" + "id=" + id + ", idGrupo=" + idGrupo + ", user=" + user + ", email=" + email + ", comentario=" + comentario + ", photo=" + photo + ", date=" + date + '}';
    }

  
    
    
}
