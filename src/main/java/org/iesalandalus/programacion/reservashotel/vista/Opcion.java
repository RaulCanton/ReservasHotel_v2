package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR("ADIOS"),
    INSERTAR_HUESPED("Inserte un huésped."),
    BUSCAR_HUESPED("Introduzca dni de huésped a buscar."),
    BORRAR_HUESPED("Introduzca dni de huésped a borrar."),
    MOSTRAR_HUESPEDES(""),
    INSERTAR_hABITACION(),
    BUSCAR_HABITACION(),
    BORRAR_HABITACION(),
    MOSTRAR_HABITACIONES(),
    INSERTAR_RESERVA(),
    ANULAR_RESERVA(),
    MOSTRAR_RESERVAS(),
    CONSULTAR_DISPONIBIIDAD();

    String mensajeAMostrar;
    private Opcion(String mensajeAMostrar){
        this.mensajeAMostrar=mensajeAMostrar;
    }

    public String toString(){
        return mensajeAMostrar;
    }
}
