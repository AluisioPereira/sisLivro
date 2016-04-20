/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.valueobject;

import java.util.Date;


public class Usuario {
    private String name;
    private String senha;
    private String nick;
    private String email;
    private Date nasc;
    private String city;
    private String state;
    private String photo;
    private String tipo;

    public Usuario() {
    }

    public String getName() {
        return name;
    }

    public String getSenha() {
        return senha;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNasc() {
        return nasc;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoto() {
        return photo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(Date nasc) {
        this.nasc = nasc;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "name=" + name + ", senha=" + senha + ", nick=" + nick + ", email=" + email + ", nasc=" + nasc + ", city=" + city + ", state=" + state + ", photo=" + photo + ", tipo=" + tipo +'}'+ "\n\n";
    }

    
    
}
