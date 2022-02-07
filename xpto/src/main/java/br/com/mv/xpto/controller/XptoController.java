package br.com.mv.xpto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.xpto.model.Xpto;
import br.com.mv.xpto.service.XptoService;

@RestController
@RequestMapping("/xpto")
public class XptoController {
	
	@Autowired
	XptoService xptoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Xpto> listarTodos() {
		return xptoService.listarTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Xpto salvar(@RequestBody Xpto xpto) {
		return xptoService.salvar(xpto);
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Xpto buscarPorId(@PathVariable int id) {
		return xptoService.buscarPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable int id) {
		xptoService.excluir(id);
	}
	
}
