package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.Scanner;

public class Reservas {


    private int capacidad;
    private int tamano;
    private Reserva [] coleccionReserva;


    public Reservas (int capacidad) {
        if (capacidad <=0){
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }

        this.capacidad=capacidad;
        coleccionReserva = new Reserva[capacidad];
        tamano =0;


    }

    public Reserva[] get(){

        return copiaProfundaReserva();
    }
    private Reserva[] copiaProfundaReserva(){
        Reserva[] copiaReserva = new Reserva[capacidad];
        for (int i =0; !tamanoSuperado(i);i++){
            copiaReserva[i] =new Reserva(copiaReserva[i]);
        }
        return copiaReserva;
    }
    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void insertar (Reserva reserva) throws OperationNotSupportedException {
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
        }
        int indice=buscarIndice(reserva);
        if (capacidadSuperada(indice)){
            throw new OperationNotSupportedException("ERROR: No se aceptan más reservas.");
        }
        if (tamanoSuperado(indice)){
            coleccionReserva[indice]= new Reserva(reserva);
            tamano++;
        }else {
            throw new OperationNotSupportedException("ERROR:Y existe una reserva con esos datos.");
        }
    }



    private int buscarIndice (Reserva reserva) {

        int indice=-1;
        boolean reservaEncontrada = false;
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede buscar el indice de una reserva nula.");
        }
        while (!tamanoSuperado(indice) && !reservaEncontrada) {
            if (coleccionReserva[indice].equals(reserva)) {
                reservaEncontrada = true;
            } else {
                indice++;
            }
        }
        return indice;
    }
    private boolean tamanoSuperado(int indice){
        return indice>=tamano;

    }

    private boolean capacidadSuperada(int indice){

        return indice>=capacidad;

    }
    public Reserva buscar (Reserva reserva){
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huésped nulo.");
        }

        int indice=buscarIndice(reserva);

        if (tamanoSuperado(indice)){
            return null;
        }else{
            return new Reserva(coleccionReserva[indice]);
        }

    }

    public void borrar (Reserva reserva) throws OperationNotSupportedException {
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }


        int indice = buscarIndice(reserva);
        if (tamanoSuperado(indice)) {
            throw new OperationNotSupportedException("ERROR:No existe ningúna reserva con ese nombre.");
        } else {
            despalzarUnaPosicionHaciaLaIzquierda(indice);
        }
    }


    private void despalzarUnaPosicionHaciaLaIzquierda(int indice){
        int i;

        for (i = indice; !tamanoSuperado(i); i++){

            coleccionReserva[i] = coleccionReserva[i+1];
        }
        coleccionReserva[i]=null;
        tamano--;

    }


    public Reserva[] getReservas (Huesped huesped){
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un huésped nulo.");
        }
        Reserva[] reservasHuesped = new Reserva[capacidad];
        int indice = 0;
        for (Reserva reserva : coleccionReserva) {
            if (reserva != null && reserva.getHuesped().equals(huesped)) {
                reservasHuesped[indice++] = new Reserva(reserva);
            }
        }
        return reservasHuesped;

    }
    public Reserva[] getReservas(TipoHabitacion tipoHabitacion){
        if (tipoHabitacion == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un aula nula.");
        }
        Reserva[] reservasTipoHabitacion = new Reserva[capacidad];
        int indice = 0;
        for (Reserva reserva : coleccionReserva) {
            if (reserva != null && reserva.getHabitacion().equals(tipoHabitacion)) {
                reservasTipoHabitacion[indice++] = new Reserva(reserva);
            }
        }
        return reservasTipoHabitacion;
    }
    public Reserva[] getReservasFuturas (Habitacion habitacion){
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de una habitación nula.");
        }
        Reserva[] reservasHabitacion = new Reserva[capacidad];
        int indice = 0;
        for (Reserva reserva : coleccionReserva) {
            if (reserva != null && reserva.getHabitacion().equals(habitacion)) {
                reservasHabitacion[indice++] = new Reserva(reserva);
            }
        }
        return reservasHabitacion;
    }

    public void realizarCheckin (Reserva reserva, LocalDate fecha){
        System.out.print("Introduce la fecha");
        fecha= Scanner

        reserva.setCheckIn(fecha);
    }
    public void realizarCheckout (Reserva reserva, LocalDate fecha){

    }
}
