package org.iesalandalus.programacion.reservashotel.Controlador;

import org.iesalandalus.programacion.reservashotel.Modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.vista.Vista;

import javax.naming.OperationNotSupportedException;

public class Controlador {

    private Vista vista;

    private Modelo modelo;


    public Controlador(Modelo modelo, Vista vista){

        if (modelo==null){
            throw new IllegalArgumentException("ErRRor el modelo no puede ser nulo.");
        }

        if (vista==null){
            throw new IllegalArgumentException("La vista no puede ser nula");
        }

        this.modelo=modelo;
        this.vista=vista;
        //this.vista.setControlador(this);
    }

    public void comenzar(){
        modelo.comenzar();
        //vista.comenzar();
    }
    public void terminar(){
        modelo.terminar();
        //vista.terminar();
    }

    public void insertar(Huesped huesped){
        modelo.insertarHuesped();
    }
    public Huesped buscar(Huesped huesped){
       return huesped=modelo.buscarHuesped();
    }

    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        modelo.borrarHuesped();
    }
    public Huesped[] getHuesped(){
        return modelo.getHuespedes ()[];
    }
}
