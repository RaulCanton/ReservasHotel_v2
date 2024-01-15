package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva {
    private static final int MAX_NUMERO_MESES_RESERVAS=10;
    private static final int MAX_HORAS_POSTERIOR_CHECKOUT=1;
    public static final String FORMATO_FECHA_RESERVA=("yyyy/M/d");

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
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioreserva) {

        LocalDate diaActual= LocalDate.now();
        LocalDate date = fechaInicioreserva;
        date=date.plus(Period.ofMonths(MAX_NUMERO_MESES_RESERVAS));
        if(diaActual.isAfter(fechaInicioreserva)){
            throw new DateTimeException("La fecha no puede ser anterior a la actual.");
        }
        if (date.isAfter(fechaInicioreserva)){
            throw new DateTimeException("La fecha de reserva no puede superar el máximo de meses.");
        }
        else {
            this.fechaInicioReserva = fechaInicioreserva;
        }
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(habitacion, reserva.habitacion) && Objects.equals(fechaInicioReserva, reserva.fechaInicioReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, fechaInicioReserva);
    }

    public String toString(){
        return String.format("Huesped: %s %s Habitación:%s - %s Fecha Inicio Reserva: %s Fecha Fin Reserva: %s Checkin: %s Checkout: %s Precio: %.2f Personas: %d",getHuesped().getNombre(), getHuesped().getDni(),
                getHabitacion().getIdentificador(),getHabitacion().getTipoHabitacion(), getFechaInicioReserva().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA)),
                getFechaFinReserva(), "No registrado", "No registrado", getPrecio(), 1);

    }
}

























