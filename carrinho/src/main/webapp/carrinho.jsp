


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Carrinho de compras</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Carrinho de compras</h1>
	<a href="novo.html" class="Botao1">Novo produto</a>



	<table id="tabela">
		<!-- estatico -->
		<thead>
			<tr>
				<th>Id</th>
				<th>produto</th>
				<th>quantidade</th>
				<th>valor</th>
				<th>opções</th>
			</tr>
		</thead>
		<!-- dinamico -->

		<tbody>
			<%
			@SuppressWarnings("unchecked")
			// a linha abaixo recebe a lista da camada controller armazenando no vetor
			ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getProduto()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>"
					class="Botao1">Editar</a><a
					href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="Botao2">Excluir</a></td>

			</tr>
			<%
			}
			%>


		</tbody>

	</table>
	<script src="scripts/valida.js"></script>


</body>
</html>