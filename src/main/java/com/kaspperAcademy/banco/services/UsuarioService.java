package com.kaspperAcademy.banco.services;

import com.kaspperAcademy.banco.models.Usuario;

import java.util.List;

public interface  UsuarioService  {

    Usuario salvar(Usuario usuario);

    Usuario atualizar(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario listarUsuario(Long id);

    void remover(Long id);



}
