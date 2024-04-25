package model.util;

import model.entidade.EProduto;
import model.persistencia.PProduto;

public class TProduto_inserir {
    
    public static void main(String[] args) {
        
        // Objeto de testes, do tipo do Produto
        EProduto produto = new EProduto();
        
        // Preenchendo o objeto produto com valores para testes
        // Se o código do produto é gerado automaticamente pelo banco de dados,
        // não precisamos definir manualmente aqui.
        produto.setCodigo(1);
        produto.setNome("Mariano molina");
        produto.setNomecompra("Nome da Compra");
        produto.setUnidadevenda("Unidade de Venda");
        produto.setMultiplovenda(2.5);
        produto.setDatacadastro(new java.util.Date());
        produto.setStatus(false); // Defina o status do produto
        
        // Cria uma instância da persistência para usarmos
        PProduto persistencia = new PProduto();
        
        System.out.println("Iniciando a inclusão de um novo produto...");
        
        // Verifica se o código do produto não é nulo
        if (produto.getCodigo() != 0) {
            persistencia.inserir(produto);
            System.out.println("Produto incluído com sucesso!");
        } else {
            System.out.println("Erro: O código do produto não pode ser nulo.");
        }
    }
    
}
