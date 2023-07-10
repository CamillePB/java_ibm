package com.ibm.aula2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.aula2.entities.UsuarioEntity;
import com.ibm.aula2.repositories.UsuarioRepository;

import jakarta.websocket.server.PathParam;

@RequestMapping("/api/usuarios")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	// não permitir que a classe esteja vazia
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());

	}

	@GetMapping("/nome")
	public List<UsuarioEntity> retornoUsuarioPorNome(@PathParam("nome") String nome) {// padrao para requisições de url
		return usuarioRepository.findUsuarioEntityByNomeContaining(nome);
	}

	@PostMapping
	public void insereUsuarios(@RequestBody UsuarioEntity usuario) {
		usuarioRepository.save(usuario);
	}

	@PutMapping
	public void atualizaUsuario(@RequestBody UsuarioEntity usuario) {
		usuarioRepository.save(usuario);
	}

	@DeleteMapping
	public void apagaUsuarios(@PathParam("id") Long id) {
		usuarioRepository.deleteById(id);
	}

}
