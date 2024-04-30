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
public class TProduto_alterar {
    
    public static void main(String[] args) {
        
        //Objeto de testes, do tipo do Produto
        EProduto produto = new EProduto();
        
        //Preenchendo o objeto produto com valores para testes
        produto.setNome("Fulano da Silva ALTERADO");
        produto.setDatacadastro(new java.util.Date());
         produto.setStatus(false);
        produto.setCodigo(1);
        
        //Cria uma instancia da persistencia para usarmos
        PProduto persistencia = new PProduto();
        
        System.out.println("Iniciando a ALTERAÇÃO do Produto...");
        
        persistencia.alterar(produto);
        
        System.out.println("Produto alterado com sucesso!");
    }
    
}
