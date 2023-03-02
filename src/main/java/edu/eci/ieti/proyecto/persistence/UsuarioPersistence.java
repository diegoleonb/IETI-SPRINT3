package edu.eci.ieti.proyecto.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.proyecto.model.Usuario;

public interface UsuarioPersistence extends MongoRepository<Usuario, String> {

    public Optional<Usuario> findById(String id);

    public List<Usuario> findAll();

    public boolean existsById(String id);

    public Usuario findByEmail(String email);
    
    public List<Usuario> findByNombre(String nombre);

    public List<Usuario> findByApellido(String apellido);

    public List<Usuario> findByNombreAndApellido(String nombre, String apellido);

    public void deleteByEmail(String email);

    public void deleteById(String id);

    public void deleteAll();

    
}