/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.Date;

/**
 *
 * @author hugos
 */
public class EProduto {
    
    private int codigo;
    private String nome;
    private Date datacadastro;
    private boolean status;
    private String nomecompra;
    private String unidadevenda;
    private Double multiplovenda;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNomecompra() {
        return nomecompra;
    }

    public void setNomecompra(String nomecompra) {
        this.nomecompra = nomecompra;
    }

    public String getUnidadevenda() {
        return unidadevenda;
    }

    public void setUnidadevenda(String unidadevenda) {
        this.unidadevenda = unidadevenda;
    }

    public Double getMultiplovenda() {
        return multiplovenda;
    }

    public void setMultiplovenda(Double multiplovenda) {
        this.multiplovenda = multiplovenda;
    }
    


    
    //Gets para o relatório
    
    
    public String getStatusTexto(){
        if(this.status){
            return "Ativo";
        }else{
            return "Inativo";
        }
    }
   
}
