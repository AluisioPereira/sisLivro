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
public class SolicitacaoAmizade {
    
    private String solicitacaoEnviada;
    private String solicitacaoRecebiada;
    private boolean visializado;

    public SolicitacaoAmizade() {
    }

    public SolicitacaoAmizade(String solicitacaoEnviada, String solicitacaoRecebiada, boolean visializado) {
        this.solicitacaoEnviada = solicitacaoEnviada;
        this.solicitacaoRecebiada = solicitacaoRecebiada;
        this.visializado = visializado;
    }

    public String getSolicitacaoEnviada() {
        return solicitacaoEnviada;
    }

    public void setSolicitacaoEnviada(String solicitacaoEnviada) {
        this.solicitacaoEnviada = solicitacaoEnviada;
    }

    public String getSolicitacaoRecebiada() {
        return solicitacaoRecebiada;
    }

    public void setSolicitacaoRecebiada(String solicitacaoRecebiada) {
        this.solicitacaoRecebiada = solicitacaoRecebiada;
    }

    public boolean isVisializado() {
        return visializado;
    }
    public boolean getVisialisado(){
        return this.visializado;
    }
    public void setVisializado(boolean visializado) {
        this.visializado = visializado;
    }
    

    @Override
    public String toString() {
        return "SolicitacaoAmizade{" + "solicitacaoEnviada=" + solicitacaoEnviada + ", solicitacaoRecebiada=" + solicitacaoRecebiada + ", visializado=" + visializado + '}';
    }
    
}
