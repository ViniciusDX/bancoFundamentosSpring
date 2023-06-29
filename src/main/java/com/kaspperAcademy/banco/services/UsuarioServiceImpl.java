package com.kaspperAcademy.banco.services;

import com.kaspperAcademy.banco.models.Usuario;
import com.kaspperAcademy.banco.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {

        return this.usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario atualizar(Usuario usuario) {

        return this.usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario listarUsuario(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow();
    }

    @Override
    public void remover(Long id) {
        usuarioRepository.deleteById(id);
    }
}
