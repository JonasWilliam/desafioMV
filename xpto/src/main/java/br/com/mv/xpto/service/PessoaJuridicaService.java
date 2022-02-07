package br.com.mv.xpto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.xpto.model.Endereco;
import br.com.mv.xpto.model.PessoaJuridica;
import br.com.mv.xpto.repository.EnderecoRepository;
import br.com.mv.xpto.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

	@Autowired
	PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public PessoaJuridica salvar(PessoaJuridica pessoaJuridica) {
		PessoaJuridica pj = pessoaJuridicaRepository.save(pessoaJuridica);
		List<Endereco> enderecos = pj.getEnderecos();
		for (Endereco endereco : enderecos) {
			endereco.setIdCliente(pj.getId());
			endereco = enderecoRepository.save(endereco);
		}
		return pj;
	}
	public List<PessoaJuridica> listarTodos(){
		return pessoaJuridicaRepository.findAll();
	}
	public PessoaJuridica buscarPorId(int id) {
		return pessoaJuridicaRepository.findById(id).get();
	}
	public void excluir(int id) {
		pessoaJuridicaRepository.deleteById(id);
	}
	
}
