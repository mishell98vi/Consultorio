package consultorio.negocio.entidades;
public class Tratamiento {
    private Doctor doctor;
    private Paciente paciente;
    private String diagnostico;
    private String receta;
    private String tratamiento;

    public Tratamiento() {
    }

    public Tratamiento(Doctor doctor, Paciente paciente, String diagnostico, String receta, String tratamiento) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.tratamiento = tratamiento;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
}
