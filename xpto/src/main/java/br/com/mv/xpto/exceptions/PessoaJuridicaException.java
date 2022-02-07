package br.com.mv.xpto.exceptions;

public class PessoaJuridicaException extends EntidadeNaoEncontradaException {

private static final long serialVersionUID = 1L;

public PessoaJuridicaException(String mensagem) {
	super(mensagem);
}

public PessoaJuridicaException(int id) {
	this(String.format("Não existe um cadastro de Pessoa Fisica com id %d", id));
}


}
