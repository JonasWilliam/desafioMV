package br.com.mv.xpto.exceptions;

public class XptoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public XptoException(String mensagem) {
		super(mensagem);
	}

	public XptoException(int id) {
		this(String.format("Não existe um cadastro de xpto com id %d", id));
	}

}
