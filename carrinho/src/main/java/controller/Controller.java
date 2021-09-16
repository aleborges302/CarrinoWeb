package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {

	// Criar objetos para acessar os metodos publicos das classes Janabeans e DAO
	JavaBeans javabeans = new JavaBeans();
	DAO dao = new DAO();
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Teste de conexao com banco de dados

		dao.testarConexao();
		// Enacaminhamento da Requisicoes
		String action = request.getServletPath();

		System.out.println("Resquisição:" + action);
		if (action.equals("/main")) {
			produtos(request, response);

		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);

		}
	}

	// Adicionar contato
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulario
		// System.out.println(request.getParameter("produto"));
		// System.out.println(request.getParameter("Quantidade"));
		// System.out.println(request.getParameter("valor"));

		// Receber os dados do formulario e armazenar temporariamente nas variaveis
		// javabeans
		// javabeans.setNome (Passo 5 - slide 21)
		// request.getParameter("nome") (Passo 4 - slide 21)
		javabeans.setProduto(request.getParameter("produto"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setValor(request.getParameter("valor"));

		// executar o metodo inserirContato (DAO) passando javabeans
		dao.inserirProduto(javabeans); // Passo 6 do slide 21 //Passo 6 do slide 21}

		// redirecionar para a pagina agenda.jsp (passo 10 do slide 21)
		response.sendRedirect("main");

	}

	// Listar Contatos

	// Listar Contatos
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// executar o metodo listarContatos() DAO - Passo 2 - Slide 22
		// O objeto lista é um vetor que recebe o retorno do metodo listarContatos()
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		// teste de recebimento
		for (int i = 0; i < lista.size(); i++) {
			// System.out.println(lista.get(i).getIdcon());
			// System.out.println(lista.get(i).getNome());
			// System.out.println(lista.get(i).getFone());
			// System.out.println(lista.get(i).getEmail());
		}

		// Despachar a lista de contatos(vetor) para o documento agenda.jsp - Passo 7 -
		// slide 22
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
		rd.forward(request, response);
	}

	// Editar um contato
	// passo 1 - Selecionar o contato
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Passo 1 do slide 23
		String id = request.getParameter("id");
		// teste de recebimento do parametro
		System.out.println(id);
		// setar a variavel idcon JavaBeans - passo 2 do slide 23
		javabeans.setId(id);
		// Executar o metodo seleconarContato (DAO) - Passo 3 do slide 23
		dao.selecionarProduto(javabeans);

		// teste de recebimento
		// System.oLut.println(javabeans.getIdcon());
		// System.out.println(javabeans.getNome());
		// System.out.println(javabeans.getFone());
		// System.out.println(javabeans.getEmail());

		// Passo 10 - slide 23 "Despachar" os dados das variaveis JavaBeans para
		// editar.jsp
		request.setAttribute("id", javabeans.getId());
		request.setAttribute("produto", javabeans.getProduto());
		request.setAttribute("quantidade", javabeans.getQuantidade());
		request.setAttribute("valor", javabeans.getValor());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	// Psso 2 - Editar Contato

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Passo 13 e 14 - slide 23 (Receber os dados do formulario e setar JavaBeans
		// request.getParameter (psso 13)
		// javabeans.set
		javabeans.setId(request.getParameter("id"));
		javabeans.setProduto(request.getParameter("produto"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setValor(request.getParameter("valor"));
		// passo 15 - slide 23 (executar o metodo alterarContato)

		dao.alterarProduto(javabeans);

		// passo 19 - redirecionar para agenda.jsp ATUALIZANDO a listagem

		response.sendRedirect("main");

	}

	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// passo3 - slide 24 (setar o idcon em JavaBeans)
		javabeans.setId(request.getParameter("id"));

		// passo 4 slide 24 (executar o metodo deletar contato passando idcon
		dao.deletarProduto(javabeans);
		// passo 8 - slide 24
		response.sendRedirect("main");
	}

}
