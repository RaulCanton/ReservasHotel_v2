package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.Controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.Modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.Modelo.negocio.Reservas;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Vista {


    private static Reservas reservas;
    private static Habitaciones habitaciones;
    private static Huespedes huespedes;

    private static Controlador controlador;
    public Vista(){};
    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }
    public void comenzar(){


        do {
            Consola.mostrarMenu();
            ejecutarOpcion(Consola.elegirOpcion());
        }while (Consola.elegirOpcion() !=Opcion.SALIR);
    }

    public static void terminar(){
        controlador.terminar();
    }

    private static void ejecutarOpcion(Opcion opcion){

        switch (opcion) {
            case SALIR:
                Vista.terminar();
                break;
            case INSERTAR_HUESPED:
                insertarHuesped();
                break;
            case BUSCAR_HUESPED:
                buscarHuesped();
                break;
            case BORRAR_HUESPED:
                borrarHuesped();
                break;
            case MOSTRAR_HUESPEDES:
                mostrarHuespedes();
                break;
            case INSERTAR_HABITACION:
                insertarHabitacion();
                break;
            case BUSCAR_HABITACION:
                buscarHabitacion();
                break;
            case BORRAR_HABITACION:
                borrarHabitacion();
                break;
            case MOSTRAR_HABITACIONES:
                mostrarHabitaciones();
                break;
            case INSERTAR_RESERVA:
                insertarReserva();
                break;
            case ANULAR_RESERVA:
                anularReserva();
                break;
            case MOSTRAR_RESERVAS:
                mostrarReservas();
                break;
            case CONSULTAR_DISPONIBILIDAD:
                consultarDisponibilidad();
                break;
            case REALIZAR_CHECKIN:
                realizarCheckIn();
                break;
            case REALIZAR_CHECKOUT:
                break;

        }

    }

    private static void insertarHuesped(){
        try {
            Huesped huesped1 = Consola.leerHuesped();
            huespedes.insertar(huesped1);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar el cliente.");

        }

    }


    private static Huesped buscarHuesped() {

        Huesped huesped1;
        do {
            huesped1 = new Huesped(Consola.leerClientePorDni());
        } while (huesped1 == null);

        Huesped huesped2 = huespedes.buscar(huesped1);

        return huesped2;

    }

    private static void borrarHuesped(){

    try {
        Modelo.borrarHuesped();
    }catch (OperationNotSupportedException e){
        System.out.println("No se pudo realizar la acción deseada.");
    }catch (NullPointerException e){
        System.out.println("Datos nulos.");
    }catch (IllegalArgumentException e){
        System.out.println("ERROR: Parámetro no valido");
    }

    }
    private static void mostrarHuespedes() {
            Huesped[] muestraHuespedes = huespedes.get();

            if (muestraHuespedes.length == 0) {
                throw new IllegalArgumentException("No hay huéspedes que mostrar.");

            } else {
                System.out.println("Listado de habitaciones:");
                for (Huesped huesped : muestraHuespedes) {
                    System.out.println(huesped);
                }
            }

    }
    private static void insertarHabitacion(){
        try {
            Habitacion habitacion1 = Consola.leerHabitacion();
            habitaciones.insertar(habitacion1);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar la habitación.");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }

    }

    private static Habitacion buscarHabitacion() {
        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);

        Habitacion habitacion2 = habitaciones.buscar(habitacion1);
        return habitacion2;

    }

    private static void borrarHabitacion(){
        try {

            Habitacion habitacion1;
            do {
                habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
            } while (habitacion1 == null);
            Habitacion habitacion2 = habitaciones.buscar(habitacion1);

            habitaciones.borrar(habitacion2);
            System.out.println("Se ha borrado la habitación.");
        }catch (OperationNotSupportedException e){
            System.out.println("No se puede borrar la habitación.");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }
    }

    private static void mostrarHabitaciones() {
        Habitacion[] muestraHabitaciones = habitaciones.get();
        if (muestraHabitaciones.length == 0) {
            throw new IllegalArgumentException ("No hay habitaciones que mostrar.");

        } else {
            System.out.println("Listado de habitaciones:");
            for (Habitacion habitacion : muestraHabitaciones) {
                System.out.println(habitacion);
            }
        }
    }

    private static void insertarReserva(){

        try {
            Reserva reserva1 = Consola.leerReserva();
            reservas.insertar(reserva1);

        } catch (OperationNotSupportedException e) {
            System.out.println("No se puede crear la reserva");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }
    }

    private static void listarReservas(Huesped huesped) {

        huesped = buscarHuesped();
        Reserva[] reservaHuesped = reservas.getReservas(huesped);

        if (reservaHuesped.length == 0) {
            System.out.println("Este huésped no tiene nínguna reserva.");
        } else {
            for (Reserva reserva : reservaHuesped) {
                System.out.println("Las reservas para el huésped " + huesped + " son " + reserva);
            }
        }
    }
    private static void listarReservas(TipoHabitacion tipoHabitacion){
        tipoHabitacion=Consola.leerTipoHabitacion();
        Reserva[] reservaTipoHabitacion=reservas.getReservas(tipoHabitacion);
        if (reservaTipoHabitacion.length==0) {
            System.out.println("Este tipo de habitación no tiene nínguna reserva.");
        } else {
            for( Reserva reserva:reservaTipoHabitacion) {
                System.out.println("Las reservas para el tipo de habitación " + tipoHabitacion + " son " + reservaTipoHabitacion);
            }
        }

    }


    private static void mostrarReservas() {
        Reserva[] muestraReserva = reservas.get();
        if (muestraReserva.length == 0) {
            throw new IllegalArgumentException ("No hay reservas que mostrar.");

        } else {
            System.out.println("Listado de habitaciones:");
            for (Reserva reserva : muestraReserva) {
                System.out.println(reserva);
            }
        }
    }
    private static void anularReserva() {
        try {
            Modelo.borrarReserva();
        }catch (OperationNotSupportedException e){
            System.out.println("No se puede anular la reserva.");
        }
        catch (NullPointerException e){
            System.out.println("La reserva no puede ser nula.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }
    }

    // TODAVÍA POR HACER
    private static void getReservasAnulables() {}


    private static void consultarDisponibilidad () {}
    // ESTOS NO ESTÁN BIEN
    private static void realizarCheckIn(){
        try {
            Reserva reserva1 = Consola.leerReserva();
            LocalDate fecha = Consola.leerFecha("");

            controlador.realizarChecIn(reserva1, fecha);
        }catch (OperationNotSupportedException e){
            System.out.println("No se pudo establecer el checkIn");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }
    }
    // Estos métodos no están bien.
    private static void realizarCheckOut(){
        try {
            Reserva reserva1 = Consola.leerReserva();
            LocalDate fecha = Consola.leerFecha("");

            controlador.realizarChecIn(reserva1, fecha);
        }catch (OperationNotSupportedException e){
            System.out.println("No se pudo establecer el checkOut");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Parámetro no valido");
        }
    }


}
