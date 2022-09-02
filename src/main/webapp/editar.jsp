<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="box">
			<h2>Editar contato</h2>
			<form action="update" name="frmContato">
				<table id="tabelaNovo">
					<tr>
						<td><input type="text" name="idcon" class="Caixa3" readonly
							value="<%out.print(request.getAttribute("idcon"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="nome" class="Caixa1"
							value="<%out.print(request.getAttribute("nome"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="fone" class="Caixa2"
							value="<%out.print(request.getAttribute("fone"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="email" class="Caixa1"
							value="<%out.print(request.getAttribute("email"));%>"></td>
					</tr>

				</table>

				<a class="Botao1" onclick="validar()">Salvar</a>

			</form>
		</div>
	</div>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>