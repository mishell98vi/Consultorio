package consultorio.negocio.entidades;

public class Doctor {

    private String codigo;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String horario;

    public Doctor() {
    }

    public Doctor(String codigo, String nombre, String apellido, String especialidad, String horario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.horario = horario;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
