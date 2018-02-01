package consultorio.negocio.entidades;
public class Doctor {
    private String codigo;
    private String nombre;
    private String apellido;
    private String especiadlidad;
    private String horario;

    public Doctor() {
    }

    public Doctor(String codigo, String nombre, String apellido, String especiadlidad, String horario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especiadlidad = especiadlidad;
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

    public String getEspeciadlidad() {
        return especiadlidad;
    }

    public void setEspeciadlidad(String especiadlidad) {
        this.especiadlidad = especiadlidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
