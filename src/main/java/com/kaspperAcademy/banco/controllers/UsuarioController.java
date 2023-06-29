package com.kaspperAcademy.banco.controllers;

import com.kaspperAcademy.banco.models.Usuario;
import com.kaspperAcademy.banco.services.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = this.usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario){
        this.usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar( @RequestBody Usuario usuario){
        return ResponseEntity.ok(this.usuarioService.atualizar(usuario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id){
        this.usuarioService.remover(id);
        return ResponseEntity.ok("Usuário removido");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuarioPorID(@PathVariable Long id){
        Usuario usuario = this.usuarioService.listarUsuario(id);
        return ResponseEntity.ok().body(usuario);

    }


}
