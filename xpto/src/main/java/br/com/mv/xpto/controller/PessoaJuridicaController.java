package br.com.mv.xpto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.xpto.model.PessoaFisica;
import br.com.mv.xpto.model.PessoaJuridica;
import br.com.mv.xpto.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pj")
public class PessoaJuridicaController {

	@Autowired
	PessoaJuridicaService pjService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PessoaJuridica> listarTodos() {
		return pjService.listarTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaJuridica salvar(@RequestBody PessoaJuridica pessoaJuridica) {
		return pjService.salvar(pessoaJuridica);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaJuridica buscarPorId(@PathVariable int id) {
		return pjService.buscarPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable int id) {
		pjService.excluir(id);
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaJuridica atualizar(@PathVariable int id, @RequestBody PessoaJuridica pj) {
		PessoaJuridica pjAtual = pjService.buscarPorId(id);
		pjAtual.setNome(pj.getNome());
		pjAtual.setContato(pj.getContato());
		pjAtual.setCnpj(pj.getCnpj());
		pjAtual.setEnderecos(pj.getEnderecos());
		pjAtual.setNomeFantasia(pj.getNomeFantasia());
		pjAtual.setRazaoSocial(pj.getRazaoSocial());
		return pjService.salvar(pjAtual);
	}
	

}
