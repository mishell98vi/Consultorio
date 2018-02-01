package consultorio.negocio.impl;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.accesoadatos.*;
import java.util.*;
import java.sql.*;
public class ImplTratamiento implements ITratamiento{
    @Override
    public int insertar(Tratamiento tratamiento) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Tratamiento (codigoD, codigoP, diagnostico, receta, tratamiento) Values (?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, tratamiento.getDoctor().getCodigo()));
        lstP.add(new Parametro(2, tratamiento.getPaciente().getCodigo()));
        lstP.add(new Parametro(3, tratamiento.getDiagnostico()));
        lstP.add(new Parametro(4, tratamiento.getReceta()));
        lstP.add(new Parametro(5, tratamiento.getTratamiento()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }
    @Override
    public int modificar(Tratamiento tratamiento) throws Exception {
        int nFilas=0;
        String csql="Update Tratamiento Set codigoD=?, codigoP=?, diagnostico=?, receta=?, tratameinto=? Where codigoD=? or codigoP=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, tratamiento.getDoctor().getCodigo()));
        lstPar.add(new Parametro(2, tratamiento.getPaciente().getCodigo()));
        lstPar.add(new Parametro(3, tratamiento.getDiagnostico()));
        lstPar.add(new Parametro(4, tratamiento.getReceta()));
        lstPar.add(new Parametro(5, tratamiento.getTratamiento()));
        lstPar.add(new Parametro(6, tratamiento.getDoctor().getCodigo()));
        lstPar.add(new Parametro(7, tratamiento.getPaciente().getCodigo()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutarComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de modificacion: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int eliminar(Tratamiento tratamiento) throws Exception {
        int nFilas=0;
        String csql="Delete from Tratamiento Where codigoP=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, tratamiento.getPaciente().getCodigo()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutarComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de Eliminacionn: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Tratamiento obtener(String codigoD, String codigoP) throws Exception {
        Tratamiento trata = null;
        Doctor doctor=null;
        IDoctor doctorDao=new ImplDoctor();
        Paciente paciente=null;
        IPaciente pacienteDao=new ImplPaciente();
        String csql = "Select codigoD, codigoP, diagnostico, receta, tratamiento From Tratamiento Where codigoD=? and codigoP=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoD));
        lstPar.add(new Parametro(2, codigoP));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                doctor=new Doctor();
                doctor=doctorDao.obtener(rst.getString(1));
                paciente=new Paciente();
                paciente=pacienteDao.obtener(rst.getString(2));
                trata=new Tratamiento();
                trata.setDoctor(doctor);
                trata.setPaciente(paciente);
                trata.setDiagnostico(rst.getString(3));
                trata.setReceta(rst.getString(4));
                trata.setTratamiento(rst.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return trata;
    }

    @Override
    public ArrayList<Tratamiento> obtener() throws Exception {
        ArrayList<Tratamiento> tratas = new ArrayList<>();
        Doctor doctor=null;
        IDoctor doctorDao=new ImplDoctor();
        Paciente paciente=null;
        IPaciente pacienteDao=new ImplPaciente();
        String csql="select codigoD, codigoP, diagnostico, receta, tratamiento from Tratamiento";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Tratamiento trata=null;
            while(rst.next()){
                doctor=new Doctor();
                doctor=doctorDao.obtener(rst.getString(1));
                paciente=new Paciente();
                paciente=pacienteDao.obtener(rst.getString(2));
                trata=new Tratamiento();
                trata.setDoctor(doctor);
                trata.setPaciente(paciente);
                trata.setDiagnostico(rst.getString(3));
                trata.setReceta(rst.getString(4));
                trata.setTratamiento(rst.getString(5));
                tratas.add(trata);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return tratas;
    }
}
