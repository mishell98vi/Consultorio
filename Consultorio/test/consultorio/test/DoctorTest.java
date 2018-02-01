
package consultorio.test;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.negocio.impl.*;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoctorTest {
    
    public DoctorTest() {
    }
    @Test
    public void TestGeneral(){
        IDoctor doctorDao = new ImplDoctor();

// TEST INSERTAR
        int filas = 0;
        Doctor doc = new Doctor("1", "mishell","Viteri","Cardiologa","7 am a 5 pm");
        try {
            filas = doctorDao.insertar(doc);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

//TEST OBTENER POR CODIGO

        Doctor ndoctor = new Doctor();
        try {
            ndoctor = doctorDao.obtener("1");
            System.out.println(ndoctor.getCodigo()+ "    " + ndoctor.getNombre()+ "    " + ndoctor.getApellido()+ "    " + ndoctor.getEspeciadlidad()+ "    " + ndoctor.getHorario());
        } catch (Exception e) {
        }
        assertEquals(ndoctor!=null, true);

//TEST LISTADO

        ArrayList<Doctor> doctores = new ArrayList<>();
        try {
            doctores = doctorDao.obtener();
            System.out.println("\n\n");
            for (Doctor doctor : doctores) {
                System.out.println(doctor.getCodigo()+ "    " + doctor.getNombre()+ "    " + doctor.getApellido()+ "    " + doctor.getEspeciadlidad()+ "    " + doctor.getHorario()+ "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(doctores.size()>0);
    }
    
}
