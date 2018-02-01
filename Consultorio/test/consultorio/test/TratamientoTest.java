
package consultorio.test;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.negocio.impl.*;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TratamientoTest {
    
    public TratamientoTest() {
    }
    @Test
    public void TestGeneral(){
        ITratamiento tratamientoDao = new ImplTratamiento();

// TEST INSERTAR
        int filas = 0;
        Paciente paci = new Paciente("1", "Jhon", "Loza", new Date(), new Date(), "Gripe");
        Doctor doc = new Doctor("1", "mishell","Viteri","Cardiologa","7 am a 5 pm");
        Tratamiento trata=new Tratamiento(doc, paci, "va a morir", "ninguna", "ninguno");
        try {
            filas = tratamientoDao.insertar(trata);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

//TEST OBTENER POR CODIGO

        Tratamiento nTratamiento = new Tratamiento();
        try {
            nTratamiento = tratamientoDao.obtener("1","1");
            System.out.println(nTratamiento.getDoctor().getNombre()+ "    " + nTratamiento.getPaciente().getNombre()+ "    " + nTratamiento.getDiagnostico()+ "    " + nTratamiento.getReceta()+ "    " + nTratamiento.getTratamiento());
        } catch (Exception e) {
        }
        assertEquals(nTratamiento!=null, true);

//TEST LISTADO

        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        try {
            tratamientos = tratamientoDao.obtener();
            System.out.println("\n\n");
            for (Tratamiento tratamiento : tratamientos) {
                System.out.println(tratamiento.getDoctor().getNombre()+ "    " + tratamiento.getPaciente().getNombre()+ "    " + tratamiento.getDiagnostico()+ "    " + tratamiento.getReceta()+ "    " + tratamiento.getTratamiento()+ "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(tratamientos.size()>0);
    }
    
}
