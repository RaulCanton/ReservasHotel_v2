package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Consola {
    private Consola(){

    }

    public static void mostrarMenu(){
        for( Opcion opcion:Opcion.values()){
            System.out.println(opcion);
        }
    }

    public static int elegirOpcion() {
        int ordinalOpcion;
        do {
            System.out.println("Elige una opción: ");
            ordinalOpcion = Entrada.entero();
        } while (!Opcion.esOrdinalValido(ordinalOpcion));
        return ordinalOpcion;
    }

    public static Huesped leerHuesped() {
        Huesped huesped = null;
        String nombre;
        String dni;// = leerClientePorDni();
        String telefono;
        String correo;
        LocalDate fechaNacimiento=leerFecha();

        do {
            System.out.print("Introduce el nombre del huésped: ");
            nombre = Entrada.cadena();
        } while (nombre.equals(""));
        do {
            System.out.print("Introduce el dni del cliente: ");
            dni = Entrada.cadena();
        } while (dni.equals(""));
        do {
            System.out.print("Introduce el teléfono del huésped: ");
            telefono = Entrada.cadena();
        }while (telefono == null || telefono.equals(""));
        do {
            System.out.print("Introduce el correo del huésped: ");
            correo = Entrada.cadena();
        }while (correo == null || correo.equals(""));

        huesped = new Huesped(nombre,dni,telefono,correo,fechaNacimiento);
        return new Huesped(huesped);
    }
    public static String leerClientePorDni()throws OperationNotSupportedException {
        String dni;
        LocalDate fechaNacimiento=leerFecha();
        int i;
        do {
            System.out.print("Introduce el dni del cliente: ");
            dni = Entrada.cadena();
        } while (dni.equals(""));

        Huesped huesped1=new Huesped("Pepito Perez Perez",dni,"900101010","loquesea@gmail.com",fechaNacimiento);
        i= Huespedes.buscarIndice(huesped1);
        if (i==-1)
            throw new OperationNotSupportedException("El dni buscado no es de un cliente.");
        else
        {
            return coleccionHuesped[i];
        }
    }

    public static LocalDate leerFecha() {
        String dia;
        boolean diaCorrecto = false;
        DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print("Introduce el día (aaaa/mm/dd): ");
            dia = Entrada.cadena();
            try {
                LocalDate.parse(dia, formatoDia);
                diaCorrecto = true;
            } catch (DateTimeParseException e) {
                diaCorrecto = false;
            }
        } while (!diaCorrecto);
        return LocalDate.parse(dia, formatoDia);
    }
}
