package com.ProjetoZup.ProjetoZup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoZup.ProjetoZup.Models.Usuario;
import com.ProjetoZup.ProjetoZup.Repository.UsuarioRepository;
import com.ProjetoZup.ProjetoZup.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "usuarioId") Long usuarioId){
        return new ResponseEntity<Usuario>(this.usuarioRepository.findById(usuarioId).get(), HttpStatus.OK);
    }
}