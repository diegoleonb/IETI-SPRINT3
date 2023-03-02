package edu.eci.ieti.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.proyecto.model.Usuario;
import edu.eci.ieti.proyecto.persistence.UsuarioPersistence;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioPersistence usuarioPersistence;

    public Usuario getUsuario(String id) {
        return usuarioPersistence.findById(id).get();
    }

    public List<Usuario> getUsuarios() {
        return usuarioPersistence.findAll();
    }

    public boolean existsById(String id) {
        return usuarioPersistence.existsById(id);
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarioPersistence.findByEmail(email);
    }

    public List<Usuario> getUsuariosByNombre(String nombre) {
        return usuarioPersistence.findByNombre(nombre);
    }

    public List<Usuario> getUsuariosByApellido(String apellido) {
        return usuarioPersistence.findByApellido(apellido);
    }

    public List<Usuario> getUsuariosByNombreAndApellido(String nombre, String apellido) {
        return usuarioPersistence.findByNombreAndApellido(nombre, apellido);
    }

    public Usuario updateUsuario(String id,Usuario usuario) {
        Usuario temp = usuarioPersistence.findById(id).get();
        temp.setNombre(usuario.getNombre());
        temp.setApellido(usuario.getApellido());
        temp.setEmail(usuario.getEmail());
        temp.setPassword(usuario.getPassword());
        return usuarioPersistence.save(temp);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioPersistence.save(usuario);
    }

    public void deleteUsuarioByEmail(String email) {
        usuarioPersistence.deleteByEmail(email);
    }

    public void deleteUsuario(String id) {
        usuarioPersistence.deleteById(id);
    }

    public void deleteByEmail(String email) {
        usuarioPersistence.deleteByEmail(email);
    }

    public void deleteAllUsuarios() {
        usuarioPersistence.deleteAll();
    }

}
