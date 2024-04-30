/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import model.entidade.ECliente;
import model.util.Conexao;

/**
 *
 * @author heube
 */
public class PCliente {

    //Variável local responsável pela conexão com o banco
    private Connection cnn;

    //Construtor
    public PCliente() {

        //Instancia o objeto cnn com uma nova conexão vinda da classe Conexao
        cnn = Conexao.getConnection();
    }

    public void inserir(ECliente cliente) {

        try {

            String sql = "INSERT INTO cliente (nome, datanascimento, status) "
                    + " VALUES ( ?, ?, ? )";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, cliente.getNome());
            prd.setDate(2, new java.sql.Date(cliente.getDatanascimento().getTime()));
            prd.setBoolean(3, cliente.isStatus());

            prd.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro na inserção do cliente: " + e.getMessage());
        }

    }

    public void alterar(ECliente cliente) {

        try {

            String sql = "UPDATE cliente "
                    + " SET nome = ?,"
                    + " datanascimento = ?, " 
                    + " status = ? "
                    + " WHERE codigo = ? ";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, cliente.getNome());
            prd.setDate(2, new java.sql.Date(cliente.getDatanascimento().getTime()));
            prd.setBoolean(3, cliente.isStatus());
            prd.setInt(4, cliente.getCodigo());

            prd.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro na alteração do cliente: " + e.getMessage());
        }

    }

    public void excluir(int codigo) {
        //Código para excluir um único cliente no banco de dados
        try {

            String sql = "DELETE FROM cliente "
                    + " WHERE codigo = ? ";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, codigo);

            prd.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro na exclusão do cliente: " + e.getMessage());
        }

    }

    public ECliente consultar(int codigo) {
        //Código para consultar um registro de cliente no banco de dados
        //retornando o objeto do tipo ECliente preenchido
        ECliente cliente = new ECliente();

        try {

            String sql = "SELECT * FROM cliente WHERE codigo = ?";
            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, codigo);

            ResultSet rst = prd.executeQuery();

            if (rst.next()) {
                cliente.setCodigo(codigo);
                cliente.setNome(rst.getString("nome"));
                cliente.setDatanascimento(rst.getDate("datanascimento"));
                cliente.setStatus(rst.getBoolean("status"));
            }

            rst.close();

        } catch (Exception e) {
            System.out.println("Erro na consulta do cliente: " + e.getMessage());
        }

        return cliente;
    }

    public List<ECliente> listar() {
        //Código para listar todos os registros de clientes do BD
        //Retorna uma lista de objetos do tipo ECliente
        List<ECliente> clientes = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente ORDER BY codigo DESC";
            Statement prd = cnn.createStatement();

            ResultSet rst = prd.executeQuery(sql);

            while (rst.next()) {
                ECliente cliente = new ECliente();

                cliente.setCodigo(rst.getInt("codigo"));
                cliente.setNome(rst.getString("nome"));
                cliente.setDatanascimento(rst.getDate("datanascimento"));
                cliente.setStatus(rst.getBoolean("status"));

                clientes.add(cliente);
            }

            rst.close();

        } catch (Exception e) {
            System.out.println("Erro na listagem de clientes: " + e.getMessage());
        }

        return clientes;
    }

}
