package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva {
    public static final int MAX_NUMERO_MESES_RESERVAS=6;
    public static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public static final String FORMATO_FECHA_RESERVA=("yyyy/M/d");
    public static final String FORMATO_FECHA_HORA_RESERVA="dd/MM/yyyy";

    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double precio;
    private int numeroPersonas;

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: El huésped de una reserva no puede ser nulo.");
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(){

    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        Objects.requireNonNull(regimen, "ERROR: El régimen de una reserva no puede ser nulo.");
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioreserva) {
        if (fechaInicioreserva==null){
            throw new NullPointerException("ERROR: La fecha de inicio de una reserva no puede ser nula.");
        }
        LocalDate diaActual= LocalDate.now();
        LocalDate date=diaActual.plus(Period.ofMonths(MAX_NUMERO_MESES_RESERVAS));
        if(diaActual.isAfter(fechaInicioreserva)){
            throw new DateTimeException("ERROR: La fecha de inicio de la reserva no puede ser anterior al día de hoy.");
        }
        if (fechaInicioReserva.isAfter(date)){
            throw new DateTimeException("ERROR: La fecha de inicio de la reserva no puede ser posterior a seis meses.");
        }
        else {
            this.fechaInicioReserva = fechaInicioreserva;
        }
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if ((fechaFinReserva==null)){
            throw new NullPointerException("ERROR: La fecha de fin de una reserva no puede ser nula.");
        }

        if (fechaFinReserva.isBefore(getFechaInicioReserva())){
            throw new DateTimeException("ERROR: La fecha de fin de la reserva debe ser posterior a la de inicio.");
        }
        else {
            this.fechaFinReserva = fechaFinReserva;
        }
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        if (checkIn==null){
            throw new NullPointerException("ERROR: El checkin de una reserva no puede ser nulo.");
        }
        if(checkIn.isBefore(fechaInicioReserva)){
            throw new IllegalArgumentException("ERROR: El checkin de una reserva no puede ser anterior a la fecha de inicio de la reserva. ");
        }
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {

        this.numeroPersonas = numeroPersonas;
    }

    public String toString(){
        return String.format("Huesped: %s %s Habitación:%s - %s Fecha Inicio Reserva: %s Fecha Fin Reserva: %s Checkin: %s Checkout: %s Precio: %.2f Personas: %d",getHuesped().getNombre(), getHuesped().getDni(),
                getHabitacion().getIdentificador(),getHabitacion().getTipoHabitacion(), getFechaInicioReserva().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA)),
                getFechaFinReserva(), "No registrado", "No registrado", getPrecio(), 1);

    }



}

























