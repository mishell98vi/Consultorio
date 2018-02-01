package consultorio.negocio.dao;
import consultorio.negocio.entidades.*;
import java.util.*;
public interface ITratamiento {
    public int insertar (Tratamiento doctor) throws Exception;
    public int modificar (Tratamiento doctor) throws Exception;
    public int eliminar (Tratamiento doctor) throws Exception;
    public Tratamiento obtener(String codigo) throws Exception;
    public ArrayList<Tratamiento> obtener () throws Exception;
}
