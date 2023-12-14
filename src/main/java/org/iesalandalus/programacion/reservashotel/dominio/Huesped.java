package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;

public class Huesped {
    private String ER_TELEFONO;
    private String ER_CORREO;
    private String ER_DNI;
    public String FORMATO_FECHA;

    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;

    public String getNombre() {
    return nombre;
    }

    public void setNombre(String nombre){

    }

    private String formateaNombre(String nombre){

        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){


    }
    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){


    }

    public String getDni(){
        return dni;
    }

    private void setDni(String dni){


    }

    private boolean comprobarLetraDni(String dni){
        boolean resultado = true;

        return resultado;
    }

    private LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento){


    }

    private String getIniciales(){
        String inicales="ABC";

        return inicales;
    }


public Huesped(String nombre,String dni,String correo, String telefono,LocalDate fechaNacimiento){

    setNombre(nombre);
    setDni(dni);
    setCorreo(correo);
    setTelefono(telefono);
    setFechaNacimiento(fechaNacimiento);
}

public Huesped (Huesped huesped){

        setNombre(getNombre());
        setDni(getDni());
        setCorreo(getCorreo());
        setTelefono(getTelefono());
        setFechaNacimiento(getFechaNacimiento());
}
}


