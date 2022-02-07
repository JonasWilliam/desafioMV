package br.com.mv.xpto.exceptions;

public class PessoaFisicaException  extends EntidadeNaoEncontradaException {

private static final long serialVersionUID = 1L;

public PessoaFisicaException(String mensagem) {
	super(mensagem);
}

public PessoaFisicaException(int id) {
	this(String.format("Não existe um cadastro de Pessoa Fisica com id %d", id));
}


}
