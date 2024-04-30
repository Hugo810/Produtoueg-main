/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.util.List;
import model.entidade.EProduto;
import model.persistencia.PProduto;

/**
 *
 * @author hugos
 */
public class TProduto_listar {

    public static void main(String[] args) {

        //Cria uma instancia da persistencia para usarmos
        PProduto persistencia = new PProduto();

        System.out.println("Iniciando a listagem de Produtos...");

        List<EProduto> produtos = persistencia.listar();

        for (EProduto produto : produtos) {
            System.out.println("Codigo.....:" + produto.getCodigo());
            System.out.println("Nome.......:" + produto.getNome());
            System.out.println("DtNasc.....:" + produto.getDatacadastro());
            
            System.out.println("");
        }

        System.out.println("Produtos listados com sucesso!");
    }

}
