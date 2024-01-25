package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;


import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Huespedes {


    private int capacidad;
    private int tamano;
    private Huesped [] coleccionHuesped;


    public Huespedes (int capacidad) {
        if (capacidad <=0){
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }

        this.capacidad=capacidad;
        coleccionHuesped = new Huesped[capacidad];
        tamano =0;


    }

    public Huesped[] get(){

       return copiaProfundaHuesped();
    }
    private Huesped[] copiaProfundaHuesped(){

        Huesped[] copiaHuesped = new Huesped[capacidad];
        for (int i =0; !tamanoSuperado(i);i++){
            copiaHuesped[i] =new Huesped(coleccionHuesped[i]);
        }
        return copiaHuesped;
    }
    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void insertar (Huesped huesped) throws OperationNotSupportedException{
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede insertar un huésped nulo.");
        }
        int indice=buscarIndice(huesped);
        if (capacidadSuperada(indice)){
            throw new OperationNotSupportedException("ERROR: No se aceptan más huéspedes.");
        }
        if (tamanoSuperado(indice)){
            coleccionHuesped[indice]= new Huesped(huesped);
            tamano++;
        }else {
            throw new OperationNotSupportedException("ERROR:Y existe un huésped con esos datos.");
        }
    }



    private int buscarIndice (Huesped huesped) {

            int indice=-1;
            boolean huespedEncontrado = false;
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede buscar el indice de un huésped nulo.");
        }
          while (!tamanoSuperado(indice) && !huespedEncontrado) {
            if (coleccionHuesped[indice].equals(huesped)) {
                huespedEncontrado = true;
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
    public Huesped buscar (Huesped huesped){

        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huésped nulo.");
        }

        int indice=buscarIndice(huesped);
        if (tamanoSuperado(indice)){
            return null;
        }else{
            return new Huesped(coleccionHuesped[indice]);
        }

    }

    public void borrar (Huesped huesped) throws OperationNotSupportedException {
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede borrar un huésped nulo.");
        }


        int indice = buscarIndice(huesped);
        if (tamanoSuperado(indice)) {
            throw new OperationNotSupportedException("ERROR:No existe ningún huésped con ese nombre.");
        } else {
            despalzarUnaPosicionHaciaLaIzquierda(indice);
        }
    }


    private void despalzarUnaPosicionHaciaLaIzquierda(int indice){
        int i;

        for (i = indice; !tamanoSuperado(i); i++){

            coleccionHuesped[i] = coleccionHuesped[i+1];
        }
        coleccionHuesped[i]=null;
        tamano--;

    }


}
