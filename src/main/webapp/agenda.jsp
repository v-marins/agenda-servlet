<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Javabeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Javabeans> lista = (ArrayList<Javabeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="box">
			<h2>Lista de Contatos</h2>
			<a href="novo.html" class="Botao1">Novo contato</a>
			<table id="tabela">
				<thead>
					<tr>
						<th>id</th>
						<th>Nome</th>
						<th>Fone</th>
						<th>E-mail</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao2">Editar</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>