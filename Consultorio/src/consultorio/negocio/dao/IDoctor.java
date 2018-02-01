package consultorio.negocio.dao;
import consultorio.negocio.entidades.*;
import java.util.*;
public interface IDoctor {
    public int insertar (Doctor doctor) throws Exception;
    public int modificar (Doctor doctor) throws Exception;
    public int eliminar (Doctor doctor) throws Exception;
    public Doctor obtener(String codigo) throws Exception;
    public ArrayList<Doctor> obtener () throws Exception;
}
