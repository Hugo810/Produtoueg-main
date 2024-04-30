/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.ECliente;
import model.negocio.NCliente;

/**
 *
 * @author heube
 */
@WebServlet(name = "CCliente", urlPatterns = {"/CCliente"})
public class CCliente extends HttpServlet {

    //Criando constantes com os nomes das paginas para serem usados aqui no controlador
    private static final String LISTAR = "listarCliente.jsp";
    private static final String MANTER = "manterCliente.jsp";

    //Criando instancia da camada de negócio
    private NCliente negocio;
    private String proxPag;

    //Construtor do controlador para poder carregar uma instancia da negócio
    public CCliente() {
        negocio = new NCliente();
        proxPag = "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Variaves de controle da pagina que estão sendo passadas na URL do sistema
        String acao = request.getParameter("acao");

        //Condições para os valores possíveis da variável 'acao'
        if (acao.equalsIgnoreCase("listar")) {

            listar(request, response);

        } else if (acao.equalsIgnoreCase("excluir")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            negocio.excluir(codigo);

            listar(request, response);

        } else if (acao.equalsIgnoreCase("alterar")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            ECliente cliente = negocio.consultar(codigo);
            request.setAttribute("cliente", cliente);
            proxPag = MANTER;
        } else if (acao.equalsIgnoreCase("incluir")) {

            ECliente cliente = new ECliente();
            request.setAttribute("cliente", cliente);
            proxPag = MANTER;

        } else {

            //Por default, se a ação não corresponder a nenhuma das anteriores
            //o comportamento do sistema será ir para a tela de listagem
            listar(request, response);
        }

        //Fim do IF
        //Constroi o objeto para navegar para a próxima tela
        RequestDispatcher pagina = request.getRequestDispatcher(proxPag);
        pagina.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String datanascimento = request.getParameter("datanascimento");

        ECliente cliente = new ECliente();
        cliente.setCodigo(Integer.parseInt(codigo));
        cliente.setNome(nome);
        cliente.setDatanascimento(Date.valueOf(datanascimento));

        if (request.getParameter("status") != null) {
            if (request.getParameter("status").equals("on")) {
                cliente.setStatus(true);
            } else {
                cliente.setStatus(false);
            }
        } else {
            cliente.setStatus(false);
        }

        negocio.salvar(cliente);

        listar(request, response);

        //Constroi o objeto para navegar para a próxima tela
        RequestDispatcher pagina = request.getRequestDispatcher(proxPag);
        pagina.forward(request, response);

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {

        List<ECliente> lstClientes = negocio.listar();
        request.setAttribute("lstClientes", lstClientes);
        proxPag = LISTAR;
    }

}
