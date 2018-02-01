package consultorio.negocio.dao;
import consultorio.negocio.entidades.*;
import java.util.*;
public interface IPaciente {
    public int insertar (Paciente doctor) throws Exception;
    public int modificar (Paciente doctor) throws Exception;
    public int eliminar (Paciente doctor) throws Exception;
    public Paciente obtener(String codigo) throws Exception;
    public ArrayList<Paciente> obtener () throws Exception;
}
