package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

public class Reservas {


    private int capacidad;
    private int tamano;

    public Reservas (int capacidad) {

    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public insertar (Reserva insertar){

    }

    private int buscarIndice (Reserva reserva){
        return ;
    }
    private boolean tamanoSuperado(int indice){
        return ;
    }

    private boolean capacidadSuperada(int indice){
        return;;
    }
    public Reserva buscar (Reserva reserva){
        return ;
    }

    public Reserva borrar (Reserva reserva){

    }
    private despalzarUnaPosicionHaciaLaIzquierda(int indice){

    }
    public getReservas(Huesped huesped){
        return;
    }
    public getReservas(TipoHabitacion tipoHabitacion){
        return;
    }
    public getReservasFuturas(Habitacion habitacion){
        return;
    }
}
