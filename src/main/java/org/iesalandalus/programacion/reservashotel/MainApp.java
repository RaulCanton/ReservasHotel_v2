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

private static Opcion ejecutarOpcion(Opcion opcion){
    int numopcion;
    return Consola.elegirOpcion();

}
private static Huesped insertarHuesped(){
    try {
        Huesped huesped1 = Consola.leerHuesped();
        huespedes.insertar(huesped1);
        return huesped1;
    } catch (OperationNotSupportedException e){
        System.out.println("No se puede insertar el cliente.");
    }
    return null;
}


private static Huesped buscarHuesped() throws OperationNotSupportedException {

    Huesped huesped1;
    do {
        huesped1 = new Huesped(Consola.leerClientePorDni());
    } while (huesped1 == null);

    Huesped huesped2 = huespedes.buscar(huesped1);
    if (huesped2 == null) {
        throw new OperationNotSupportedException("El dni buscado no es de un cliente.");
    } else {
        return huesped2;
    }
}

private static void borrarHuesped() throws OperationNotSupportedException{

    Huesped huesped1;
    do {
        huesped1 = new Huesped(Consola.leerClientePorDni());
    } while (huesped1 == null);
    Huesped huesped2= huespedes.buscar(huesped1);

    if (huesped2==null)
        throw new OperationNotSupportedException("El dni buscado no es de un cliente.");
    else
    {
        huespedes.borrar(huesped2);
        System.out.println("Se ha borrado el huésped.");
    }
}
    private static void mostrarHuespedes() {
        Huesped[] muestraHuespedes = huespedes.get();
        if (muestraHuespedes.length == 0) {
            throw new IllegalArgumentException ("No hay huéspedes que mostrar.");

        } else {
            System.out.println("Listado de habitaciones:");
            for (Huesped huesped : muestraHuespedes) {
                System.out.println(huesped);
            }
        }
    }
    private static Habitacion insertarHabitacion(){
        try {
            Habitacion habitacion1 = Consola.leerHabitacion();
            habitaciones.insertar(habitacion1);
            return habitacion1;
        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar la habitación.");
        }
        return null;
    }

    private static Habitacion buscarHabitacion() throws OperationNotSupportedException {
        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);

        Habitacion habitacion2 = habitaciones.buscar(habitacion1);
        if (habitacion2 == null) {
            throw new OperationNotSupportedException("El identificador no coincide con ninguna habitación");
        } else {
            return habitacion2;
        }
    }

    private static void borrarHabitacion() throws OperationNotSupportedException{

        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);
        Habitacion habitacion2= habitaciones.buscar(habitacion1);

        if (habitacion2==null)
            throw new OperationNotSupportedException("El identificador no coincide con ninguna habitación");
        else
        {
            habitaciones.borrar(habitacion2);
            System.out.println("Se ha borrado la habitación.");
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

    private static Reserva insertarReserva(){

        try {
            Reserva reserva1 = Consola.leerReserva();
            reservas.insertar(reserva1);
            return reserva1;
        } catch (OperationNotSupportedException e) {
            System.out.println("No se puede crear la reserva");
            return null;
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

    public static void main(String[] args) {
        System.out.println("Hasta luego!!!!");
    }
}
