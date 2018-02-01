package consultorio.negocio.entidades;

import java.util.*;

public class Paciente {
    private String codigo;
    private String nombre;
    private String apellido;
    private Date fechaIng;
    private Date fechaSal;
    private String enfermedad;

    public Paciente() {
    }

    public Paciente(String codigo, String nombre, String apellido, Date fechaIng, Date fechaSal, String enfermedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.enfermedad = enfermedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }


}
