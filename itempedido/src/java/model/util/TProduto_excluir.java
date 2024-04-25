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
public class TProduto_excluir {
    
    public static void main(String[] args) {
        
        //Cria uma instancia da persistencia para usarmos
        PProduto persistencia = new PProduto();
        
        System.out.println("Iniciando a exclusão de um Produto...");
        
        persistencia.excluir(1);
        
        System.out.println("Produto excluído com sucesso!");
    }
    
}
