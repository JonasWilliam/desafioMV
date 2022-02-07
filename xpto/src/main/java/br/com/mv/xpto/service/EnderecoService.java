package br.com.mv.xpto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.xpto.model.Endereco;
import br.com.mv.xpto.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	public List<Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}
	public Endereco buscarPorId(int id) {
		return enderecoRepository.findById(id).get();
	}
	public void excluir(int id) {
		enderecoRepository.deleteById(id);
	}
	
}
