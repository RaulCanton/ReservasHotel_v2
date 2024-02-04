package org.iesalandalus.programacion.reservashotel.Modelo;

import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Modelo {
    public static int CAPACIDAD=15;
    private static Reservas reservas;
    private static Habitaciones habitaciones;
    private static Huespedes huespedes;

    public void comenzar() {

        reservas = new Reservas(CAPACIDAD);
        habitaciones = new Habitaciones(CAPACIDAD);
        huespedes = new Huespedes(CAPACIDAD);


    }
    public void terminar(){
        System.out.println("El programa ha terminado.");
    }

    public static void insertarHuesped(){
        try {
            Huesped huesped1 = Consola.leerHuesped();
            huespedes.insertar(huesped1);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar el cliente.");

        }

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
        System.out.println("Se ha borrado el huésped.");

    }

    public Huesped[] getHuespedes(){
        return huespedes.get();
    }

    public static void insertarHabitacion(){
        try {
            Habitacion habitacion1 = Consola.leerHabitacion();
            habitaciones.insertar(habitacion1);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar la habitación.");
        }

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
        System.out.println("Se ha borrado la habitación.");

    }

    public Habitacion[] getHabitaciones(){
        return habitaciones.get();
    }
    public static void insertarReserva(){

        try {
            Reserva reserva1 = Consola.leerReserva();
            reservas.insertar(reserva1);

        } catch (OperationNotSupportedException e) {
            System.out.println("No se puede crear la reserva");

        }
    }


    public Reserva[] getReservas(){
        return reservas.get();
    }

    public void realizarChecin(Reserva reserva, LocalDate fecha){
        reservas.realizarCheckin(reserva,fecha);
    }

    public void realizarChecout(Reserva reserva, LocalDate fecha){
        reservas.realizarCheckout(reserva,fecha);
    }


}
