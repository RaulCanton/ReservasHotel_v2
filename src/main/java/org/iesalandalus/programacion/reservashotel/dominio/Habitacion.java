package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    public static final double MIN_PRECIO_HABITACION= 40;
    public static final double MAX_PRECIO_HABITACION = 150;
    public static final int MIN_NUMERO_PUERTA=1;
    public static final int MAX_NUMERO_PUERTA=15;
    public static final int MIN_NUMERO_PLANTA=1;
    public static final int MAX_NUMERO_PLANTA=3;

    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;


    public String getIdentificador(){
        return identificador;
    }
    private void setIdentificador(String identificador){

        int numeroPlanta = Integer.parseInt(identificador.substring(0, 1));
        int numeroPuerta = Integer.parseInt(identificador.substring(1));

        if (numeroPlanta < MIN_NUMERO_PLANTA || numeroPlanta > MAX_NUMERO_PLANTA ||
                numeroPuerta < MIN_NUMERO_PUERTA || numeroPuerta > MAX_NUMERO_PUERTA) {
            throw new IllegalArgumentException("El identificador no es correcto.");
        }
    }

    public int getPlanta(){
        return planta;
    }

    private void setPlanta(int planta){
        if (planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA){
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        }
        else {
            this.planta = planta;
        }
    }

    public int getPuerta(){
        return puerta;
    }

    private void setPuerta(int puerta){
        if (puerta<MIN_NUMERO_PUERTA||puerta>MAX_NUMERO_PUERTA){
            //throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 1 ni mayor que 15.");
        }
        else {
            this.puerta = puerta;
        }
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio) {
        try {
            if (precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION) {
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150");
        }


        this.precio=precio;
    }

    public TipoHabitacion getTipoHabitacion(){
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion){
        this.tipoHabitacion=tipoHabitacion;


    }



    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion){
        try{
            setPlanta(planta);
        }  catch (IllegalArgumentException e){
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        }
        try{
            setPrecio(precio);
        }  catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
        }
        try {
            setPuerta(puerta);
        }  catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 1 ni mayor que 15.");
        }

            setTipoHabitacion(tipoHabitacion);
    }

    public Habitacion(Habitacion habitacion){
        Objects.requireNonNull(habitacion, "ERROR: No es posible copiar una habitación nula.");

            setPlanta(getPlanta());

            setPuerta(getPuerta());

            setPrecio(getPrecio());

            setTipoHabitacion(getTipoHabitacion());


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    public String toString (){
        return String.format("identificador=%s (%d-%d), precio habitación=%s, tipo habitación=%s",
                getIdentificador(),getPlanta(), getPuerta(), getPrecio(), getTipoHabitacion());
    }

}


