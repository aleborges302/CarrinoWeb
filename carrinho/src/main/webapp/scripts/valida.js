/**
 * 
 */
/**
 * Validao de campos obrigatorios
@author Vinicius Akio
 */
//passo 2 slide 21
function validar() {
	let produto = frmContato.produto.value
	let quantidade = frmContato.quantidade.value
	let valor = frmContato.valor.value


	//alert(nome + ' ' + fone)
	if (produto === '') {
		alert('Preencha o produto ')
		frmContato.nome.focus()
		return false
	} else if (quantidade === '') {
		alert('Preencha a quantidade do produto')
		frmContato.fone.focus()
		return false
	} else if (valor === '') {
		alert('Preencha o valor do produto ')
		frmContato.fone.focus()
		return false


	} else {
		//a linha abiaxo envia os dados do formulario para camada controller passo 3 slide 21
		document.forms['frmContato'].submit()
	}
}



function confirmar(id) {// passo1 do slide 24
	alert(id)
	let resposta = confirm('Confirma a exlusão deste contato?')
	//confim gera  um alerta com uma caixa opçoes
	if (resposta === true) {
		window.location.href = 'delete?id=' + id
		//a linha abaixo
		// a linha abaixo envia ao controller a resquicao delete + idcon




	}

}