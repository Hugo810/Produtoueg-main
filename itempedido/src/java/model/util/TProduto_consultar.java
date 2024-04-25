/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import model.entidade.EProduto;
import model.persistencia.PProduto;

/**
 *
 * @author hugos
 */
public class TProduto_consultar {
    
    public static void main(String[] args) {
        
        //Cria uma instancia da persistencia para usarmos
        PProduto persistencia = new PProduto();
        
        System.out.println("Iniciando a consulta de um Produto...");
        
        EProduto produto = persistencia.consultar(2);
        
        System.out.println("Codigo.....:" + produto.getCodigo());
        System.out.println("Nome.......:" + produto.getNome());
        System.out.println("DtNasc.....:" + produto.getDatacadastro());
        
        System.out.println("Produto consultado com sucesso!");
    }
    
}
