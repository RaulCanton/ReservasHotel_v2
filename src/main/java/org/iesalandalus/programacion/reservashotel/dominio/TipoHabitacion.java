package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {

SUITE("Maxi",4),SIMPLE("Pequña",1),DOBLE("Mediana",2),TRIPLE("Grande",3);

    String descripcion;
    int numeroMaximoPersonas;

    private String cadenaAMostrar;

    private TipoHabitacion(String descripcion,int numeroMaximoPersonas){
      this.descripcion=descripcion;
      this.numeroMaximoPersonas=numeroMaximoPersonas;
    }

    private TipoHabitacion(String cadenaAMostrar){
        this.cadenaAMostrar=cadenaAMostrar;
    }
    public int getNumeroMaximoPersonas(){return this.numeroMaximoPersonas;}
     public String toString(){
        return cadenaAMostrar;
    }
}



