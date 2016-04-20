/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sislivros.valueobject;

/**
 *
 * @author Zilderlan
 */
public class Amizade {
    
    private int id;
    private String solicEnviada;
    private String solicRecebida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolicEnviada() {
        return solicEnviada;
    }

    public void setSolicEnviada(String solicEnviada) {
        this.solicEnviada = solicEnviada;
    }

    public String getSolicRecebida() {
        return solicRecebida;
    }

    public void setSolicRecebida(String solicRecebida) {
        this.solicRecebida = solicRecebida;
    }

    public Amizade() {
    }

    public Amizade(int id, String solicEnviada, String solicRecebida) {
        this.id = id;
        this.solicEnviada = solicEnviada;
        this.solicRecebida = solicRecebida;
    }

    @Override
    public String toString() {
        return "Amizade{" + "id=" + id + ", solicEnviada=" + solicEnviada + ", solicRecebida=" + solicRecebida + '}';
    }
    
    
    
}
