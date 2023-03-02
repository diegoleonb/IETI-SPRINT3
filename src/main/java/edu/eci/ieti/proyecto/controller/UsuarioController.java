package edu.eci.ieti.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.proyecto.model.Usuario;
import edu.eci.ieti.proyecto.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarios(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") String id) {
        if (!usuarioService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuarioService.getUsuario(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUsuario")
    public ResponseEntity<?> addUsuario(Usuario usuario) {
        try {
            if(usuarioService.existsById(usuario.getId()))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                else{
                    usuarioService.createUsuario(usuario);
                    return new ResponseEntity<>(HttpStatus.CREATED);
                }
        
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") String id, Usuario usuario) {
        if (usuarioService.existsById(id)) {
            try {
                usuarioService.updateUsuario(id, usuario);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") String id) {
        if (usuarioService.existsById(id)) {
            try {
                usuarioService.deleteUsuario(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}