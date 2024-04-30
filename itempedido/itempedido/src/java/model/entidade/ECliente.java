/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.Date;
import model.util.Data;

/**
 *
 * @author heube
 */
public class ECliente {
    
    private int codigo;
    private String nome;
    private Date datanascimento;
    private boolean status;

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

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
        //Gets para o relatório
    public String getDataFormatada(){
        return Data.formatarData(this.datanascimento);
    }
    
    public String getStatusTexto() {
        return status==true?"Ativo":"Inativo";
    }
    
    
}
