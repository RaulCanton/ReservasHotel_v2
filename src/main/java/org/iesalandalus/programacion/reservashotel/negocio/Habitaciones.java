package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;

public class Habitaciones {
    private int capacidad;
    private int tamano;
    private Habitacion[] coleccionHabitacion;


    public Habitacion (int capacidad) {
        if (capacidad <=0){
            throw new IllegalArgumentException("ERROR: La Habitación debe ser mayor que cero.");
        }

        this.capacidad=capacidad;
        coleccionHabitacion = new Habitacion[capacidad];
        tamano =0;

    }

    public Habitacion[] get(){

        return copiaProfundaHabitacion();
    }
    private Habitacion[] copiaProfundaHabitacion(){
        Habitacion[] copiaHabitacion = new Habitacion[capacidad];
        for (int i =0; !tamanoSuperado(i);i++){
            copiaHabitacion[i] =new Habitacion(copiaHabitacion[i]);
        }
        return copiaHabitacion;
    }
    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void insertar (Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede insertar un huésped nulo.");
        }
        int indice=buscarIndice(habitacion);
        if (capacidadSuperada(indice)){
            throw new OperationNotSupportedException("Error");
        }
        if (tamanoSuperado(indice)){
            coleccionHabitacion[indice]= new Habitacion(habitacion);
            tamano++;
        }else {
            throw new OperationNotSupportedException("ERROR:Y existe un huésped con esos datos.");
        }
    }



    private int buscarIndice (Habitacion habitacion) {

        int indice=-1;
        boolean habitacionEncontrado = false;
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede buscar el indice de un huésped nulo.");
        }
        while (!tamanoSuperado(indice) && !habitacionEncontrado) {
            if (coleccionHabitacion[indice].equals(habitacion)) {
                habitacionEncontrado = true;
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
    public Habitacion buscar (Habitacion habitacion){
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huésped nulo.");
        }

        int indice=buscarIndice(habitacion);
        boolean encontrado=false;

        if (tamanoSuperado(indice)){
            return null;
        }else{
            return new Habitacion(coleccionHabitacion[indice]);
        }

    }

    public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede borrar un huésped nulo.");
        }


        int indice = buscarIndice(habitacion);
        if (tamanoSuperado(indice)) {
            throw new OperationNotSupportedException("ERROR:No existe ningún huésped con ese nombre.");
        } else {
            despalzarUnaPosicionHaciaLaIzquierda(indice);
        }
    }


    private void despalzarUnaPosicionHaciaLaIzquierda(int indice){
        int i;

        for (i = indice; !tamanoSuperado(i); i++){

            coleccionHabitacion[i] = coleccionHabitacion[i+1];
        }
        coleccionHabitacion[i]=null;
        tamano--;

    }

}
