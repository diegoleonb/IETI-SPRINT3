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

import edu.eci.ieti.proyecto.model.Reserva;
import edu.eci.ieti.proyecto.service.ReservaService;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas")
    public ResponseEntity<List<Reserva>> getReservas() {
        return new ResponseEntity<List<Reserva>>(reservaService.getReservas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<?> getReserva(@PathVariable("id") String id) {
        if (!reservaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Reserva>(reservaService.getReserva(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/reservas/usuario/{idUsuario}")
    public ResponseEntity<List<Reserva>> getReservasByIdUsuario(@PathVariable("idUsuario") String idUsuario) {
        return new ResponseEntity<List<Reserva>>(reservaService.getReservasByIdUsuario(idUsuario), HttpStatus.ACCEPTED);
    }

    @GetMapping("/reservas/espacio/{idEspacio}")
    public ResponseEntity<List<Reserva>> getReservasByIdEspacio(@PathVariable("idEspacio") String idEspacio) {
        return new ResponseEntity<List<Reserva>>(reservaService.getReservasByIdEspacio(idEspacio), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addReserva")
    public ResponseEntity<?> addReserva(Reserva reserva) {
        try {
            if (reservaService.existsById(reserva.getId()))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            else {
                reservaService.createReserva(reserva);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/updateReserva/{id}")
    public ResponseEntity<?> updateReserva(@PathVariable("id") String id, Reserva reserva) {
        if (reservaService.existsById(id)) {
            try {
                reservaService.updateReserva(id, reserva);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteReserva/{id}")
    public ResponseEntity<?> deleteReserva(@PathVariable("id") String id) {
        if (reservaService.existsById(id)) {
            try {
                reservaService.deleteReservaById(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

