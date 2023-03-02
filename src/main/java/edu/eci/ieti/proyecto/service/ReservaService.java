package edu.eci.ieti.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.proyecto.model.Reserva;
import edu.eci.ieti.proyecto.persistence.ReservaPersistence;

@Service
public class ReservaService {
    @Autowired
    private ReservaPersistence reservaPersistence;

    public Reserva getReserva(String id) {
        return reservaPersistence.findById(id).get();
    }

    public List<Reserva> getReservas() {
        return reservaPersistence.findAll();
    }

    public boolean existsById(String id) {
        return reservaPersistence.existsById(id);
    }

    public List<Reserva> getReservasByIdUsuario(String idUsuario) {
        return reservaPersistence.findByIdUsuario(idUsuario);
    }

    public List<Reserva> getReservasByIdEspacio(String idEspacio) {
        return reservaPersistence.findByIdEspacio(idEspacio);
    }

    public List<Reserva> getReservasByEstado(String estado) {
        return reservaPersistence.findByEstado(estado);
    }

    public List<Reserva> getReservasByIdUsuarioAndEstado(String idUsuario, String estado) {
        return reservaPersistence.findByIdUsuarioAndEstado(idUsuario, estado);
    }

    public List<Reserva> getReservasByIdEspacioAndEstado(String idEspacio, String estado) {
        return reservaPersistence.findByIdEspacioAndEstado(idEspacio, estado);
    }

    public Reserva updateReserva(String id, Reserva reserva) {
        Reserva temp = reservaPersistence.findById(id).get();
        temp.setFechaInicio(reserva.getFechaInicio());
        temp.setFechaFin(reserva.getFechaFin());
        temp.setEstado(reserva.getEstado());
        temp.setIdEspacio(reserva.getIdEspacio());
        temp.setIdUsuario(reserva.getIdUsuario());
        return reservaPersistence.save(temp);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaPersistence.save(reserva);
    }

    public void deleteReservaById(String id) {
        reservaPersistence.deleteById(id);
    }

    public void deleteAll() {
        reservaPersistence.deleteAll();
    }

}

