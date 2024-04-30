package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entidade.EProduto;
import model.util.Conexao;

public class PProduto {

    private Connection cnn;

    public PProduto() {
        cnn = Conexao.getConnection();
    }

    public void inserir(EProduto produto) {
        try {
            String sql = "INSERT INTO produto (nome, datacadastro, status, nomecompra, unidadevenda, multiplovenda) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, produto.getNome());
            prd.setDate(2, new java.sql.Date(produto.getDatacadastro().getTime()));
            prd.setBoolean(3, produto.isStatus());
            prd.setString(4, produto.getNomecompra());
            prd.setString(5, produto.getUnidadevenda());
            prd.setDouble(6, produto.getMultiplovenda());
            prd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na inserção do produto: " + e.getMessage());
        }
    }

    public void alterar(EProduto produto) {
        try {
            String sql = "UPDATE produto "
                    + " SET nome = ?,"
                    + " datacadastro = ?,"
                    + " status = ?,"
                    + " nomecompra = ?,"
                    + " unidadevenda = ?,"
                    + " multiplovenda = ?"
                    + " WHERE codigo = ? ";

            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setString(1, produto.getNome());
            prd.setDate(2, new java.sql.Date(produto.getDatacadastro().getTime()));
            prd.setBoolean(3, produto.isStatus());
            prd.setString(4, produto.getNomecompra());
            prd.setString(5, produto.getUnidadevenda());
            prd.setDouble(6, produto.getMultiplovenda());
            prd.setInt(7, produto.getCodigo());

            prd.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro na alteração do produto: " + e.getMessage());
        }
    }

    public void excluir(int codigo) {
        try {
            String sql = "DELETE FROM produto "
                    + " WHERE codigo = ? ";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, codigo);

            prd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro na exclusão do produto: " + e.getMessage());
        }
    }

    public EProduto consultar(int codigo) {
        EProduto produto = new EProduto();

        try {
            String sql = "SELECT * FROM produto WHERE codigo = ?";
            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, codigo);

            ResultSet rst = prd.executeQuery();

            if (rst.next()) {
                produto.setCodigo(codigo);
                produto.setNome(rst.getString("nome"));
                produto.setDatacadastro(rst.getDate("datacadastro"));
                produto.setStatus(rst.getBoolean("status"));
                produto.setNomecompra(rst.getString("nomecompra"));
                produto.setUnidadevenda(rst.getString("unidadevenda"));
                produto.setMultiplovenda(rst.getDouble("multiplovenda"));
            }

            rst.close();

        } catch (Exception e) {
            System.out.println("Erro na consulta do produto: " + e.getMessage());
        }

        return produto;
    }

    public List<EProduto> listar() {
        List<EProduto> produtos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM produto ORDER BY codigo DESC";
            Statement prd = cnn.createStatement();

            ResultSet rst = prd.executeQuery(sql);

            while (rst.next()) {
                EProduto produto = new EProduto();

                produto.setCodigo(rst.getInt("codigo"));
                produto.setNome(rst.getString("nome"));
                produto.setDatacadastro(rst.getDate("datacadastro"));
                produto.setStatus(rst.getBoolean("status"));
                produto.setNomecompra(rst.getString("nomecompra"));
                produto.setUnidadevenda(rst.getString("unidadevenda"));
                produto.setMultiplovenda(rst.getDouble("multiplovenda"));

                produtos.add(produto);
            }

            rst.close();

        } catch (Exception e) {
            System.out.println("Erro na listagem de produtos: " + e.getMessage());
        }

        return produtos;
    }
}
