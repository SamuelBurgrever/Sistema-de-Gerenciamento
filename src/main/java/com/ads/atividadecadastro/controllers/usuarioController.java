package com.ads.atividadecadastro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.atividadecadastro.entities.usuario;

import com.ads.atividadecadastro.repesitory.usuarioRepository;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired

    usuarioRepository repository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(usuario usuario) {

        repository.save(usuario);

        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<usuario>> listar() {
        List<usuario> usuarios = new ArrayList<>();
        usuarios = repository.findAll();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);

    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<usuario> buscarPorId(@PathVariable("id") int id) {

        usuario usuario = repository.findById(id).orElse(null);

        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }

        return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") int id) {
        usuario usuario = repository.findById(id).orElse(null);

        if (usuario != null) {
            repository.delete(usuario);
            return new ResponseEntity<>("Tabela excluída", HttpStatus.OK);
        }

        return new ResponseEntity<>("Registro não encontrado", HttpStatus.NOT_FOUND);

    }

}
