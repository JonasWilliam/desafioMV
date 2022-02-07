package br.com.mv.xpto.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.xpto.model.PessoaFisica;
import br.com.mv.xpto.service.PessoaFisicaService;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaController {

	@Autowired
	PessoaFisicaService pfService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PessoaFisica> listarTodos() {
		return pfService.listarTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaFisica salvar(@RequestBody PessoaFisica pessoaFisica) {
		return pfService.salvar(pessoaFisica);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaFisica buscarPorId(@PathVariable int id) {
		return pfService.buscarPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable int id) {
		pfService.excluir(id);
	}

}
