package br.com.mv.xpto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.xpto.model.Endereco;
import br.com.mv.xpto.model.PessoaFisica;
import br.com.mv.xpto.repository.EnderecoRepository;
import br.com.mv.xpto.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public PessoaFisica salvar(PessoaFisica pessoaFisica) {
		PessoaFisica pf = pessoaFisicaRepository.save(pessoaFisica);
		List<Endereco> enderecos = pf.getEnderecos();
		for (Endereco endereco : enderecos) {
			endereco.setIdCliente(pf.getId());
			endereco = enderecoRepository.save(endereco);
		}
		return pf;

	}

	public List<PessoaFisica> listarTodos() {
		return pessoaFisicaRepository.findAll();
	}

	public PessoaFisica buscarPorId(int id) {
		return pessoaFisicaRepository.findById(id).get();
	}

	public void excluir(int id) {
		pessoaFisicaRepository.deleteById(id);
	}
}
