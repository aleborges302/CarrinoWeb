<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda WEB - Editar contato</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" readonly id="Caixa3"
					value="<%out.println(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="produto" readonly id="Caixa4"
					value="<%out.println(request.getAttribute("produto"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="quantidade" class="Caixa2"
					value="<%out.println(request.getAttribute("quantidade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor" readonly id="Caixa5"
					value="<%out.println(request.getAttribute("valor"));%>"></td>
			</tr>
		</table>
		<input type="button" value="salvar" class="Botao1" onclick="validar()">
	</form>
	<!-- a linha abaixo faz a ligacao com o documento JS -->
	<script src="scripts/valida.js"></script>
</body>
</html>