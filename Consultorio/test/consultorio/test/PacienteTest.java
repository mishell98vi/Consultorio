
package consultorio.test;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.negocio.impl.*;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PacienteTest {
    
    public PacienteTest() {
    }
    @Test
    public void TestGeneral(){
        IPaciente pacienteDao = new ImplPaciente();

// TEST INSERTAR
//        int filas = 0;
//        Paciente paci = new Paciente("1", "Jhon", "Loza", new Date(), new Date(), "Gripe");
//        try {
//            filas = pacienteDao.insertar(paci);
//            System.out.println("Ingreso de " + filas + " Filas Correctas");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);

//TEST OBTENER POR CODIGO

        Paciente nPaciente = new Paciente();
        try {
            nPaciente = pacienteDao.obtener("1");
            System.out.println(nPaciente.getCodigo()+ "    " + nPaciente.getNombre()+ "    " + nPaciente.getApellido()+ "    " + nPaciente.getFechaIng()+ "    " + nPaciente.getFechaSal()+ "    " + nPaciente.getEnfermedad());
        } catch (Exception e) {
        }
        assertEquals(nPaciente!=null, true);

//TEST LISTADO

        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            pacientes = pacienteDao.obtener();
            System.out.println("\n\n");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.getCodigo()+ "    " + paciente.getNombre()+ "    " + paciente.getApellido()+ "    " + paciente.getFechaIng()+ "    " + paciente.getFechaSal()+ "    " + nPaciente.getEnfermedad()+ "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(pacientes.size()>0);
    }
    
}
