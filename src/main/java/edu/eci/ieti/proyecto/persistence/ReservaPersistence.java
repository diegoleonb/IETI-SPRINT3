package edu.eci.ieti.proyecto.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.proyecto.model.Reserva;

public interface ReservaPersistence extends MongoRepository<Reserva, String> {

    public Optional<Reserva> findById(String id);

    public List<Reserva> findAll();

    public boolean existsById(String id);

    public List<Reserva> findByIdUsuario(String idUsuario);

    public List<Reserva> findByIdEspacio(String idEspacio);

    public List<Reserva> findByEstado(String estado);

    public List<Reserva> findByIdUsuarioAndEstado(String idUsuario, String estado);

    public List<Reserva> findByIdEspacioAndEstado(String idEspacio, String estado);

    public void deleteById(String id);

    public void deleteAll();

}
