package org.iesalandalus.programacion.reservashotel.Modelo;

import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.List;

public class Modelo {

    private static Reservas reservas;
    private static Habitaciones habitaciones;
    private static Huespedes huespedes;

    public Modelo(){}

    public void comenzar() {

        reservas = new Reservas();
        habitaciones = new Habitaciones();
        huespedes = new Huespedes();
    }
    public void terminar(){
        System.out.println("El programa ha terminado.");
    }

    public static void insertarHuesped()throws OperationNotSupportedException{

            Huesped huesped1 = Consola.leerHuesped();
            huespedes.insertar(huesped1);

    }

    public static Huesped buscarHuesped() {

        Huesped huesped1;
        do {
            huesped1 = new Huesped(Consola.leerClientePorDni());
        } while (huesped1 == null);

        Huesped huesped2 = huespedes.buscar(huesped1);

        return huesped2;

    }

    public static void borrarHuesped() throws OperationNotSupportedException{

        Huesped huesped1;
        do {
            huesped1 = new Huesped(Consola.leerClientePorDni());
        } while (huesped1 == null);
        Huesped huesped2= huespedes.buscar(huesped1);

        huespedes.borrar(huesped2);
        System.out.println("Se ha borrado el hu�sped.");

    }

    public List<Huesped> getHuespedes(){
        return huespedes.get();
    }

    public static void insertarHabitacion()throws OperationNotSupportedException{
            Habitacion habitacion1 = Consola.leerHabitacion();
            habitaciones.insertar(habitacion1);

    }
    public static Habitacion buscarHabitacion() {
        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);

        Habitacion habitacion2 = habitaciones.buscar(habitacion1);
        return habitacion2;

    }

    public static void borrarHabitacion() throws OperationNotSupportedException{

        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);
        Habitacion habitacion2= habitaciones.buscar(habitacion1);

        habitaciones.borrar(habitacion2);
        System.out.println("Se ha borrado la habitaci�n.");

    }

    public List<Habitacion> getHabitaciones(){
        return habitaciones.get();
    }
    public static void insertarReserva()throws OperationNotSupportedException{

            Reserva reserva1 = Consola.leerReserva();
            reservas.insertar(reserva1);

    }
    public static void borrarReserva() throws OperationNotSupportedException{

        Reserva reserva1;
        do {
            reserva1 = new Reserva(Consola.leerReserva());
        } while (reserva1 == null);
        Reserva reserva2= reservas.buscar(reserva1);

        reservas.borrar(reserva2);
        System.out.println("Se ha borrado la reserva.");

    }
    public static Reserva buscarReserva(Reserva reserva) {
        Reserva reserva1;
        do {
            reserva1 = new Reserva(Consola.leerReserva());
        } while (reserva1 == null);

        Reserva reserva2 = reservas.buscar(reserva1);
        return reserva2;

    }

    public List<Reserva> getReservas(){
        return reservas.get();
    }
    public List<Reserva> getReservas (Huesped huesped){
        return reservas.getReservas(huesped);
    }

    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion){
        return reservas.getReservas(tipoHabitacion);
    }

    public List<Reserva> getReservasFuturas(Habitacion habitacion){
        return reservas.getReservasFuturas(habitacion);
    }

    public void realizarCheckin(Reserva reserva, LocalDate fecha)throws OperationNotSupportedException{
        reservas.realizarCheckin(reserva,fecha);
    }

    public void realizarCheckout(Reserva reserva, LocalDate fecha)throws OperationNotSupportedException{
        reservas.realizarCheckout(reserva,fecha);
    }


}
