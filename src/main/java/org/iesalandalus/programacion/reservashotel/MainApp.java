package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;

import javax.naming.OperationNotSupportedException;

public class MainApp {

public static int CAPACIDAD=15;
private static Reservas reservas;
private static Habitaciones habitaciones;
private static Huespedes huespedes;

public static void main(String[] args)  {
        Reservas reservas=new Reservas(CAPACIDAD);
        Huespedes huespedes=new Huespedes(CAPACIDAD);
        Habitaciones habitacion=new Habitaciones(CAPACIDAD);
        do {
            Consola.mostrarMenu();
            ejecutarOpcion(Consola.elegirOpcion());
        }while (Consola.elegirOpcion() !=Opcion.SALIR);

}
// esto es una prueba
private static void ejecutarOpcion(Opcion opcion){

    switch (opcion) {
        case SALIR:
            System.out.println("Hasta luego!!!!");
            break;
        case INSERTAR_HUESPED:
            insertarHuesped();
            break;
        case BUSCAR_HUESPED:
            buscarHuesped();
            break;
        case BORRAR_HUESPED:
            //borrarHuesped();
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
            //  borrarHabitacion();
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

private static void borrarHuesped() throws OperationNotSupportedException{

    Huesped huesped1;
    do {
        huesped1 = new Huesped(Consola.leerClientePorDni());
    } while (huesped1 == null);
    Huesped huesped2= huespedes.buscar(huesped1);

    huespedes.borrar(huesped2);
    System.out.println("Se ha borrado el huésped.");

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

    private static void borrarHabitacion() throws OperationNotSupportedException{

        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);
        Habitacion habitacion2= habitaciones.buscar(habitacion1);

        habitaciones.borrar(habitacion2);
        System.out.println("Se ha borrado la habitación.");

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

        }
    }

    private static void listarReservas() {}
    private static void getReservasAnulables() {}
    private static void anularReserva() {}

    private static void consultarDisponibilidad () {}

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
}
