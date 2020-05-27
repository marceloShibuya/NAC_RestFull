<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="../css/style-base.css" type="text/css">
<title>VENDAS</title>
</head>
<body>
	<div>
		<form class="frm-1" action="${action_frm == null ? 'adicionar' : action_frm}" method="get">
			<fieldset>
				<legend>Cadastro das vendas</legend>
				<input type="hidden" name="txtCodVenda"
					value="${vendaObj.codigo}">
				<div>
					<label for="idNmProd">Nome do cliente</label> <input type="text"
						id="idNmProd" name="txtNomeCliente" required="required"
						placeholder="Digite o nome do cliente"
						value="${vendaObj.nome}">
				</div>
				<div>
					<label for="idQtdProd">Descrição da venda</label> <input
						type="text" id="idQtdProd" name="txtDesc" required="required"
						placeholder="Digite a quantidade do produto"
						value="${vendaObj.descricao}">
				</div>
				<div>
					<label for="idVlProd">Preço da venda</label> <input type="text"
						id="idVlProd" name="txtVl" required="required"
						placeholder="Digite o valor da venda"
						value="${vendaObj.valor}">
				</div>
				<div>
					<input type="submit" value="Cadastrar">
				</div>
			</fieldset>
		</form>
	</div>

	<c:if test="${controle != null}">
		<table>
			<tr>
				<th>NOME</th>
				<th>DATA VENDA</th>
				<th>DESCRIÇÃO</th>
				<th>VALOR DA VENDA</th>
				<th>STATUS DA VENDA</th>
				<th colspan="2">EDITAR</th>

			</tr>
			<c:forEach var="v" items="${listaVendas}" varStatus="id">
				<tr>
					<td>${v.nome}</td>
					<td>${v.dtVenda}</td>
					<td>${v.descricao}</td>
					<td>${v.valor}</td>
					<td>${v.status}</td>
					<td class="edit-td"><a href="listar?codProd=${v.codigo}"><img
							src="./img/editar.png"></a></td>
					<td class="edit-td"><a href="remover?codProd=${v.codigo}"><img
							src="./img/excluir.png"></a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>

</body>
</html>