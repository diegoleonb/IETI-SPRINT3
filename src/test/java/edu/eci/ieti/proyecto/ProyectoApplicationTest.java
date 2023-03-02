package edu.eci.ieti.proyecto;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.proyecto.controller.ReservaController;
import edu.eci.ieti.proyecto.controller.UsuarioController;
import edu.eci.ieti.proyecto.model.Reserva;
import edu.eci.ieti.proyecto.model.Usuario;
import edu.eci.ieti.proyecto.service.ReservaService;
import edu.eci.ieti.proyecto.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest (classes = ProyectoApplication.class)
public class ProyectoApplicationTest {

    @Test
    public void contextLoads() {
    }

    //Reservas


    //Service

    @Test
    public void getReservaTestService() {
        ReservaService reservaService = mock(ReservaService.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Pendiente");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaService.getReserva("10")).thenReturn(reserva);
        assert reservaService.getReserva("10").getId().equals("10");
    }

    @Test
    public void createReservaTestService() {
        ReservaService reservaService = mock(ReservaService.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Pendiente");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaService.createReserva(reserva)).thenReturn(reserva);
        assert reservaService.createReserva(reserva).getEstado().equals("Pendiente");
    }

    @Test
    public void updateReservaTestService() {
        ReservaService reservaService = mock(ReservaService.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Activo");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaService.updateReserva("10",reserva)).thenReturn(reserva);
        assert reservaService.updateReserva("10",reserva).getEstado().equals("Activo");
    }

    @Test
    public void deleteReservaTestService(){
        ReservaService reservaService = mock(ReservaService.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Activo");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        doNothing().when(reservaService).deleteReservaById("10");
        reservaService.deleteReservaById("10");
        verify(reservaService, times(1)).deleteReservaById("10");
    }

    //Controller

    @Test
    public void getReservaTestController(){
        ReservaController reservaController = mock(ReservaController.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Pendiente");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaController.getReserva("10")).thenReturn(new ResponseEntity(reserva,HttpStatus.ACCEPTED));
        assert reservaController.getReserva("10").getStatusCode().equals(HttpStatus.ACCEPTED);
    }

    @Test
    public void createReservaTestController(){
        ReservaController reservaController = mock(ReservaController.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Pendiente");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaController.addReserva(reserva)).thenReturn(new ResponseEntity(reserva,HttpStatus.CREATED));
        assert reservaController.addReserva(reserva).getStatusCode().equals(HttpStatus.CREATED);
    }

    @Test
    public void deleteReservaTestController(){
        ReservaController reservaController = mock(ReservaController.class);
        Reserva reserva = new Reserva();
        reserva.setId("10");
        reserva.setFechaInicio("2020-10-10");
        reserva.setFechaFin("2020-10-11");
        reserva.setEstado("Pendiente");
        reserva.setIdEspacio("1");
        reserva.setIdUsuario("1");
        when(reservaController.deleteReserva("10")).thenReturn(new ResponseEntity(reserva,HttpStatus.ACCEPTED));
        reservaController.deleteReserva("10");
        verify(reservaController, times(1)).deleteReserva("10");
    }



    //Usuarios

    @Test
    public void getUsuarioTestService() {
        UsuarioService usuarioService = mock(UsuarioService.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioService.getUsuario("10")).thenReturn(usuario);
        assert usuarioService.getUsuario("10").getId().equals("10");
    }

    @Test
    public void createUsuarioTestService() {
        UsuarioService usuarioService = mock(UsuarioService.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioService.createUsuario(usuario)).thenReturn(usuario);
        assert usuarioService.createUsuario(usuario).getId().equals("10");
    }

    @Test
    public void updateUsuarioTestService() {
        UsuarioService usuarioService = mock(UsuarioService.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioService.updateUsuario("10",usuario)).thenReturn(usuario);
        assert usuarioService.updateUsuario("10",usuario).getId().equals("10");
    }

    @Test
    public void deleteUsuarioTestService() {
        UsuarioService usuarioService = mock(UsuarioService.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        doNothing().when(usuarioService).deleteUsuario("10");
        usuarioService.deleteUsuario("10");
        verify(usuarioService, times(1)).deleteUsuario("10");
    }

    //Controller

    @Test
    public void getUsuarioTestController(){
        UsuarioController usuarioController = mock(UsuarioController.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioController.getUsuario("10")).thenReturn(new ResponseEntity(usuario, HttpStatus.ACCEPTED));
        assert  usuarioController.getUsuario("10").getStatusCode().equals(HttpStatus.ACCEPTED);
    }

    @Test
    public void createUsuarioTestController(){
        UsuarioController usuarioController = mock(UsuarioController.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioController.addUsuario(usuario)).thenReturn(new ResponseEntity(usuario,HttpStatus.CREATED));
        assert usuarioController.addUsuario(usuario).getStatusCode().equals(HttpStatus.CREATED);
    }

    @Test
    public void deleteUsuarioTestController(){
        UsuarioController usuarioController = mock(UsuarioController.class);
        Usuario usuario = new Usuario();
        usuario.setId("10");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("1234");
        when(usuarioController.deleteUsuario("10")).thenReturn(new ResponseEntity(usuario,HttpStatus.ACCEPTED));
        usuarioController.deleteUsuario("10");
        verify(usuarioController, times(1)).deleteUsuario("10");
    }
}
