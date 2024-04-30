/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.negocio;

import java.util.List;
import model.entidade.ECliente;
import model.persistencia.PCliente;

/**
 *
 * @author heube
 */
public class NCliente {
    
    PCliente pcl;
    
    //Metodo construtor
    public NCliente(){
        
        pcl = new PCliente();
        
    }
    
    //Metodo para salvar os dados do cliente. Verifica se é para incluir um novo registro
    //ou se é para alterar algum registro existente
    public void salvar(ECliente cliente){
        
        //Regra de negócio que valida a idade do cliente
        //se for menor de idade, não poderá ser incluído no sistema
        if(model.util.Data.calcularIdade(cliente.getDatanascimento()) < 18){
            throw new IllegalArgumentException("O cliente precisa ser maior de idade.");
        }
        
        if( cliente.getCodigo() == 0){
            pcl.inserir(cliente);
        }else{
            pcl.alterar(cliente);
        }
        
    }
    
    //Método para excluir
    public void excluir(int codigo){
        pcl.excluir(codigo);
    }
    
    //Método para consultar um cliente
    public ECliente consultar(int codigo){
        return pcl.consultar(codigo);
    }
    
    //Método para consultar um cliente
    public List<ECliente> listar(){
        return pcl.listar();
    }
    
    
    
}
