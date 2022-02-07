package br.com.mv.xpto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.xpto.exceptions.XptoException;
import br.com.mv.xpto.model.Xpto;
import br.com.mv.xpto.repository.XptoRepository;

@Service
public class XptoService {

	@Autowired
	XptoRepository xptoRepository;
	
	public Xpto salvar(Xpto xpto) {
		return xptoRepository.save(xpto);
	}
	public List<Xpto> listarTodos(){
		return xptoRepository.findAll();
	}
	public Xpto buscarPorId(int id) {
		return xptoRepository.findById(id).orElseThrow( () -> new XptoException(id));
	}
	public void excluir(int id) {
		xptoRepository.deleteById(id);
	}
}
