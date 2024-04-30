package model.negocio;

import java.util.List;
import model.entidade.EProduto;
import model.persistencia.PProduto;

public class NProduto {

    private PProduto pcl;

    // Método construtor
    public NProduto() {
        pcl = new PProduto();
    }

    // Método para salvar os dados do Produto. Verifica se é para incluir um novo registro
    // ou se é para alterar algum registro existente
    public void salvar(EProduto produto) {
        if (produto.getCodigo() == 0) {
            // Novo produto, insere no banco de dados
            pcl.inserir(produto);
        } else {
            // Produto existente, verifica se precisa atualizar
            
                
                // Salva as alterações no banco de dados
                pcl.alterar(produto);
            
                
            
        }
    }

    // Método para excluir um produto
    public void excluir(int codigo) {
        pcl.excluir(codigo);
    }

    // Método para consultar um produto pelo código
    public EProduto consultar(int codigo) {
        return pcl.consultar(codigo);
    }

    // Método para listar todos os produtos
    public List<EProduto> listar() {
        return pcl.listar();
    }
}
